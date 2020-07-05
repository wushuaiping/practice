package io.wooo.practice.studyplan.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.wooo.practice.studyplan.netty.handler.ClientMsgHandler;

/**
 * @author wushuaiping
 * @date 2020/7/2 2:44 下午
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new ClientMsgHandler());
                    }
                })
                .connect("127.0.0.1", 8000)
                .addListener(future -> {
                    if (future.isSuccess()){
                        System.out.println("连接服务端成功");
                    }else {
                        System.out.println("连接服务端失败");
                    }
                });
    }
}
