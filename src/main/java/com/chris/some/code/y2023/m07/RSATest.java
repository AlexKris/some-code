package com.chris.some.code.y2023.m07;

import com.chris.some.code.util.RSAUtils;

import java.util.Map;

public class RSATest {

    public static void main(String[] args) throws Exception {
    }

    public static void encryptByPub(String data, String pubKey) throws Exception {
        // 公钥加密
        String encryptedData = RSAUtils.encryptByPublicKey(data, pubKey);
        System.out.println("encryptedData = " + encryptedData);
    }

    public static void decryptByPri(String encryptData, String priKey) throws Exception {
        // 私钥解密
        String decryptedData = RSAUtils.decryptByPrivateKey(encryptData, priKey);
        System.out.println("decryptedData = " + decryptedData);
    }

    public static void genKey() {
        Map<String, String> keyMap = RSAUtils.generateKey();
        String publicKeyStr = keyMap.get("publicKeyStr");
        String privateKeyStr = keyMap.get("privateKeyStr");
        System.out.println("-----------------生成的公钥和私钥------------------------------");
        System.out.println("获取到的公钥：" + publicKeyStr);
        System.out.println("获取到的私钥：" + privateKeyStr);
    }
}
