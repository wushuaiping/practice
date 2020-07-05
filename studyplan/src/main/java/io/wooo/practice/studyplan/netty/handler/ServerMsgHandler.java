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
        UserDto userDto = new Gson().fromJson((String) msg, UserDto.class);
        System.out.println("收到客户端消息：" + new Gson().toJson(userDto));
        // 处理成功客户端消息 向客户端回写消息
        ByteBuf buffer = ctx.alloc().buffer();
        String returnMsg = "SUCCESS";
        buffer.writeBytes(returnMsg.getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(buffer);
        System.out.println("向客户端回写消息");
    }
}
