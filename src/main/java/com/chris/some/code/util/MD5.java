package com.chris.some.code.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * MD5加密
 */
public class MD5 {

    /**
     * 全局数组
     */
    private final static String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 返回形式为数字跟字符串
     *
     * @param bByte
     * @return
     */
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param bByte
     * @return
     */
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String getMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = strObj;
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (Exception e) {
            System.out.println("获取MD5加密Code失败！");
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * md5加密
     *
     * @param text
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String text) throws NoSuchAlgorithmException {
        byte[] bts;
        bts = text.getBytes(StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bts_hash = md.digest(bts);
        StringBuffer buf = new StringBuffer();
        for (byte b : bts_hash) {
            buf.append(String.format("%02X", b & 0xff));
        }
        return buf.toString();
    }

    /**
     * 将查询参数map以key为参数名按字典升序排序生成待签名字符串
     *
     * @param params
     * @return
     */
    public static String formatUrlMapASC(Map<String, String> params) {
        StringBuffer valueSb = new StringBuffer();
        // 将参数以参数名的字典升序排序
        Map<String, String> sortParams = new TreeMap<>(params);
        Set<Map.Entry<String, String>> entrys = sortParams.entrySet();
        // 遍历排序的字典,并拼接格式
        for (Map.Entry<String, String> entry : entrys) {
            if (NullUtils.isNullOrEmpty(entry.getValue())) {
                continue;
            } else {
                valueSb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        valueSb.deleteCharAt(valueSb.length() - 1);//删除最后一个"&"
        return valueSb.toString();
    }

}
