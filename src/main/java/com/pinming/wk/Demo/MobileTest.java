package com.pinming.wk.Demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author： wangkai
 * @date： 2021-06-29 16:47:48
 */
public class MobileTest {

    public static void main(String[] args0) throws IOException {

        FileWriter fileWriter = new FileWriter("F:/test1.txt");

        String httpUrl = "http://apis.baidu.com/chazhao/mobilesearch/phonesearch";

        String httpArg = "";

        for (int i = 0; i < 999999; i++) {

            if (i >= 100000) {

                httpArg = "phone=153" + String.valueOf(i) + "20";

            } else if (i >= 10000) {

                httpArg = "phone=1530" + String.valueOf(i) + "20";

            } else if (i >= 1000) {

                httpArg = "phone=15300" + String.valueOf(i) + "20";

            } else if (i >= 100) {

                httpArg = "phone=153000" + String.valueOf(i) + "20";

            } else if (i >= 10) {

                httpArg = "phone=1530000" + String.valueOf(i) + "20";

            } else {

                httpArg = "phone=15300000" + String.valueOf(i) + "20";

            }

            String jsonResult = request(httpUrl, httpArg);

            if (jsonResult.contains("武汉")) {

                fileWriter.write(httpArg + "\n\t");

            }

        }

        fileWriter.flush();

        fileWriter.close();

    }

    /**
     * @param httpArg :参数
     * @return 返回结果
     */

    public static String request(String httpUrl, String httpArg) {

        BufferedReader reader = null;

        String result = null;

        StringBuffer sbf = new StringBuffer();

        httpUrl = httpUrl + "?" + httpArg;

        try {

            URL url = new URL(httpUrl);

            HttpURLConnection connection = (HttpURLConnection) url

                    .openConnection();

            connection.setRequestMethod("GET");

// 填入apikey到HTTP header

            connection.setRequestProperty("apikey", "您自己的apikey");

            connection.connect();

            InputStream is = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String strRead = null;

            while ((strRead = reader.readLine()) != null) {

                sbf.append(strRead);

                sbf.append("\r\n");

            }

            reader.close();

            result = sbf.toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }

}


