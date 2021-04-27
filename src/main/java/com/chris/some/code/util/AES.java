package com.chris.some.code.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*
 * AES对称加密和解密
 *
 */
public class AES {
    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            throw new Exception("Key为空null");
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            throw new Exception("Key长度不是16位");
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return Base64.encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                throw new Exception("Key为空null");
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                throw new Exception("Key长度不是16位");
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = Base64.decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                throw new Exception(e);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception(ex);
        }
    }

    public static void main(String[] args) throws Exception {
        String cKey = "pa9cJEzkkbG9FGnb";

        // 加密
        System.out.println("加密后的字串是：" + AES.Encrypt("362330198207240736", cKey));

        // 解密
        System.out.println("解密后的字串是：" + AES.Decrypt("w1wD2aWf7gXlcbVsAXfjoA==", cKey));
        System.out.println("解密后的字串是：" + AES.Decrypt("EeKfJ++dFAyIVU46vNu8wuo0+BoT+OqnngsXW2K/DJc=", cKey));
    }
}
