package com.pinming.wk.Demo;

import com.pinming.wk.pojo.People;
import com.pinming.wk.utils.DateUtil;

import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author wangkai
 * @date 2020-09-14 16:20
 */
public class Array {
    public static void main(String[] args) {
//        String date = "2020-11-11 - 2020-11-30";
//        Date startDate = DateUtil.fomatDate(date.substring(0, 10));
//        System.out.println(startDate);
//        //培训结束时间
//        Date endTime = DateUtil.fomatDate(date.substring(13, date.length()));
//        System.out.println(endTime);
//        Integer duration = DateUtil.differentMinutes(startDate, endTime);
//        System.out.println(duration);
//        Double allAlarmHour = Double.parseDouble(String.format("%.1f", duration / (float) 60));
//        System.out.println(allAlarmHour);
        //listSort();
//        List<People> peopleList = new ArrayList<>();
//        People people1 = new People();
//        people1.setAge(10);
//        people1.setName("zs");
//        peopleList.add(people1);
//        People people2 = new People();
//        people2.setAge(2);
//        people2.setName("zs");
//        peopleList.add(people2);
//        People people3 = new People();
//        people3.setAge(40);
//        people3.setName("ls");
//        peopleList.add(people3);
//        People people4 = new People();
//        people4.setAge(3);
//        people4.setName("ls");
//        peopleList.add(people4);
//        peopleList.sort((t1, t2) -> t2.getAge() - t1.getAge());
//        System.out.println(String.format("%.1f",null));
        Integer a = null;
        if (Integer.valueOf(0).equals(a)) {
            System.out.println("123456");
        } else{
            System.out.println("000000");
        }

    }

    public static String timeStamp2Date(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(time));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void listSort() {
        List<String> sortList = new Vector<>();
        Comparator comparator = Collator.getInstance(Locale.CHINA);
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
        Collections.sort(sortList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return comparator.compare(o1, o2);
            }
        });
        for (int i = 0; i < sortList.size(); i++) {
            System.out.println(sortList.get(i));
        }
    }

    private static ArrayList<People> removeDuplicateFlight(List<People> flights) {
        Set<People> set = new TreeSet<People>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                //字符串,则按照asicc码升序排列
                return o1.getName().compareTo(o2.getName());
            }
        });
        set.addAll(flights);
        return new ArrayList<People>(set);
    }
}
