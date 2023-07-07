package com.chris.some.code.y2023.m07;

import java.util.Map;

public class TestRsa {

    public static void main(String[] args) throws Exception {
//        genKey();
        String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjHf+r9dDZJP8p+gGwmK3UIQA+dGZFxBwcTy2CgCXsNeNE0FMNY5uork3OwAw5b6ZU+yIvZHdwDD43NqlLusFcAzutRECcnhwb6NUsch2viBi1a4y/gr/eh4ZCXbfrKlaarC6iVaVXfHVjwoCmX43HzGHOxRLCWoemALFGk85aoxBZIVAQ6fp/eWdk++ZxPPYG+kroK2wCmhTiZWcLnrSsaLyTAHoIFg3TgCr8kUuMx8olsNhD0t3pMGruNbnJSuH9FFhj/d64CpkZntc4cufwaO+wDkeNAIcs8s6yvEme3g+KJ0LevUGoKVxIb4MOcziLph9Wunuxte09jIp9DXc6wIDAQAB";
        String priKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCMd/6v10Nkk/yn6AbCYrdQhAD50ZkXEHBxPLYKAJew140TQUw1jm6iuTc7ADDlvplT7Ii9kd3AMPjc2qUu6wVwDO61EQJyeHBvo1SxyHa+IGLVrjL+Cv96HhkJdt+sqVpqsLqJVpVd8dWPCgKZfjcfMYc7FEsJah6YAsUaTzlqjEFkhUBDp+n95Z2T75nE89gb6SugrbAKaFOJlZwuetKxovJMAeggWDdOAKvyRS4zHyiWw2EPS3ekwau41uclK4f0UWGP93rgKmRme1zhy5/Bo77AOR40AhyzyzrK8SZ7eD4onQt69QagpXEhvgw5zOIumH1a6e7G17T2Min0NdzrAgMBAAECggEAWJ5zfXgvOkrqwPtvGD+zKwa8nt8O2DA04BvPNOw+xwCWLimp7LfZMKvtHjn2n1rp3LqDYiWeYtwChUMjpz/6hECEcJM0mgdF2AiRLEAuObCw6eImpYNGvkIyxXfLkWCefGTWqkKHpWcmtkE4dqHcIL/ccvdQh7X9ayWEOB73ODInzaPAdX9D1sRukzpWrAGVVLNGDQ5CV6sn6B9It92e5fCKvbZS0/oa1+OhMpdCF583iiHUkkr/ZtFj3uwx+87/RfM2Fm5321/aHmxwe4X4+IVOKpmd9Jr8PXOJyN3qhagvnljJvxUOuEX2QWKdG8NX7Hct1Y1LAXnI7ROiZE0y4QKBgQDQf/08LUfvJE63VIt0rgc0/fWWRKMZUpPF9AeU/TS74cURpJo77kuDTlyOZu7f1AjhQo8kPdzm7qOrNM8M5yTyNmg8SGFyh5nEzFEbzax9qUigKUMd0ekJi+4HgsCDgmXID8LEm84oj+UgZu7I2P1MWRMW997i/lD0RLgGLpwRuQKBgQCseFQqndM/bbErICrPkX4h+EPvHJZgC9d6aCzNNOy9Ja+7sC2anypeUY2+k0v5Z3Zg1IYTD5Lv2ntnrdlCy2MuOVUELmhJcim71Z0kEJPBjUcBN5LeplL5UkpmqGXQdZ51gwMdzA1Cj2DvljYqVjhpcOy5b+owjpR7ua8LY7nFwwKBgQCfQ7Ufm4MgRD6wwa8JAMpWi0tmbqWbeT2R71c/Uq9OeSX81RxPfTZHZbtDt5LufNwPnbUTvQGZkV6KL/uc4o+RSUgUDEILp1MpRd0K/O+uyXnFhd9Tzv1Qooe/SvxdOGUhDhD79/vhdhFSz+3ElCPghwYS/GJQSG10OW3MoxvqWQKBgHCtLE+rTJfj0huaqF1zcDRBPiC5TITzN5OA+8QVD5WDSYwVTbX2xndYUIJxOPF35p7cObu6MQUCeB0ENyysM9+/FQvmRbu2Gg3dQQyOx/lrkzf4VrufbhX07SakXeAS97NOJHsTFJanlWzxdfGy4qgAXqfHtfiDLf6nEPUf8f6BAoGAeVaGV2vQvXPiLviHRGkajlA+7CYSag69AHSJqG9GYG+Ms5GnqGBcpe1VAVO03vphbW/JbdotOencKaZXlF1+AdUcznuf9z2nutnZ9XiCrjzNsrN/mwVgQqPBXAI/xM5fhYQIWRFAbM8zr9DxYFIMuxuQSU+fhbx7+k8YX+n5BKo=";
        // 加密
        String name = "大鹏";
        String idNo = "123214125125123213";
//        String encryptedName = RsaUtil.encryptByPrivateKey(name, priKey);
//        System.out.println("encryptedName = " + encryptedName);
//        String encryptedIdNo = RsaUtil.encryptByPrivateKey(idNo, priKey);
//        System.out.println("encryptedIdNo = " + encryptedIdNo);
//        encryptByPub(name, pubKey);
//        encryptByPub(idNo, pubKey);
        String encryptedName = "bbiwgEO9ZDALv5TM30jM3RX4PXIs5chDplTvBP6sXwjHwgcbhYzKlBNCIlIuDYq8t8trIosONwgTFPwR4qdEGQMVS/bMgD3vPWcYbKe/nx/ZnFl3cjYXB+2pJWyBpXH9Me7A3s0LrOELw+AR/dR03+cGfSUyb+8snYbRHJ7j/CNcqVIi2aghzrLwCxgo3ghMU8IDbdAqcMkQZNZLyQvW1+XL5lWFOKnMOkRGfn24qr5di5cSlR46iU2fvme28qqL+KtPJ7W+cEPwPsxdpDTI0nc07ea8zpDs+zuI+llJ+otwt++VAMmnRsOmcsnzH0TG1p387sdptewCuWj/CAz3pA==";
        String encryptedIdNo = "RRl2atg0bNK8mnJ/3CvLwQ2L+F+z4F9DLqM8A2814ko3rV5Acmxf9X9KErozHSaA5rOA3JbaXFp/skr6Shfry+L9DnKP/yWYx2spj4c1AvMcoxBGoDORaplOku9fM59iMRpsQunJD6SLTj8zk/UmEKi57jAkHkRoOOaKB8AstRyCTBkK5M0XnBjtyGXrI7n0qwRqfXYrMKufmjaBW0ypx78xV0QAqIynGo61XQ8/ohOap/oxXg5ePlDpqlsmwDsL3dUmGs4Yt80CPr9+JT4FALy+VakZE2Ar8hHpeL11Kbd7VBbmKEAveKz/v4e+uOVhVLFANbLfK4ole/skSTWPDw==";
        decryptByPri(encryptedName, priKey);// 大鹏
        decryptByPri(encryptedIdNo, priKey);// 123214125125123213

    }

    public static void encryptByPub(String data, String pubKey) throws Exception {
        // 公钥加密
        String encryptedData = RsaUtil.encryptByPublicKey(data, pubKey);
        System.out.println("encryptedData = " + encryptedData);
    }

    public static void decryptByPri(String encryptData, String priKey) throws Exception {
        // 私钥解密
        String decryptedData = RsaUtil.decryptByPrivateKey(encryptData, priKey);
        System.out.println("decryptedData = " + decryptedData);
    }

    public static void genKey() {
        Map<String, String> keyMap = RsaUtil.generateKey();
        String publicKeyStr = keyMap.get("publicKeyStr");
        String privateKeyStr = keyMap.get("privateKeyStr");
        System.out.println("-----------------生成的公钥和私钥------------------------------");
        System.out.println("获取到的公钥：" + publicKeyStr);
        System.out.println("获取到的私钥：" + privateKeyStr);
    }
}
