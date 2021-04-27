package com.chris.some.code.study.network.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统IO实现服务端
 * <pre>
 *     1、首先创建了一个serverSocket监听8000端口
 *     2、创建了第一个线程，不断调用阻塞方法serverSocket.accept()获取新的连接
 *     3、当获取到新的连接后，给每条连接创建一个新的线程，负责从该连接中以字节流的方式读取数据
 * </pre>
 *
 * @author grt
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        // 接收新连接线程
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
                    // 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1)
                                System.out.println(new String(data, 0, len));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
