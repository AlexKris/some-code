package com.chris.some.code.study.network.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * Netty服务端启动流程
 * <pre>
 *     创建引导类，指定线程模型，IO模型，连接读写处理逻辑，绑定端口后，服务端启动成功
 *     bind绑定方法是异步的，可以通过异步机制实现端口递增绑定
 *     可以通过attr()和childAttr()给服务端或者客户端Channel设置自定义属性
 *     可以通过option()和childOption()给服务端Channel设置属性或者客户端Channel设置底层TCP参数
 * </pre>
 *
 * @author grt
 */
public class NettyServerDemo {
    public static void main(String[] args) {
        // 监听端口，accept新连接的线程组
        NioEventLoopGroup receiveGroup = new NioEventLoopGroup();
        // 处理每一条连接的数据读写的线程组
        NioEventLoopGroup processGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(receiveGroup, processGroup)
                // 指定IO模型
                .channel(NioServerSocketChannel.class)
                // BIO
//                .channel(OioServerSocketChannel.class)
                // attr() 给channel维护一个map，使用channel.attr()取出属性
                .attr(AttributeKey.newInstance("serverName"), "nettyServer")
                .childAttr(AttributeKey.newInstance("clientKey"), "clientValue")
                // option() 给服务端channel设置属性
                // ChannelOption.SO_BACKLOG 表示系统用于联试存放已完成三次握手的请求的队列的最大长度，如果连接简历频繁，服务器处理创建新连接较慢，可以适当调大
                .option(ChannelOption.SO_BACKLOG, 1024)
                // childOption() 可以给每条连接设置一些TCP底层相关的属性
                // ChannelOption.SO_KEEPALIVE 是否开启TCP底层心跳机制 true为开启
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                /*
                ChannelOption.TCP_NODELAY 是否开启Nagle算法 true表示关闭
                如果要求高实时性，有数据发送时就马上发送，则关闭
                如果需要减少发送次数减少网络交互，则开启
                 */
                .childOption(ChannelOption.TCP_NODELAY, true)
                // handler() 用于指定在服务端启动过程中的逻辑
                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel ch) throws Exception {
                        System.out.println("服务端启动中");
//                        Attribute<Object> serverName = ch.attr(AttributeKey.newInstance("serverName"));
//                        System.out.println("serverName = " + serverName);
                    }
                })
                // childHandler() 用于指定处理新连接数据的读写处理逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    // ChannelInitializer 定义后续每条连接的数据读取
                    // NioSocketChannel Netty对NIO类型的连接的抽象
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
//                        Attribute<Object> clientKey = ch.attr(AttributeKey.newInstance("clientKey"));
//                        System.out.println("clientKey = " + clientKey);
                        // 指定连接数据读写逻辑
                        ch.pipeline().addLast(new FirstServerHandler());
                    }
                });
        bind(serverBootstrap, 8000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port)
                .addListener(new GenericFutureListener<Future<? super Void>>() {
                    @Override
                    public void operationComplete(Future<? super Void> future) throws Exception {
                        // 监听端口是否绑定成功
                        if (future.isSuccess()) {
                            System.out.println("端口[" + port + "]绑定成功！");
                        } else {
                            System.err.println("端口[" + port + "]绑定失败！");
                            // 自动递增绑定端口
                            bind(serverBootstrap, port + 1);
                        }
                    }
                });
    }
}
