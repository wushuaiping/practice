package io.wooo.practice.studyplan.netty.handler;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wooo.practice.studyplan.netty.pojo.UserDto;

import java.nio.charset.StandardCharsets;

public class ServerMsgHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf byteBuf = (ByteBuf) msg;
        String json = byteBuf.toString(StandardCharsets.UTF_8);
        UserDto userDto = new Gson().fromJson(json, UserDto.class);
        System.out.println("收到客户端消息" + new Gson().toJson(userDto));
    }
}
