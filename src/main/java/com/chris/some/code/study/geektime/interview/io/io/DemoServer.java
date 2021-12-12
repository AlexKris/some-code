package com.chris.some.code.study.geektime.interview.io.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {

    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(0);
            while (true) {
                Socket socket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
