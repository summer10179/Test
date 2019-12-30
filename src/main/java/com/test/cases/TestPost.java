package com.test.cases;

import com.test.utils.BaseTest;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPost extends BaseTest {



    @BeforeTest
    public void beforeTest() {
        super.beforeTest();

        url = "https://www.apishop.net/common/Guest/login";
        params.add(new BasicNameValuePair("loginCall","17326055509"));
        params.add(new BasicNameValuePair("loginPassword","95b722835cc2b2c059e5fab5121dfd31"));
        params.add(new BasicNameValuePair("verifyCode","23132dae703d4094598ee2bcb4552d57"));

    }
    @Test
    public void testPost() throws IOException {

        httpclient.doPostRequest(url,params,headers);
        responseCode=httpclient.getResponseCode();
        responseBody=httpclient.getBodyInJSON();

        Assert.assertEquals(responseCode,200,"登陆失败");
        Assert.assertEquals(responseBody.get("type"),"guest","登陆类型不匹配");
        Assert.assertEquals(responseBody.get("statusCode"),"000000","登陆状态不正确");
    }

}
