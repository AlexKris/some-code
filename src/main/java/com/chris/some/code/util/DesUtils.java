package com.chris.some.code.util;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class DesUtils {

    Cipher enCipher;
    Cipher deCipher;
    byte[] salt = {(byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03};

    /**
     * 将用户的apikey传入
     *
     * @param apiKey
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     */
    public DesUtils(String apiKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        // 设置算法为md5和DES加解密
        int iterationCount = 2;
        KeySpec keySpec = new PBEKeySpec(apiKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        enCipher = Cipher.getInstance(key.getAlgorithm());
        deCipher = Cipher.getInstance(key.getAlgorithm());
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
        // 初始化加密算法对象
        enCipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        // 初始化解密算法对象
        deCipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
    }

    /**
     * 加密str字符串
     *
     * @param str
     * @return
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public String encrypt(String str) throws BadPaddingException, IllegalBlockSizeException {
        // 设置编码utf-8
        str = new String(str.getBytes(), StandardCharsets.UTF_8);
        return Base64.encode(enCipher.doFinal(str.getBytes()));
    }

    /**
     * 解密字符串str
     *
     * @param str
     * @return
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public String decrypt(String str) throws BadPaddingException, IllegalBlockSizeException {
        return new String(deCipher.doFinal(Base64.decode(str)), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        String apiKey = "12345678";
        DesUtils des = new DesUtils(apiKey);
        System.out.println(des.decrypt("GPYmzr7oWTeL5nj415+POkCJ6V+YZbdZ"));
    }
}
