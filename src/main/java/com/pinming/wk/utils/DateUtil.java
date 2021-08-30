package com.pinming.wk.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

@Slf4j
public class DateUtil {

    /**
     * 取得格式化效果的系统日期！ 格式如：yyyy-MM-dd kk:mm:ss
     */
    public final static String getFormateDate(String formate) {
        SimpleDateFormat f = new SimpleDateFormat(formate, Locale.US);
        return f.format(new Date());
    }

    public static String getFormatDate(Date date, String formate) {
        SimpleDateFormat f = new SimpleDateFormat(formate);
        return f.format(date);
    }
    public static boolean compareDate(String s, String e) {
        if ((fomatDate(s) == null) || (fomatDate(e) == null)) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String fomatDate(Date date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(date);
    }
    public static String fomatDate(String dateStr,String pattern,String pattern1) {
        DateFormat fmt = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = fmt.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern1);
        return simpleDateFormat.format(date);
    }
    public static String fomatStringDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.format(fmt.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String fomatDate_new(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.format(fmt.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date fomatDateHMS(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date fomatDateHM(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean isValidDate_New(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long aa = 0L;
            int years = (int) ((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / 86400000L / 365L);
            return years;
        } catch (Exception e) {
        }
        return 0;
    }

    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0L;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / 86400000L;

        return day;
    }

    public static String getAfterDayDate(Integer days) {

        Calendar canlendar = Calendar.getInstance();
        canlendar.add(5, days);
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    public static String getAfterDayDate(String startDate, Integer days) {
        String[] time = startDate.split("-");

        Calendar canlendar = Calendar.getInstance();
        canlendar.set(Integer.parseInt(time[0]), Integer.parseInt(time[1]) - 1, Integer.parseInt(time[2]));
        canlendar.add(5, days);
        Date date = canlendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);

        return dateStr;
    }

    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance();
        canlendar.add(5, daysInt);
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    public static String getDateByTimeStamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(timestamp));

        return date;
    }

    public static long getTimeStamp(String days) {
        long unixTimestamp = 0L;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(days);
            unixTimestamp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unixTimestamp;
    }

    public static long getTimeStamp() {
        long unixTimestamp = 0L;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        unixTimestamp = date.getTime();


        return unixTimestamp;
    }

    public static long getTimeStampSdfDay(String days) {
        long unixTimestamp = 0L;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date date = format.parse(days);
            unixTimestamp = date.getTime() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return unixTimestamp;
    }

    /**
     * 时间差
     *
     * @throws ParseException
     */
    public static String getTiming(String date1, long startTime) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //java.util.Date now = df.parse(date2);
        Date date = df.parse(date1);

        long l = startTime - date.getTime() / 1000;

        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000));
        long min = ((l / (60 * 1000)));
        if (min < 60) {
            return Long.toString(min) + "分钟前";
        } else if (hour < 24) {
            return Long.toString(hour) + "小时前";
        } else if (day < 2) {
            return Long.toString(day) + "天前";
        } else {
            return date1;
        }

    }

    public static String getTimings(String date1, String date2) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = df.parse(date2);
        Date date = df.parse(date1);

        long l = now.getTime() - date.getTime();

        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000));
        long min = ((l / (60 * 1000)));
        if (min < 60) {
            return Long.toString(min) + "分钟前";
        } else if (hour < 24) {
            return Long.toString(hour) + "小时前";
        } else if (day < 2) {
            return Long.toString(day) + "天前";
        } else {
            return date1;
        }

    }


    /**
     * 格式化输出指定的calendar的格式
     *
     * @param calendar calendar对象
     * @return 日期字符串
     */
    public static String format(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 格式化输出指定的calendar的格式
     *
     * @param calendar calendar对象
     * @param format   格式
     * @return 日期字符串
     */
    public static String format(Calendar calendar, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 获取昨天Calendar对象
     *
     * @return calendar实例
     */
    public static Calendar getYesterday() {
        Calendar calendar = Calendar.getInstance();//今天
        calendar.add(Calendar.DATE, -1);
        return calendar;
    }

    /**
     * @param days
     * @return
     */
    public static String getBeforeday(String days) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;


    }

    /**
     * 获取昨天的日期对象
     *
     * @return
     */
    public static String getYesterDayFromat() {
        return format(getYesterday(), "yyyy-MM-dd");
    }


    public static Calendar getTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        return calendar;
    }

    public static String tomorrow() {
        return format(getTomorrow(), "yyyy-MM-dd");
    }

    public static Calendar getBeforeMonthsDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -30);
        return calendar;
    }

    public static Calendar getAfterMonthsDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 30);
        return calendar;
    }

    public static String BeforeMonthsDay() {
        return format(getBeforeMonthsDay(), "yyyy-MM-dd");
    }

    public static String AfterMonthsDay() {
        return format(getAfterMonthsDay(), "yyyy-MM-dd");
    }

    public static String getnowDate() {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf2.format(new Date());
        return date;
    }

    public static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * 获取某一日期的前几天或后几天是星期几
     *
     * @param dd  时间
     * @param num 天数
     * @return
     */
    public static String getWeekValue(Date dd, int num) {
        String getWeek = "";
        String[] weekDatas = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(dd);
        int week_index = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        calendar1.add(Calendar.DATE, num);
        week_index = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        getWeek = weekDatas[week_index];
        return getWeek;
    }

    //获取某个时间段内所有的日期
    public static List<String> findDates(Date dBegin, Date dEnd) {
        List<String> lDate = new ArrayList<String>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        lDate.add(sd.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }
        return lDate;
    }

    /**
     * 根据时间类型比较时间大小
     *
     * @param source
     * @param traget
     * @param type   "YYYY-MM-DD" "yyyyMMdd HH:mm:ss"  类型可自定义
     * @return 0 ：source和traget时间相同
     * 1 ：source比traget时间大
     * -1：source比traget时间小
     * @throws Exception
     */
    public static int DateCompare(String source, String traget, String type) throws Exception {
        int ret = 2;
        SimpleDateFormat format = new SimpleDateFormat(type);
        Date sourcedate = format.parse(source);
        Date tragetdate = format.parse(traget);
        ret = sourcedate.compareTo(tragetdate);
        return ret;
    }

    /**
     * 时间戳转时间
     *
     * @param stamp 13位时间戳
     * @return 转换成24小时制的时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static Date stampToDate(String stamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lt = new Long(stamp);
        Date stampDate = new Date(lt);
        String dateStr = sdf.format(stampDate);
        Date result = null;
        try {
            result = sdf.parse(dateStr);
        } catch (ParseException e) {
            log.error("时间戳转时间出错！！！" + stamp, e);
        }
        return result;
    }

    /**
     * 获取当前时间的当年第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        Date result = null;
        try {
            String dateStr = sdf.format(calendar.getTime());
            result = sdf.parse(dateStr);
        } catch (ParseException e) {
            log.error("获取当前时间的当年第一天出错！！！" + date, e);
        }
        return result;
    }

    /**
     * 获取当前时间的当年最后一天
     *
     * @param date
     * @return
     */
    public static Date getEndDayOfYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        calendar.set(Calendar.DAY_OF_YEAR, 0);
        Date result = null;
        try {
            String dateStr = sdf.format(calendar.getTime());
            result = sdf.parse(dateStr);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(result.getTime()), ZoneId.systemDefault());
            LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
            result = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        } catch (ParseException e) {
            log.error("获取当前时间的当年最后一天出错！！！" + date, e);
        }
        return result;
    }

    /**
     * 获取当前时间的当月第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date result = null;
        try {
            String dateStr = sdf.format(calendar.getTime());
            result = sdf.parse(dateStr);
        } catch (ParseException e) {
            log.error("获取当前时间的当月第一天出错！！！" + date, e);
        }
        return result;
    }

    /**
     * 获取当前时间的当月最后一天
     *
     * @param date
     * @return
     */
    public static Date getEndDayOfMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        Date result = null;
        try {
            String dateStr = sdf.format(calendar.getTime());
            result = sdf.parse(dateStr);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(result.getTime()), ZoneId.systemDefault());
            LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
            result = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        } catch (ParseException e) {
            log.error("获取当前时间的当月最后一天出错！！！" + date, e);
        }
        return result;
    }

    /**
     * date2比date1多出的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Integer differentDays(Date date1, Date date2) {
        int days;
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long diff = time2 - time1;
        days = (int) (diff / (24 * 60 * 60 * 1000));
        return days;
    }

    /**
     * date2比date1多出的小时
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Integer differentHours(Date date1, Date date2) {
        int hours;
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long diff = time2 - time1;
        hours = (int) (diff / (60 * 60 * 1000));
        return hours;
    }

    /**
     * date2比date1多出的分钟
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Integer differentMinutes(Date date1, Date date2) {
        int minutes;
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long diff = time2 - time1;
        minutes = (int) (diff / (60 * 1000));
        return minutes;
    }

    public static long differentMs(Date date1, Date date2) {
        int days;
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        return time2 - time1;
    }

    public static boolean isToday(String date) {//传入时间yyyy-MM-dd是否为今日时间
        boolean flag = false;
        String today = getTodayDate();//yyyy-MM-dd
        if (date.equals(today)) {
            flag = true;
        }
        return flag;
    }

    public static boolean isToday(Date date) {//传入时间是否为今日时间
        boolean flag = false;
        //获取当前系统时间
        long longDate = System.currentTimeMillis();
        Date nowDate = new Date(longDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(nowDate);
        String subDate = format.substring(0, 10);
        //定义每天的24h时间范围
        String beginTime = subDate + " 00:00:00";
        String endTime = subDate + " 23:59:59";
        Date paseBeginTime = null;
        Date paseEndTime = null;
        try {
            paseBeginTime = dateFormat.parse(beginTime);
            paseEndTime = dateFormat.parse(endTime);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        if (date.after(paseBeginTime) && date.before(paseEndTime)) {
            flag = true;
        }
        return flag;
    }


    /**
     * 获取过去n天内的日期数组
     *
     * @param intervals intervals天内
     * @return 日期数组
     */
    public static List<String> dayList(int intervals) {
        List<String> pastDaysList = new ArrayList<>();
        for (int i = intervals - 1; i >= 0; i--) {
            pastDaysList.add(getPastDate(i));
        }
        return pastDaysList;
    }
    /**
     * @author qisw
     * @date 2019-12-06 17:03
     * @return
     * @throws
     * @desc   根据传入的date时间类型  得出该时间是所属年度的第几个自然周
     */
    public static int getWeekofyearByDatestr(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
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
        String result = format.format(today);
        return result;
    }

    /**
     * 获取指定日期之后几天的日期
     *
     * @param date
     * @param past
     * @return
     */
    public static Date getFetureDate(Date date, int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + past);//+后 -前
        Date result = calendar.getTime();
        return result;
    }

    /**
     * 获取指定日期之后几小时的时间
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date getFetureHours(Date date, int hours) {
        return new Date(date.getTime() + hours * 60 * 60 * 1000);
    }

    /**
     * 获取指定日期之后几分钟的时间
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date getFetureMinutes(Date date, int minute) {
        return new Date(date.getTime() + minute * 60 * 1000);
    }

    /**
     * 获取某个日期所在年份
     *
     * @param date
     * @return
     */
    public static Integer getYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
        int year = localDate.getYear();
        return year;
    }

    /**
     * 获取某个日期所在月份
     *
     * @param date
     * @return
     */
    public static Integer getMonth(String date) {
        LocalDate localDate = LocalDate.parse(date);
        int month = localDate.getMonth().getValue();
        return month;
    }

    /**
     * 获取某个日期所在日期
     *
     * @param date
     * @return
     */
    public static Integer getDay(String date) {
        LocalDate localDate = LocalDate.parse(date);
        int day = localDate.getDayOfMonth();
        return day;
    }

    /**
     * 获取某个日期所在月份的天数
     *
     * @param date
     * @return
     */
    public static Integer getLengthOfMonth(String date) {
        LocalDate localDate = LocalDate.parse(date);
        int days = localDate.lengthOfMonth();
        return days;
    }

    /**
     * 计算两个时间相差多久
     *
     * @param endDate
     * @param nowDate
     * @return
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        String result = "";
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        if (day != 0) {
            result += day + "d";
        }
        // 计算差多少小时
        long hour = diff % nd / nh;
        if (hour != 0) {
            result += hour + "h";
        }
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        if (min != 0) {
            result += min + "m";
        }
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        result += sec + "s";
        return result;
    }

    /**
     * 获取当天零点时间戳
     *
     * @return
     */
    public static Long getDateZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 获取当天23点59分59秒
     *
     * @return
     */
    public static Long getDateEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime().getTime();
    }

    public static String formatDate(Date date, String pattern) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String result = null;
        result = sdf.format(date);
        return result;
    }

    /**
     * 获取起止日期
     *
     * @param sdf    需要显示的日期格式
     * @param date   需要参照的日期
     * @param n      最近n周
     * @param option 0 开始日期；1 结束日期
     * @param k      0 包含本周 1 不包含本周
     * @return
     */
    public static String getFromToDate(SimpleDateFormat sdf, Date date, int n, int option, int k) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 0 == option ? 1 - dayOfWeek : 7 - dayOfWeek;
        int amount = 0 == option ? offset - (n - 1 + k) * 7 : offset - k * 7;
        calendar.add(Calendar.DATE, amount);
        return sdf.format(calendar.getTime());
    }

    /**
     * 根据当前日期获得最近n周的日期区间（包含本周）
     *
     * @param n
     * @param sdf
     * @return
     */
    public static ArrayList<Date> getNWeekTimeInterval(int n, SimpleDateFormat sdf) {
        String beginDate = getFromToDate(sdf, new Date(), n, 0, 0);
        String endDate = getFromToDate(sdf, new Date(), n, 1, 0);
        ArrayList<Date> dateList = new ArrayList<>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date benginData1 = sdf1.parse(beginDate);
            Date endData1 = sdf1.parse(endDate);

            dateList.add(benginData1);
            dateList.add(new Date(endData1.getTime() + (1000 * 60 * 60 * 24) - 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateList;
    }

    /**
     * 根据当前日期获得最近n周的日期区间（不包含本周）
     *
     * @param n
     * @param sdf
     * @return
     */
    public static String getNWeekTimeIntervalTwo(int n, SimpleDateFormat sdf) {
        String beginDate = getFromToDate(sdf, new Date(), n, 0, 1);
        String endDate = getFromToDate(sdf, new Date(), n, 1, 1);
        return beginDate + "," + endDate;
    }

    /**
     * 根据当前日期获得本周的日期区间（本周周一和周日日期）
     *
     * @return
     */
    public static ArrayList<Date> getThisWeekTimeInterval() {
        return getNWeekTimeInterval(1, new SimpleDateFormat("yyyy-MM-dd"));
    }

    /**
     * 根据当前日期获得上周的日期区间（上周周一和周日日期）
     *
     * @param sdf
     * @return
     */
    public static String getLastWeekTimeInterval(SimpleDateFormat sdf) {
        return getNWeekTimeIntervalTwo(1, sdf);
    }

    /**
     * 获取本月自然月起始日期
     *
     * @return
     */
    public static List<Date> getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//当前月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date firstDay = calendar.getTime();

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        Date lastDay = ca.getTime();

        List<Date> list = new ArrayList<Date>();
        list.add(firstDay);
        list.add(lastDay);
        return list;
    }

    /**
     * 是否是自然周第一天
     *
     * @param date
     * @return
     */
    public static Boolean isNaturalWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String beginDate = getFromToDate(sdf, new Date(), 1, 0, 0);
        if (beginDate.equals(sdf.format(date))) {
            return true;
        }
        return false;
    }

    /**
     * 是否是自然月第一天
     *
     * @param date
     * @return
     */
    public static Boolean isNaturalMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//当前月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date firstDay = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (sdf.format(firstDay).equals(sdf.format(date))) {
            return true;
        }
        return false;
    }

    /**
     * 计算两个日期之间相差的月数
     *
     * @param date1
     * @return
     */
    public static ArrayList<Integer> getMonths(Date date1) {
        ArrayList<Integer> monthList = new ArrayList<>();

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE, -1);
        Date date2 = calendar.getTime();

        int iMonth = 0;
        int flag = 0;
        try {
            Calendar objCalendarDate1 = Calendar.getInstance();
            objCalendarDate1.setTime(date1);

            Calendar objCalendarDate2 = Calendar.getInstance();
            objCalendarDate2.setTime(date2);

            if (objCalendarDate2.equals(objCalendarDate1))
                return monthList;
            if (objCalendarDate1.after(objCalendarDate2)) {
                Calendar temp = objCalendarDate1;
                objCalendarDate1 = objCalendarDate2;
                objCalendarDate2 = temp;
            }
            if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH))
                flag = 1;

            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR))
                        * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
                        - objCalendarDate1.get(Calendar.MONTH);
            else
                iMonth = objCalendarDate2.get(Calendar.MONTH)
                        - objCalendarDate1.get(Calendar.MONTH) - flag;

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = iMonth; i >= 0; i--) {
            monthList.add((date1.getMonth() + 1) + i);
        }
        return monthList;
    }

    /**
     * 获取该月第一天
     *
     * @return
     */
    public static Date getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 0);
        return calendar.getTime();
    }

    /**
     * 获得该月最后一天
     *
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = 0;
        //2月的平年瑞年天数
        if (month == 2) {
            lastDay = cal.getLeastMaximum(Calendar.DAY_OF_MONTH);
        } else {
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return cal.getTime();
    }

    public static Date getMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    public static Date lastTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        //将秒至0
        calendar.set(Calendar.SECOND, 0);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        //获得当前月第一天
        Date sdate = calendar.getTime();
        //将当前月加1；
        calendar.add(Calendar.MONTH, 1);
        //在当前月的下一月基础上减去1毫秒
        calendar.add(Calendar.MILLISECOND, -1);
        Date edate = calendar.getTime();
        return edate;
    }


    /**
     * 昨天的最后时间
     *
     * @return
     */
    public static Date getYestDayLastDate() {
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.add(Calendar.DAY_OF_MONTH, -1); //设置为前一天
        calendar.set(Calendar.HOUR_OF_DAY, 23); //时
        calendar.set(Calendar.MINUTE, 59); //分
        calendar.set(Calendar.SECOND, 59); //秒
        Date endDate = new Date(calendar.getTime().getTime());

        return endDate;
    }

    /**
     * 获取今天凌晨
     *
     * @return
     */
    public static Date getTodayZero() {
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.set(Calendar.HOUR_OF_DAY, 0); //时
        calendar.set(Calendar.MINUTE, 0); //分
        calendar.set(Calendar.SECOND, 0); //秒
        calendar.set(Calendar.MILLISECOND, 0); //毫秒
        Date endDate = new Date(calendar.getTime().getTime());

        return endDate;
    }

    public static Date getTodayEnd() {
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.set(Calendar.HOUR_OF_DAY, 23); //时
        calendar.set(Calendar.MINUTE, 59); //分
        calendar.set(Calendar.SECOND, 59); //秒
        Date endDate = new Date(calendar.getTime().getTime());

        return endDate;
    }

    /**
     * 得到之前几分钟的时间
     *
     * @param minute
     * @return
     */
    public static Date getBeforeMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -minute);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 获取当月第一天
     * @return
     */
    public static String getMonthFirstDayTime(){
        Date date = getMonthFirstDay();
        return fomatDate(date);
    }
    /**
     * 获取当月最后一天
     * @return
     */
    public static String getMonthLastDayTime(){
        Date date = getMonthLastDay();
        return fomatDate(date);
    }


    public static void main(String[] args) {
        System.out.println(compareDate("2020-11-12","2020-10-13"));
    }
}