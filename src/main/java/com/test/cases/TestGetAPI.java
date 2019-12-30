package com.test.cases;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * url是我们去进行get请求的地址；
 * httpClient是用来发送http请求的HttpClient实例；
 * httpGet是get请求的一个实例；
 * httpResponse用来存储我们接收到的反馈；
 * responseBody用来存储反馈的主体信息；
 * responseCode用来存储反馈的状态码；
 * responseHeader用来存储反馈的头部信息；
 */
public class TestGetAPI {



    public static void main(String[] args) throws IOException {
        String url;
        CloseableHttpClient  httpClient;
        HttpGet httpGet;
        CloseableHttpResponse httpResponse;
        HttpEntity responseBody;
        int responseCode;
        Header[] responseHeader;


//        url="https://www.apishop.net/common/Guest/login";
        url="https://login.hipac.cn/sso/login.do?app=crm_new&app_=f2aac3ed3fbcf719b4c632f397cf4b71&returnURL=https://iwork.hipac.cn/crm/index.html";
        httpClient=HttpClients.createDefault();
        httpGet=new HttpGet(url);
        httpResponse=httpClient.execute(httpGet);
        responseCode =httpResponse.getStatusLine().getStatusCode();
        responseBody =httpResponse.getEntity();
        responseHeader=httpResponse.getAllHeaders();

        String responseBodyString= EntityUtils.toString(responseBody,"utf-8");

        Map<String,String> map= new HashMap<String,String>();
        for (Header header:responseHeader){
            map.put(header.getName(),header.getValue());
        }


        System.out.println("This is the response code:" + responseCode);
//        System.out.println("This is the response body:" + responseBodyString);
        System.out.println("This is the response header in hash" + map);
    }



}
