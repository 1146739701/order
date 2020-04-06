package com.lesson.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class downloadUrl {

    public static void main(String[] args) throws IOException {
        //1、参数为请求的目的地址
        URL url = new URL("http://onlinetraining.clpsgroup.com.cn/HMTS/util/pdf!toPDFViewPage.do?method=getPointPDFFile&pointId=116&pointFileType=1&fileName=");

        //2、连接到这个资源HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        //3、将资源写入目标对象test
        FileOutputStream fos = new FileOutputStream("fff.pdf");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        //4、关闭资源
        fos.close();
        inputStream.close();
        urlConnection.disconnect();

    }
}