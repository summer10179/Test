package com.test.cases;


import com.test.client.RestfulClient;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class TestGet {

    RestfulClient client;
    String url="http://jump.hipac.cn/login/";
    int responseCode;
    String responseBody;
    @BeforeTest
    public void beforeTest() throws IOException {
        client=new RestfulClient();
        client.doGetRequest(url);
        responseCode=client.getResponseCode();
        responseBody=client.getBody();

        System.out.println(responseCode);
//        System.out.println(responseBody);
    }

    @Test
    public void testResult(){
        Assert.assertEquals(responseCode,200,"接口请求失败");
    }
}
