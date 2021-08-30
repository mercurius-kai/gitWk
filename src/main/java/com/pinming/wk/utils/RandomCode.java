package com.pinming.wk.utils;

import java.util.Random;

/**
 * @Author: wk
 * @Date: 2020/7/16 9:25
 */
public class RandomCode {

    /**
     * 生成随机数
     * @return
     */
    public static String runNumber() {
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb=new StringBuilder(6);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        System.out.println(sb.toString());
        String code = sb.toString();
        return code;
    }
}
