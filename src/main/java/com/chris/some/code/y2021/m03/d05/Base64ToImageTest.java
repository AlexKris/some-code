package com.chris.some.code.y2021.m03.d05;

import java.io.*;
import java.util.Base64;

public class Base64ToImageTest {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/Users/alex/Downloads/base64图片的副本.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        System.out.println(GenerateImage(str));
    }

    // 对字节数组字符串进行Base64解码并生成图片
    public static boolean GenerateImage(String imgStr) {
        // 图像数据为空
        if (imgStr == null) return false;
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // Base64解码
            byte[] b = decoder.decode(imgStr);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // 生成jpg图片
            String imgFilePath = "/Users/alex/Downloads/new.jpg";
            // 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
