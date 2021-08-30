package com.pinming.wk.Demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pinming.wk.pojo.IotDeviceStatusQueryDto;
import com.pinming.wk.pojo.People;
import com.pinming.wk.utils.HttpUtils;
import com.pinming.wk.utils.IdentityCheckUtils;
import okhttp3.Headers;
import okhttp3.Response;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author wangkai
 * @date 2020-08-24 10:15
 */
public class SubString {
    //    public static void main(String[] args) {
//        String url ="http://iot-opensite-test05.pinming.org/zhgd/openSite/api/login";
//        JSONObject object = new JSONObject();
//        object.put("username", "13003631907");
//        object.put("password", "123456");
//        String params = JSON.toJSONString(object);
//        Response response = HttpUtils.doPost(url, params);
//        Headers headers = response.headers();
//        Map<String, List<String>> map = headers.toMultimap();
//        List<String> list = map.get("set-cookie");
//        String cookie = null;
//        for (String value:list) {
//            if(value.contains("IOTCookie")){
//                cookie = value;
//            }
//        }
//        System.out.println(cookie);
//
//    }
//

//    public static void main(String[] args) {
//        System.out.println(testTry());
//    }
//
//    private static int testTry() {
//        int a = 10;
//        if (1 == 2)
//            try {
//                System.out.println(a / 0);
//                a = 20;
//            } catch (Exception e) {
//                a = 30;
//                return a;
//            } finally {
//                a = 40;
//            }
//        return a;
//    }

//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//        List<People> peopleList = new ArrayList<>();
//        People people1 = new People();
//        people1.setName("zhangsan");
//        people1.setAge(21);
//        peopleList.add(people1);
//        People people2 = new People();
//        people2.setName("lisi");
//        people2.setAge(4);
//        peopleList.add(people2);
//        People people3 = new People();
//        people3.setName("zhangsan");
//        people3.setAge(21);
//        peopleList.add(people3);
//        People people4 = new People();
//        people4.setName("lisi");
//        people4.setAge(21);
//        peopleList.add(people4);
//        People people5 = new People();
//        people5.setName("lisi");
//        people5.setAge(1);
//        peopleList.add(people5);
//        People people6 = new People();
//        people6.setName("zhangsan");
//        people6.setAge(2);
//        peopleList.add(people6);
//        List<People> collect = peopleList.stream().filter((People p) -> p.getAge() != 21).collect(Collectors.toList());
//        System.out.println(collect);
//    }

    public static void main(String[] args) {
        boolean idNumber = IdentityCheckUtils.isIDNumber("350582199403254551");
        System.out.println(idNumber);
    }


}
