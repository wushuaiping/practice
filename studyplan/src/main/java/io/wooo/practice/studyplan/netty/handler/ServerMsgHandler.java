package io.wooo.practice.studyplan.netty.handler;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wooo.practice.studyplan.netty.pojo.UserDto;
import io.wooo.practice.studyplan.netty.protocol.Packet;
import io.wooo.practice.studyplan.netty.protocol.PacketCodeC;

import java.nio.charset.StandardCharsets;

public class ServerMsgHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf byteBuf = (ByteBuf) msg;
        PacketCodeC.INSTANCE.decode(byteBuf);
    }
}
