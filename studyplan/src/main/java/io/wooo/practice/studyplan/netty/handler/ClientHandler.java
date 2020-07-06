package io.wooo.practice.studyplan.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wooo.practice.studyplan.netty.protocol.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author wushuaiping
 * @date 2020/7/6 11:23 上午
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "客户端登陆");
//
//        LoginRequestPacket loginRequest = new LoginRequestPacket();
//        loginRequest.setUserId(UUID.randomUUID().toString());
//        loginRequest.setUsername("wsp");
//        loginRequest.setPassword("123");
//
//        ByteBuf buffer = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginRequest);
//        ctx.channel().writeAndFlush(buffer);
//    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);
        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket responsePacket = (LoginResponsePacket) packet;
            if (responsePacket.isSuccess()) {
                System.out.println(format + " 客户端登陆成功");
            } else {
                System.out.println(format + " 客户端登陆失败，原因：" + responsePacket.getReason());
            }
        } else if (packet instanceof MessageResponsePacket) {
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            String message = messageResponsePacket.getMessage();
            System.out.println(format + " 收到服务端回复：" + message);
        }
    }
}
