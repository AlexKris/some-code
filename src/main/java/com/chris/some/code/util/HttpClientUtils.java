package com.chris.some.code.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class HttpClientUtils {

    public static String httpPostJson(String url, String param) {
        HttpClient client = createSSLClientDefault();
        HttpPost httpPost = new HttpPost(url);
        if (!NullUtils.isNullOrEmpty(param)) {
            // 标识出传递的参数是 application/json
            StringEntity stringEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
        }

        try {
            HttpResponse httpResponse = client.execute(httpPost);
            return EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CloseableHttpClient createSSLClientDefault() {
        try {
            // 使用 loadTrustMaterial() 方法实现一个信任策略，信任所有证书
            // 信任所有
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
            // NoopHostnameVerifier类:  作为主机名验证工具，实质上关闭了主机名验证，它接受任何
            // 有效的SSL会话并匹配到目标主机。
            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }
}
