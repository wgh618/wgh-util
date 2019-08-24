package com.will.util.core;

import com.sun.scenario.effect.Offset;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * ClassName:DateUtil
 * Description:
 *
 * @Author wuguanghui
 * @Email willWu618@gmail.com
 * @Date 2019/8/24 19:22
 */
@SuppressWarnings("unused")
public class DateUtil {
    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static String DATE_SIMPLE_FORMAT = "yyyyMMdd";

    public static String DATE_FORMAT_CHINESE = "yyyy年M月d日";

    public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String DATE_TIME_FORMAT_CHINESE = "yyyy年M月d日HH时mm分ss秒";

    public static String DATE_TIME_MS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    public static String DATE_TIME_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";

    public static String TIME_FORMAT = "HH:mm:ss";

    /**
     * 格式化日期-yyyy-MM-dd HH:mm:ss
     *
     * @param date 被格式化的日期
     * @return 格式化后的字符串
     */
    public static String formatDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        return format(date, dateFormat);
    }

    /**
     * 格式化日期-yyyy-MM-dd
     *
     * @param date 被格式化的日期
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return format(date, dateFormat);
    }

    /**
     * 格式化日期-HH:mm:ss
     *
     * @param date 被格式化的日期
     * @return 格式化后的字符串
     */
    public static String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        return format(date, dateFormat);
    }


    /**
     * 根据特定格式格式化日期
     *
     * @param date   被格式化的日期
     * @param format 日期格式
     * @return 格式化后的字符串
     */
    public static String format(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return format(date, dateFormat);
    }

    /**
     * 根据特定格式格式化日期
     *
     * @param date
     * @param format {@link DateFormat}
     * @return 格式化后的字符串
     */
    public static String format(Date date, DateFormat format) {
        return format.format(date);
    }

    /**
     * 将日期字符串转换为{@link Date}对象，格式：<br>
     * <ol>
     * <li>yyyy-MM-dd HH:mm:ss</li>
     * <li>yyyy-MM-dd</li>
     * <li>yyyy-MM-dd HH:mm</li>
     * <li>yyyyMMdd</li>
     * </ol>
     *
     * @param dateStr 日期字符串
     * @return 日期
     */
    public static Date parse(String dateStr) {
        if (null == dateStr || dateStr.trim().length() < 1) {
            return null;
        }

        //去掉两边空格并去掉中文日期中的“日”，以规范长度
        dateStr = dateStr.trim().replace("日", "");
        int length = dateStr.length();

        if (length == DATE_FORMAT.length() || length == DATE_FORMAT.length() + 1) {
            return parse(dateStr, DATE_FORMAT);
        } else if (length == DATE_SIMPLE_FORMAT.length()) {
            return parse(dateStr, DATE_SIMPLE_FORMAT);
        } else if (length == DATE_TIME_FORMAT.length()) {
            return parse(dateStr, DATE_TIME_FORMAT);
        } else if (length == DATE_TIME_MINUTE_FORMAT.length()) {
            return parse(dateStr, DATE_TIME_MINUTE_FORMAT);
        }

        // 没有更多匹配的时间格式
        return null;
    }

    /**
     * 将字符串日期转换为日期格式
     *
     * @param dateStr
     * @param format  日期格式
     * @return
     */
    public static Date parse(String dateStr, String format) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date parse = parse(dateStr, dateFormat);


        return parse;
    }

    /**
     * 将字符串日期转换为日期格式
     *
     * @param dateStr
     * @param dateFormat {@link DateFormat} 格式
     * @return
     */
    public static Date parse(String dateStr, DateFormat dateFormat) {
        Date parse = null;
        try {
            parse = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parse;
    }

    /**
     * 获取日期的DAY值
     *
     * @param date 输入日期
     * @return
     */
    public static int getDayOfDate(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int d = cd.get(Calendar.DAY_OF_MONTH);
        return d;
    }

    /**
     * 获取日期的MONTH值
     *
     * @param date 输入日期
     * @return
     */
    public static int getMonthOfDate(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int m = cd.get(Calendar.MONTH) + 1;
        return m;
    }

    /**
     * 获取日期的YEAR值
     *
     * @param date 输入日期
     * @return
     */
    public static int getYearOfDate(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int y = cd.get(Calendar.YEAR);
        return y;
    }

    /**
     * 获取星期几
     *
     * @param date 输入日期
     * @return
     */
    public static int getWeekOfDate(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int wd = cd.get(Calendar.DAY_OF_WEEK) - 1;
        return wd;
    }

    /**
     * 获取输入日期的当月第一天
     *
     * @param date 输入日期
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.set(Calendar.DAY_OF_MONTH, 1);
        return cd.getTime();
    }

    /**
     * 判断是否是闰年
     *
     * @param date 输入日期
     * @return 是true 否false
     */
    public static boolean isLeapYEAR(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int year = cd.get(Calendar.YEAR);

        if (year % 4 == 0 && year % 100 != 0 | year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据整型数表示的年月日，生成日期类型格式
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return
     */
    public static Date getDateByYMD(int year, int month, int day) {
        Calendar cd = Calendar.getInstance();
        cd.set(year, month - 1, day);
        return cd.getTime();
    }

    /**
     * 计算 fromDate 到 toDate 相差多少年
     *
     * @param fromDate
     * @param toDate
     * @return 年数
     */
    public static int getYearByMinusDate(Date fromDate, Date toDate) {
        Calendar df = Calendar.getInstance();
        df.setTime(fromDate);

        Calendar dt = Calendar.getInstance();
        dt.setTime(toDate);

        return dt.get(Calendar.YEAR) - df.get(Calendar.YEAR);
    }

    /**
     * 计算 fromDate 到 toDate 相差多少个月
     *
     * @param fromDate
     * @param toDate
     * @return 月数
     */
    public static int getMonthByMinusDate(Date fromDate, Date toDate) {
        Calendar df = Calendar.getInstance();
        df.setTime(fromDate);

        Calendar dt = Calendar.getInstance();
        dt.setTime(toDate);

        return dt.get(Calendar.YEAR) * 12 + dt.get(Calendar.MONTH) -
                (df.get(Calendar.YEAR) * 12 + df.get(Calendar.MONTH));
    }

    /**
     * 计算 fromDate 到 toDate 相差多少个月
     *
     * @param fromDate
     * @param toDate
     * @return 月数
     */
    public static int getdAByMinusDate(Date fromDate, Date toDate) {
        Calendar df = Calendar.getInstance();
        df.setTime(fromDate);

        Calendar dt = Calendar.getInstance();
        dt.setTime(toDate);

        return dt.get(Calendar.YEAR) * 12 + dt.get(Calendar.MONTH) -
                (df.get(Calendar.YEAR) * 12 + df.get(Calendar.MONTH));
    }

    /**
     * 获取指定时间天的开始时间
     *
     * @param date
     * @return
     */
    public static Date beginOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取某天的开始时间
     *
     * @param calendar 日期 {@link Calendar}
     * @return {@link Calendar}
     */
    public static Calendar beginOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * 获取指定时间天的结束时间
     *
     * @param date
     * @return
     */
    public static Date getDayEndTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
        return cal.getTime();
    }

    // ------------------------------------ Offset start ---------------------------------------------- //

    /**
     * 昨天
     *
     * @return 昨天
     */
    public static Date yesterday() {
        return offsetDay(new Date(), -1);
    }

    /**
     * 明天
     *
     * @return 明天
     */
    public static Date tomorrow() {
        return offsetDay(new Date(), 1);
    }

    /**
     * 上周
     *
     * @return 上周
     */
    public static Date lastWeek() {
        return offsetWeek(new Date(), -1);
    }

    /**
     * 下周
     *
     * @return 下周
     * @since 3.0.1
     */
    public static Date nextWeek() {
        return offsetWeek(new Date(), 1);
    }

    /**
     * 上个月
     *
     * @return 上个月
     */
    public static Date lastMonth() {
        return offsetMonth(new Date(), -1);
    }

    /**
     * 下个月
     *
     * @return 下个月
     * @since 3.0.1
     */
    public static Date nextMonth() {
        return offsetMonth(new Date(), 1);
    }

    /**
     * 偏移毫秒数
     *
     * @param date 日期
     * @param offset 偏移毫秒数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static Date offsetMillisecond(Date date, int offset) {
        return offset(date, Calendar.MILLISECOND, offset);
    }

    /**
     * 偏移秒数
     *
     * @param date 日期
     * @param offset 偏移秒数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static Date offsetSecond(Date date, int offset) {
        return offset(date, Calendar.SECOND, offset);
    }

    /**
     * 偏移分钟
     *
     * @param date 日期
     * @param offset 偏移分钟数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static Date offsetMinute(Date date, int offset) {
        return offset(date, Calendar.MINUTE, offset);
    }

    /**
     * 偏移小时
     *
     * @param date 日期
     * @param offset 偏移小时数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static Date offsetHour(Date date, int offset) {
        return offset(date, Calendar.HOUR_OF_DAY, offset);
    }

    /**
     * 偏移天
     *
     * @param date 日期
     * @param offset 偏移天数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static Date offsetDay(Date date, int offset) {
        return offset(date, Calendar.DAY_OF_MONTH, offset);
    }

    /**
     * 偏移周
     *
     * @param date 日期
     * @param offset 偏移周数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static Date offsetWeek(Date date, int offset) {
        return offset(date, Calendar.WEEK_OF_YEAR, offset);
    }

    /**
     * 偏移月
     *
     * @param date 日期
     * @param offset 偏移月数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static Date offsetMonth(Date date, int offset) {
        return offset(date, Calendar.MONTH, offset);
    }

    /**
     * 获取指定日期偏移指定时间后的时间
     *
     * @param date 基准日期
     * @param type 类型：1-年，2-月，6-天
     * @param offset 偏移量，正数为向后偏移，负数为向前偏移
     * @return 偏移后的日期
     */
    public static Date offset(Date date, int type, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(type, offset);
        return cal.getTime();
    }

    // ------------------------------------ Offset end ---------------------------------------------- //

    /**
     * 判断两个日期相差的天数<br>
     *
     * <pre>
     * 有时候我们计算相差天数的时候需要忽略时分秒。
     * 比如：2016-02-01 23:59:59和2016-02-02 00:00:00相差一秒
     * 如果isReset为<code>false</code>相差天数为0。
     * 如果isReset为<code>true</code>相差天数将被计算为1
     * </pre>
     *
     * @param beginDate 起始日期
     * @param endDate 结束日期
     * @param isReset 是否重置时间为起始时间
     * @return 日期差
     */
    public static long betweenDay(Date beginDate, Date endDate, boolean isReset) {
        final Calendar beginCal = calendar(beginDate);
        final Calendar endCal = calendar(endDate);

        int result = endCal.get(Calendar.DAY_OF_YEAR) - beginCal.get(Calendar.DAY_OF_YEAR);
        if (false == isReset) {
            endCal.set(Calendar.DAY_OF_YEAR, beginCal.get(Calendar.DAY_OF_YEAR));
            long between = endCal.getTimeInMillis() - beginCal.getTimeInMillis();
            if (between < 0) {
                return result - 1;
            }
        }
        return result;
    }

    /**
     * 计算两个日期相差月数<br>
     * 在非重置情况下，如果起始日期的天小于结束日期的天，月数要少算1（不足1个月）
     *
     * @param beginDate 起始日期
     * @param endDate 结束日期
     * @param isReset 是否重置时间为起始时间（重置天时分秒）
     * @return 相差月数
     */
    public static long betweenMonth(Date beginDate, Date endDate, boolean isReset) {
        final Calendar beginCal = calendar(beginDate);
        final Calendar endCal = calendar(endDate);

        final int betweenYear = endCal.get(Calendar.YEAR) - beginCal.get(Calendar.YEAR);
        final int betweenMonthOfYear = endCal.get(Calendar.MONTH) - beginCal.get(Calendar.MONTH);

        int result = betweenYear * 12 + betweenMonthOfYear;
        if (false == isReset) {
            endCal.set(Calendar.YEAR, beginCal.get(Calendar.YEAR));
            endCal.set(Calendar.MONTH, beginCal.get(Calendar.MONTH));
            long between = endCal.getTimeInMillis() - beginCal.getTimeInMillis();
            if (between < 0) {
                return result - 1;
            }
        }
        return result;
    }

    /**
     * 计算两个日期相差年数<br>
     * 在非重置情况下，如果起始日期的月小于结束日期的月，年数要少算1（不足1年）
     *
     * @param beginDate 起始日期
     * @param endDate 结束日期
     * @param isReset 是否重置时间为起始时间（重置月天时分秒）
     * @return 相差月数
     */
    public static long betweenYear(Date beginDate, Date endDate, boolean isReset) {
        final Calendar beginCal = calendar(beginDate);
        final Calendar endCal = calendar(endDate);

        int result = endCal.get(Calendar.YEAR) - beginCal.get(Calendar.YEAR);
        if (false == isReset) {
            endCal.set(Calendar.YEAR, beginCal.get(Calendar.YEAR));
            long between = endCal.getTimeInMillis() - beginCal.getTimeInMillis();
            if (between < 0) {
                return result - 1;
            }
        }
        return result;
    }

    /**
     * 当前日期是否在日期指定范围内<br>
     * 起始日期和结束日期可以互换
     *
     * @param date 被检查的日期
     * @param beginDate 起始日期
     * @param endDate 结束日期
     * @return 是否在范围内
     */
    public static boolean isIn(Date date, Date beginDate, Date endDate) {
        return date.getTime() > beginDate.getTime() && date.getTime() < endDate.getTime();
    }

    /**
     * 计时，常用于记录某段代码的执行时间，单位：纳秒
     *
     * @param preTime 之前记录的时间
     * @return 时间差，纳秒
     */
    public static long spendNt(long preTime) {
        return System.nanoTime() - preTime;
    }

    /**
     * 计时，常用于记录某段代码的执行时间，单位：毫秒
     *
     * @param preTime 之前记录的时间
     * @return 时间差，毫秒
     */
    public static long spendMs(long preTime) {
        return System.currentTimeMillis() - preTime;
    }

    /**
     * 格式化成yyMMddHHmm后转换为int型
     *
     * @param date 日期
     * @return int
     */
    public static int toIntSecond(Date date) {
        return Integer.parseInt(DateUtil.format(date, "yyMMddHHmm"));
    }

    /**
     * 计算指定指定时间区间内的周数
     *
     * @param start 开始时间
     * @param end 结束时间
     * @return 周数
     */
    public static int weekCount(Date start, Date end) {
        final Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        final Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);

        final int startWeekofYear = startCalendar.get(Calendar.WEEK_OF_YEAR);
        final int endWeekofYear = endCalendar.get(Calendar.WEEK_OF_YEAR);

        int count = endWeekofYear - startWeekofYear + 1;

        if (Calendar.SUNDAY != startCalendar.get(Calendar.DAY_OF_WEEK)) {
            count--;
        }

        return count;
    }

    /**
     * 生日转为年龄，计算法定年龄
     *
     * @param birthDay 生日，标准日期字符串
     * @return 年龄
     */
    public static int ageOfNow(String birthDay) {
        return ageOfNow(parse(birthDay));
    }

    /**
     * 生日转为年龄，计算法定年龄
     *
     * @param birthDay 生日
     * @return 年龄
     */
    public static int ageOfNow(Date birthDay) {
        return age(birthDay, new Date());
    }

    /**
     * 计算相对于dateToCompare的年龄，长用于计算指定生日在某年的年龄
     *
     * @param birthDay 生日
     * @param dateToCompare 需要对比的日期
     * @return 年龄
     */
    public static int age(Date birthDay, Date dateToCompare) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateToCompare);

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(String.format("Birthday is after date {}!", formatDate(dateToCompare)));
        }

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthDay);
        int age = year - cal.get(Calendar.YEAR);

        int monthBirth = cal.get(Calendar.MONTH);
        if (month == monthBirth) {
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
            if (dayOfMonth < dayOfMonthBirth) {
                // 如果生日在当月，但是未达到生日当天的日期，年龄减一
                age--;
            }
        } else if (month < monthBirth) {
            // 如果当前月份未达到生日的月份，年龄计算减一
            age--;
        }

        return age;
    }

    /**
     * 是否闰年
     *
     * @param year 年
     * @return 是否闰年
     */
    public static boolean isLeapYear(int year) {
        return new GregorianCalendar().isLeapYear(year);
    }

    /**
     * 秒数转为时间格式(HH:mm:ss)<br>
     * 参考：https://github.com/iceroot
     *
     * @param seconds 需要转换的秒数
     * @return 转换后的字符串
     */
    public static String secondToTime(int seconds) {
        if(seconds < 0) {
            throw new IllegalArgumentException("Seconds must be a positive number!");
        }

        int hour = seconds / 3600;
        int other = seconds % 3600;
        int minute = other / 60;
        int second = other % 60;
        final StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append("0");
        }
        sb.append(hour);
        sb.append(":");
        if (minute < 10) {
            sb.append("0");
        }
        sb.append(minute);
        sb.append(":");
        if (second < 10) {
            sb.append("0");
        }
        sb.append(second);
        return sb.toString();
    }

    /**
     * 转换为Calendar对象
     *
     * @param date 日期对象
     * @return Calendar对象
     */
    public static Calendar calendar(Date date) {
        return calendar(date.getTime());
    }

    /**
     * 转换为Calendar对象
     *
     * @param millis 时间戳
     * @return Calendar对象
     */
    public static Calendar calendar(long millis) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        return cal;
    }
}
