package com.pinming.wk.Demo;

import com.pinming.wk.utils.HttpUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangkai
 * @date 2020-08-28 14:18
 */
public class Md5 {
    public static void main(String[] args) {
        //String url = "http://183.203.96.67:10011/interface/Handler.ashx?w0_Cmd=Project&w1_CorpId=10084279&hmac=5e2b7eeab02b3c93427d862f7c63cfe5";
        //System.out.println(encrypByMd5("Dust10084279035100604202592020-09-0236baaf4d402e53b66d0c5c67761c6576"));
        System.out.println(encrypByMd5Jar("Device1009267136baaf4d402e53b66d0c5c67761c6576"));
        //String s = HttpUtils.sendByGetUrl(url);
       // System.out.println(s);
    }

    public static String encrypByMd5(String context) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(context.getBytes());//update处理
            byte [] encryContext = md.digest();//调用该方法完成计算

            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）
                i = encryContext[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //System.out.println("32result: " + buf.toString());// 32位的加密
            //System.out.println("16result: " + buf.toString().substring(8, 24));// 16位的加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String encrypByMd5Jar(String context) {
        return DigestUtils.md5Hex(context);
    }
}
