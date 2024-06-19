package com.chris.some.code.y2024.m05;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

public class AESTest {

    private static AES aes;

    private static String decrypt(String value) {
        if (value == null) {
            return null;
        }
        return getEncryptor().decryptStr(value);
    }

    public static String encrypt(String rawValue) {
        if (rawValue == null) {
            return null;
        }
        return getEncryptor().encryptBase64(rawValue);
    }

    private static AES getEncryptor() {
        if (aes != null) {
            return aes;
        }
        // 构建 AES
        String password = "XDV71a+xqStEA3WH";
        aes = SecureUtil.aes(password.getBytes());
        return aes;
    }

    public static void main(String[] args) {
        String encrypt = encrypt("13600000000");
        System.out.println("encrypt = " + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("decrypt = " + decrypt);
    }

}
