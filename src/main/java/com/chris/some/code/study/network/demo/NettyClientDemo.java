package com.chris.some.code.study.network.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Netty客户端启动流程
 * <pre>
 *     创建引导类，指定线程模型，IO模型，连接读写处理逻辑，连接上特定的主机和端口
 *     connect方法是异步的，可以通过异步回调机制来实现指数退避重连逻辑
 *     可以通过attr()给客户端Channel绑定自定义属性
 *     可以通过option()给客户端Channel设置底层TCP参数
 * </pre>
 *
 * @author grt
 */
public class NettyClientDemo {

    public static final int MAX_RETRY = 10;

    public static void main(String[] args) {
        NioEventLoopGroup clientGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        // 指定线程组
        bootstrap.group(clientGroup)
                // 指定IO类型为NIO
                .channel(NioSocketChannel.class)
                // BIO
//                .channel(OioSocketChannel.class)
                // attr() 设置属性，后续在将NioSocketChannel通过参数传输的时候，可以通过Channel取出设置的属性
                .attr(AttributeKey.newInstance("clientName"), "nettyClient")
                // 给连接设置一些TCP底层相关的属性
                // ChannelOption.CONNECT_TIMEOUT_MILLIS 设置超时连接时间
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                // ChannelOption.SO_KEEPALIVE 是否开启TCP底层心跳机制 true为开启
                .option(ChannelOption.SO_KEEPALIVE, true)
                /*
                ChannelOption.TCP_NODELAY 是否开启Nagle算法 true表示关闭
                如果要求高实时性，有数据发送时就马上发送，则关闭
                如果需要减少发送次数减少网络交互，则开启
                 */
                .option(ChannelOption.TCP_NODELAY, true)
                // IO处理逻辑
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        // 指定连接数据读写逻辑
                        // ch.pipeline() 返回的是和这条连接相关的逻辑处理器，采用了责任链模式
                        // addLast() 添加一个逻辑处理器，在客户端建立连接成功后，向服务端写数据
                        ch.pipeline().addLast(new FirstClientHandler());
                    }
                });
        // 建立连接
        connect(bootstrap, "127.0.0.1", 8000, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                // 连接成功，打印连接成功的信息
                System.out.println("连接成功！");
            } else if (retry == 0) {
                // 连接失败但是重试次数已经用完，放弃连接
                System.out.println("重试次数已用完，放弃连接！");
            } else {
                // 连接失败但是重试次数没有用完，则计算下一次重连间隔delay，然后定时重连
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连间隔 0001=1 order=1时0010=2 order=2时0100=4
                int delay = 1 << order;
                System.out.println(new Date() + "：连接失败，第" + order + "次重连......");
                // 重新连接
                // config() 方法返回BootstrapConfig，是对Bootstrap配置参数的抽象
                // group()返回的配置的线程模型clientGroup，调用clientGroup的schedule()方法实现定时任务逻辑
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
            }
        });
    }
}
