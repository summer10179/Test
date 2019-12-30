package com.test.utils;

import com.alibaba.fastjson.JSONObject;
import com.test.client.RestfulClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseTest  extends TestApi{

    private static final Log logger = LogFactory.getLog(BaseTest.class);

//    public static AppApi appApi=null;
    public static RestfulClient httpclient=null;
    public static HashMap<String, String> headers=null;
    public static int responseCode;
    public static String url;
    public static JSONObject responseBody;
    public static List<NameValuePair> params = new ArrayList<NameValuePair>();
    public static Object[][] excelData;
    public static ExcelProcess excelProcess=new ExcelProcess();
    @AfterClass
    public static void afterClass(){
        httpclient.shutDownConnection();
    }

    @BeforeMethod
    public void beforeTest() {

        headers =new HashMap<String, String>();
//        如果设置不合适的请求头，请求结果可能会失败。最好的办法是抓包，
//        另外此处的headers 一定放的是request headers 千万不能添加不合适的response headers ,画蛇添足了
//        headers.put("Content-Type", "text/html; charset=UTF-8");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
        httpclient=new RestfulClient();

    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        logger.info("http:"+"=========case test finished,"+ result.getTestContext());

    }

}
