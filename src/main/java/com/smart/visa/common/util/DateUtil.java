package com.smart.visa.common.util;

import lombok.extern.log4j.Log4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间工具类
 * @Author Administrator
 */
@Log4j
public class DateUtil {

    public static final String PATTERN_HH_MM               = "HH:mm";
    public static final String PATTERN_MM_DD               = "MM-dd";
    public static final String PATTERN_DD                  = "dd";
    public static final String PATTERN_YYYYMMDD            = "yyyyMMdd";
    public static final String PATTERN_YYYY_MM_DD          = "yyyy-MM-dd";
    public static final String PATTERN_YYYY_MM             = "yyyyMM";
    public static final String PATTERN_MMDD                = "MMdd";
    public static final String PATTERN_YYYY                = "yyyy";
    public static final String PATTERN_YYYY_MM_DD_HH_MM    = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_HH_MM_YYYY_MM_DD    = "HH:mm yyyy/MM/dd";
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYYMMDDHHMM        = "yyyyMMddHHmm";
    public static final String PATTERN_YYYYMMDDHHMMSS        = "yyyyMMddHHmmss";
    public static final String PATTERN_YYMMDDHHMM          = "yyMMddHHmm";
    public static final String PATTERN_YY_MM_DD_HH_MM      = "yy/MM/dd HH:mm";

    private DateUtil() {
        // to avoid creating instance
    }

    /**
     * 常规格式化日期方法
     * 按 yyyy-MM-dd 形式格式化日期
     * @param date
     * @return
     */
    public static String format(Date date){
        return format(date,PATTERN_YYYY_MM_DD);
    }

    /**
     * 格式化时间
     *
     * @param date    时间对象
     * @param pattern 时间格式
     * @return 格式化后的时间字符串
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 转换时间字符串为Date对象
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date parse(String dateStr) {
        return parse(dateStr, PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 转换时间字符串为Date对象
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date parse(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            // ignore
        }
        return date;
    }

    /**
     * 增加天数
     * @param origin
     * @param amounts
     * @return
     */
    public static Date addDay(Date origin, int amounts) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(origin);
        cal.add(Calendar.DAY_OF_MONTH, amounts);
        return cal.getTime();
    }

    /**
     * 增加小时
     * @param origin
     * @param amounts
     * @return
     */
    public static Date addHours(Date origin, int amounts) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(origin);
        cal.add(Calendar.HOUR_OF_DAY, amounts);
        return cal.getTime();
    }

    /**
     * 将日期时间字符串转化为Date对象
     * @param strDate 日期时间字符串
     * @return Date 对象
     */
    public static Date strToDate(String strDate){
        return strToDate(strDate, PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     *
     * 将日期时间字符串转化为Date对象
     * @param strDate 日期时间字符串
     * @param pattern 日期格式
     * @return Date 对象
     */
    public static Date strToDate(String strDate, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date date = format.parse(strDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Date对象转化为日期时间字符串
     * @param date Date对象
     * @param pattern 日期格式
     * @return 日期时间字符串
     */
    public static String dateToStr(Date date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String strDate = format.format(date);
        return strDate;
    }

    /**
     * 将Date对象转化为日期时间字符串
     * @param date Date对象
     * @return 日期时间字符串
     */
    public static String dateToStr(Date date){
        return dateToStr(date, PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取当前时间戳
     * @return 时间戳
     */
    public static long currentTime(){
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static Date currentDate(){
        return new Date();
    }

    /**
     * 获取当前时间字符串
     * @param pattern 日期格式
     * @return 日期时间字符串
     */
    public static String currentTime(String pattern){
        Date date = new Date();
        return dateToStr(date, pattern);
    }

    /**
     * 获取给定时间的时间戳
     * @param date 给定日期
     * @return 时间戳
     */
    public static long time(Date date){
        return date.getTime();
    }

    /**
     * 判断当前时间是否在给定时间区间
     * @param start 开始时间
     * @param end 结束时间
     * @return -1 表示小于开始时间，0在给定区间，1大于结束时间
     */
    public static int compare(String start, String end){
        long startTime = strToDate(start).getTime();
        long endTime = strToDate(end).getTime();
        long current = System.currentTimeMillis();
        if(current < startTime){
            return -1;
        }
        if(current > endTime){
            return 1;
        }
        return 0;
    }

    /**
     * 判断当前时间是否在给定时间区间
     * @param start 开始时间
     * @param end 结束时间
     * @return -1 表示小于开始时间，0在给定区间，1大于结束时间
     */
    public static int compare(Date start, Date end){
        long startTime = start.getTime();
        long endTime = end.getTime();
        long current = System.currentTimeMillis();
        if(current < startTime){
            return -1;
        }
        if(current > endTime){
            return 1;
        }
        return 0;
    }

    /**
     * 获取上一个月的第一天
     * @param pattern 日期格式
     * @return day
     */
    public static String preMonthFirstDay(String pattern){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date time = calendar.getTime();
        String s = format(time, pattern);
        return s;
    }

    /**
     * 获取上一个月的最后一天
     * @param pattern 日期格式
     * @return day
     */
    public static String preMonthLastDay(String pattern){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        Date time = calendar.getTime();
        String s = format(time, pattern);
        return s;
    }

    /**
     * 获取上一个月份
     * @param pattern 日期格式
     * @return month
     */
    public static String preMonth(String pattern){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();
        String s = format(date, pattern);
        return s;
    }

    /**
     * 获取某年某月有多少天
     * @param year 年
     * @param month 月
     * @return 天数
     */
    public static int getDayOfMonth(int year, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 0);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定月份起始日期
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMonthBeginDate(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return format(calendar.getTime());
    }

    /**
     * 获取指定月份最后日期
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMonthLastDate(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format(calendar.getTime());
    }

    /**
     * 获取当天剩余毫秒值
     * @return
     */
    public static Long getTodaySurplusMillSeconds(){
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        return ChronoUnit.MILLIS.between(LocalDateTime.now(),midnight);
    }

    /**
     * 获取当天剩余秒值
     * @return
     */
    public static Long getTodaySurplusSeconds(){
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        return ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
    }


}

