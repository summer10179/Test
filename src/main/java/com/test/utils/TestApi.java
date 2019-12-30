package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestApi {
    public Properties prop;
    public String excelPath;
    public String host;
    //构造函数
    public TestApi() {
        try {
//          数据流的形式读取配置文件
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/resources/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        host = prop.getProperty("Host");

        excelPath = prop.getProperty("testData").replace("\\", File.separator);
    }
}
