package com.pinming.wk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pinming.wk.pojo.People;
import com.pinming.wk.utils.DateUtil;
import com.pinming.wk.utils.GsonFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.safehaus.uuid.UUID;
import org.safehaus.uuid.UUIDGenerator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Author: wk
 * @Date: 2020/8/3 9:25
 */
@Slf4j
public class Test4 {
//    public static void main(String[] args) {
//        List<People> list = new ArrayList<People>();
//        People p1 = new People();
//        p1.setId("1");
//        p1.setName("张三");
//        p1.setType("管理员");
//        p1.setAge(20);
//        String data = JSONObject.toJSONString(p1);
//        list.add(p1);
//        People p2 = new People();
//        p2.setId("2");
//        p2.setName("张三");
//        p2.setType("管理员");
//        p2.setAge(30);
//        list.add(p2);
//        People p3 = new People();
//        p3.setId("3");
//        p3.setName("王五");
//        p3.setType("访客");
//        p3.setAge(40);
//        list.add(p3);
//        People p4 = new People();
//        p4.setId("4");
//        p4.setName("马六");
//        p4.setType("访客");
//        p4.setAge(50);
//        list.add(p4);
//        list = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(worker -> worker.getName()))), ArrayList::new));
//        System.out.println(list);
//    }
//
//
//
//
//        //跟据某个属性分组
////        Map<String, List<People>> collect = list.stream().collect(Collectors.groupingBy(People::getType));
////        for (List<People> values : collect.values()) {
////            //System.out.println("value= " + values);
////            StringBuilder names = new StringBuilder();
////            for (People value : values) {
////                names.append(value.getName() + ",");
////            }
////            String type = values.get(0).getType();
////            System.out.println(type);
////            String name = names.substring(0, names.length() - 1);
////            System.out.println(name);
////        }
//        //System.out.println(collect);
//
////        //根据某个属性分组，汇总某个属性
////        Map<String, Integer> collect2 = list.stream().collect(Collectors.groupingBy(People::getType,Collectors.summingInt(People::getAge)));
////        System.out.println(collect2);
////
////        //根据某个属性添加条件过滤数据，
////        list = list.stream().filter(u -> !u.getType().equals("访客")).collect(Collectors.toList());
////        System.out.println(list);
////
////        //判断一组对象里面有没有属性值是某个值
////        boolean add = list.stream().anyMatch(m -> "王五".equals(m.getName()));
////        System.out.println(add);
////
////        //取出一组对象的某个属性组成一个新集合
////        List<String> names=list.stream().map(People::getName).collect(Collectors.toList());
////        System.out.println(names);
//    }

//    public ThreadPoolExecutor threadPool(){
//        return new ThreadPoolExecutor(10,20,3000);
//    }

//    public static void main(String[] args) throws IOException {
//        Map<String , Object> fieldsMap = new HashMap<>();
//        fieldsMap.put("name","刘志航");
//        fieldsMap.put("age",28);
//        fieldsMap.put("address","皖");
//        Gson gson = new GsonBuilder().serializeNulls().create();
//        String json = GsonFormatUtil.gsonFormat(gson, fieldsMap);
//    }


//    byte[] a = new byte[1024 * 100];
//
//    public static void main(String[] args) throws InterruptedException {
//        List<Test4> peopleList = new ArrayList<>();
//        while (true) {
//            peopleList.add(new Test4());
//            Thread.sleep(5);
//        }
//    }

//    static int count = 0;
//
//    static void redo() {
//        count++;
//        redo();
//    }
//
//    public static void main(String[] args) {
//        try {
//            redo();
//        } catch (Throwable e) {
//            e.printStackTrace();
//            System.out.println(count);
//        }
//    }

    //    public static void main(String[] args) {
//        Map<String, Object> result = new HashMap<>();
//        List<Integer> pushCommand = new ArrayList<>();
//        for (int i = 1; i < 853; i++) {
//            pushCommand.add(i);
//        }
//        log.error("pushCommand的集合为{}", pushCommand);
//        log.error("每次50个开始推送");
//        List<Integer> push = new ArrayList<>();
//        int j = 0;
//        for (int i = 0; i < pushCommand.size(); i++) {
//            if (i != 0 && (i % 50 == 0 || i == (pushCommand.size() - 1))) {
//                if (i == (pushCommand.size() - 1)) {
//                    push.add(pushCommand.get(i));
//                }
//                j++;
//                result.put("envList", push);
//                log.error("第" + j + "推送内容{}", JSON.toJSONString(result));
//                push = new ArrayList<>();
//            }
//            push.add(pushCommand.get(i));
//        }
//    }
    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        while(true){
            list.add(new People());
        }
    }

}
