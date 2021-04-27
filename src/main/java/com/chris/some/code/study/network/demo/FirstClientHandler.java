package com.chris.some.code.study.network.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * 继承ChannelInboundHandlerAdapter的客户端逻辑处理器
 * channelActive() 方法会在客户端连接建立成功后被调用，在此方法中编写向服务端写数据的逻辑
 * 写数据：
 * <pre>
 *     1、获取一个Netty对二进制数据的抽象ByteBuf，ctx.alloc()获取一个ByteBuf的内存管理器，作用是分配一个ByteBuf
 *     2、把字符串的二进制数据填充到ByteBuf以获取Netty需要的数据格式
 *     3、调用ctx.channel().writeAndFlush()把数据写到服务端
 * </pre>
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + "：客户端写出数据");
        // 1、获取数据
        ByteBuf buf = getBuf(ctx);
        // 2、写数据
        ctx.channel().writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 客户端读数据逻辑
        ByteBuf buf = (ByteBuf) msg;
        System.out.println(new Date() + "：客户端读到数据 ->" + buf.toString(StandardCharsets.UTF_8));
    }

    private ByteBuf getBuf(ChannelHandlerContext ctx) {
        // 1、获取二进制抽象 ByteBuf
        ByteBuf buf = ctx.alloc().buffer();
        // 2、准备数据，指定字符串的字符集为 utf-8
        byte[] bytes = "你好！".getBytes(StandardCharsets.UTF_8);
        // 3、填充数据到 ByteBuf
        buf.writeBytes(bytes);
        return buf;
    }
}
