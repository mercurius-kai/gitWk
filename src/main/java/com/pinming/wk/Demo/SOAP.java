package com.pinming.wk.Demo;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangkai
 * @date 2020-08-21 17:33
 */
public class SOAP {
    public static void main(String[] args) throws IOException {
        String url = "http://120.189.155.124:733/VehicleWebService.asmx";
        int timeout = 10000;
        String username = "1001575";
        String password = "gfAH90QrGh9EhRpiZhf9Gg==";
        StringBuffer sb = new StringBuffer("");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String myDateTime = df.format(new Date());
        String deviceSn = "cljc5";
        String fileUrl = "https://pmbimcloud-test-company.oss-cn-hangzhou.aliyuncs.com/ac0900f5-9377-2c92-9f92-4e63306351a7.png?Expires=1599816865&OSSAccessKeyId=LTAI8PPrIEVEAQCK&Signature=YvIJhotlU%2F3tyOWVScXYQ5cg3%2BM%3D";
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb.append("<soap12:Envelope "
                + "xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "
                + "xmlns:xsd='http://www.w3.org/2001/XMLSchema' "
                + "xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>\n");
        sb.append("<soap12:Header>\n");
        sb.append("<MessageHeader xmlns=\"http://tempuri.org/\">\n");
        sb.append("<USERNAME>" + username + "</USERNAME>\n");
        sb.append("<PASSWORD>" + password + "</PASSWORD>\n");
        sb.append("</MessageHeader>\n");
        sb.append("</soap12:Header>\n");
        sb.append("<soap12:Body>\n");
        sb.append("<SetPhoto xmlns=\"http://tempuri.org/\">\n");
        sb.append("<deviceID>" + deviceSn + "</deviceID>\n");
        sb.append("<myDateTime>" + myDateTime + "</myDateTime>\n");
        sb.append("<photoUrl> <![CDATA[" + fileUrl + "]]></photoUrl>\n");
        sb.append("</SetPhoto>\n");
        sb.append("</soap12:Body>\n");
        sb.append("</soap12:Envelope>\n");
        System.out.println(sb);
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        // ??????????????????
        client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
        // ????????????????????????
        client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
        // ?????????Soap?????????????????????PostMethod???
        RequestEntity requestEntity = new StringRequestEntity(sb.toString(), "text/xml", "UTF-8");
        //??????????????????????????????????????? ???no SOAPAction header??? ?????????
        postMethod.setRequestHeader("SOAPAction", "http://tempuri.org/SetPhoto");
        // ???????????????
        postMethod.setRequestEntity(requestEntity);
        int status = client.executeMethod(postMethod);
        // ?????????????????????
        System.out.println("status:" + status);
        // ????????????????????????
        InputStream is = postMethod.getResponseBodyAsStream();
        // ???????????????????????????
        String result = IOUtils.toString(is);
        System.out.println("result: " + result);
    }
}
