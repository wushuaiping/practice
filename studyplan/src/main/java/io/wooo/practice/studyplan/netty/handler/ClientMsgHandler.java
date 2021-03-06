package io.wooo.practice.studyplan.netty.handler;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wooo.practice.studyplan.netty.pojo.UserDto;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientMsgHandler extends ChannelInboundHandlerAdapter {

    /**
     * 向服务端写消息
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  向服务端发送数据");
        ByteBuf buffer = ctx.alloc().buffer();
        UserDto userDto = new UserDto("1", "吴帅苹");
        String userJson = new Gson().toJson(userDto);
        byte[] bytes = userJson.getBytes(StandardCharsets.UTF_8);
        buffer.writeBytes(bytes);
        ctx.channel().writeAndFlush(buffer);
    }

    /**
     * 读取服务端回写的消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        String json = byteBuf.toString(StandardCharsets.UTF_8);
        System.out.println("收到服务端回写消息：" + json);
    }
}
