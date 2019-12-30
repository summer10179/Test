package com.test.cases;

import com.test.utils.BaseTest;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestPostExcle extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        super.beforeTest();
        //读取用例excel
        excelData= excelProcess.proessExcel(excelPath,0);
        url = "https://www.apishop.net/common/Guest/login";
    }
    @Test
    public void testPostExcle() throws IOException {
        SoftAssert softAssert =new SoftAssert();
        //从第二行开始遍历表单，跳过表头
        for (int i=1;i<excelData.length;i++){
            //从特定位置读取测试数据
            String loginCall =excelData[i][0].toString();
            String loginPassword =excelData[i][1].toString();
            String verifyCode =excelData[i][2].toString();
            //  设置请求参数
            params.add(new BasicNameValuePair("loginCall",loginCall));
            params.add(new BasicNameValuePair("verifyCode",verifyCode));
            params.add(new BasicNameValuePair("loginPassword",loginPassword));

            httpclient.doPostRequest(url,params,headers);
            responseCode=httpclient.getResponseCode();
            responseBody=httpclient.getBodyInJSON();

            softAssert.assertEquals(responseCode,200,"登陆失败");
            softAssert.assertEquals(responseBody.get("type"),"guest","登陆类型不匹配");
            softAssert.assertEquals(responseBody.get("statusCode"),"000000","登陆状态不正确");
        }
        softAssert.assertAll();
    }

}
