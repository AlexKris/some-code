package com.chris.some.code.study.network.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * 继承ChannelInboundHandlerAdapter的服务端逻辑处理器
 * channelRead() 方法在接收到客户端发来的数据后被回调
 * msg参数指Netty里数据读写的载体
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    public static void main(String[] args) {
        int n = 10, hash = 10;
        // 10 - 1 = 9 1001
        // 10         1010
        //            1000
        //            1011
        System.out.println((n - 1) & hash);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接收数据逻辑
        ByteBuf readBuf = (ByteBuf) msg;
        System.out.println(new Date() + "：服务端读到数据 ->" + readBuf.toString(StandardCharsets.UTF_8));
        // 回复数据逻辑
        System.out.println(new Date() + "：服务端写出数据");
        ByteBuf writeBuf = getBuf(ctx);
        ctx.channel().writeAndFlush(writeBuf);
    }

    private ByteBuf getBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "你好，欢迎连接！".getBytes(StandardCharsets.UTF_8);
        ByteBuf buf = ctx.alloc().buffer();
        buf.writeBytes(bytes);
        return buf;
    }
}
