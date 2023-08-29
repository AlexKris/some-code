package com.chris.some.code.y2023.m08;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ReadByteTest {

    public static void main(String[] args) {
        String path = "/Users/admin/Downloads/NO2203864/NO2203864_IDENTITY/10fd2d88-5f75-4540-a1ef-a88ce7312399.jpg";
        byte[] bytes2 = image2byte(path);
    }

    public static byte[] image2byte(String path) {
        try (FileImageInputStream input = new FileImageInputStream(new File(path));
             ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            return output.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
