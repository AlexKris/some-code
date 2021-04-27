package com.chris.some.code.study.network.io;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * 连接到8000端口后，想服务端写入一个带有时间戳的hello world/2秒
 *
 * @author grt
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    socket.getOutputStream().write((new Date() + ": hello world").getBytes(StandardCharsets.UTF_8));
                    Thread.sleep(2000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
