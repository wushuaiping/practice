package io.wooo.practice.studyplan.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wooo.practice.studyplan.netty.protocol.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wushuaiping
 * @date 2020/7/6 11:23 上午
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "服务端收到登陆请求");

        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequest = (LoginRequestPacket) packet;
            LoginResponsePacket loginResponse = new LoginResponsePacket();
            loginResponse.setVersion(packet.getVersion());
            if (loginRequest.getUsername().equals("wsp") && loginRequest.getPassword().equals("123")) {
                loginResponse.setSuccess(true);
                System.out.println("登陆成功");
            } else {
                loginResponse.setReason("登陆失败");
                loginResponse.setSuccess(false);
                System.out.println("登陆失败");
            }
            // 回写客户端
            ByteBuf encode = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponse);
            ctx.channel().writeAndFlush(encode);
        } else if (packet instanceof MessageRequestPacket) {
            MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;
            String message = messageRequestPacket.getMessage();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 收到客户端消息：" + message);
            // 回写客户端
            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setMessage("服务端回复：" + message);
            ByteBuf encode = PacketCodeC.INSTANCE.encode(ctx.alloc(), messageResponsePacket);
            ctx.channel().writeAndFlush(encode);
        }
    }
}
