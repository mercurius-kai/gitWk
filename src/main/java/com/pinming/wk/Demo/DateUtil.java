package com.pinming.wk.Demo;


import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author wangkai
 * @date 2020-09-02 11:18
 */
@Slf4j
public class DateUtil {
    public Date transferFormat(String inTime) {
        SimpleDateFormat s1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date tempDate = null;
        String outTime = null;
        Date result = null;
        try {
            tempDate = s1.parse(inTime);
            outTime = s2.format(tempDate);
            result = s2.parse(outTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Date formatDate(String date, String pattern) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date result = null;
        try {
            result = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取指定日期之后几个月的日期
     */
    public static Date getFetureDateMonth(Date date, int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + past);//+后 -前
        Date result = calendar.getTime();
        return result;
    }

    /**
     * 获取某月最后一天（0:本月 负数:前某月 正数:后某月）
     */
    public static String getEndDayOfMonth(Integer num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, num + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        String dateStr = sdf.format(calendar.getTime());
        Date result = null;
        try {
            result = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(result.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        result = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        return formatDate(result, "yyyy-MM-dd");
    }

    public static String formatDate(Date date, String pattern) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String result = null;
        result = sdf.format(date);
        return result;
    }

    /**
     * 获取某月第一天 （0:本月 负数:前某月 正数:后某月）
     */
    public static String getFirstDayOfMonth(Integer num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, num);
        return sdf.format(calendar.getTime());
    }

    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }


    private static List<String> getMonthBetween(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static void compareSort() {
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {

        }
        System.out.println("for耗时：" + (System.currentTimeMillis() - t1));
        int i = 0;
        Long t2 = System.currentTimeMillis();
        while (i < 1000000000) {
            i++;
        }
        System.out.println("while耗时：" + (System.currentTimeMillis() - t2));
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }

    public static List<String> dayList(int intervals, String day) {
        List<String> pastDaysList = new ArrayList<>();
        for (int i = intervals; i > 0; i--) {
            pastDaysList.add(getPastDate(i, day));
        }
        return pastDaysList;
    }

    public static String getPastDate(int past, String day) {
        Calendar c = Calendar.getInstance();
        Date date;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(day);
            c.setTime(date);
            int day1 = c.get(Calendar.DATE);
            c.set(Calendar.DATE, day1 - past);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    public static void main(String[] args) {
        String startTime;
        String endTime;
        for (int i = 3; i >0; i--) {
            endTime = getDateByTimeStamp(DateUtil.getBeforeEndTimeStamp(10 * (i - 1) + 1));
            startTime = getDateByTimeStamp(DateUtil.getBeforeZeroTimeStamp(10 * i));
            System.out.println("开始时间：" + startTime);
            System.out.println("结束时间：" + endTime);
        }
    }

    /**
     * 获取几天前0点的时间戳
     */
    public static Long getBeforeZeroTimeStamp(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - day, 0, 0, 0);
        return calendar.getTime().getTime();
    }

    public static String getDateByTimeStamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timestamp));
    }

    /**
     * 获取几天前23:59:59秒的时间戳
     */
    public static Long getBeforeEndTimeStamp(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - day, 23, 59, 59);
        return calendar.getTime().getTime();
    }


}
