package com.iwuyou.libmine.utils;


import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by duanding on 16/11/9.
 */

public class DateUtils {
    /**
     * 格式yyyy-MM-dd
     * @param time
     * @return
     */
    public static boolean isToday(String time){
        String today = DateFormattingUtils.date2String(new Date());
        return !(today.indexOf(time) == -1);
    }
    /**
     * 格式yyyy-MM
     * @param time
     * @return
     */
    public static boolean isCurrentMonth(String time){
        String today = DateFormattingUtils.date2String(new Date(), new SimpleDateFormat("yyyy-MM"));
        return today.equals(time);
    }
    /**
     * 格式yyyy
     * @param time
     * @return
     */
    public static boolean isCurrentYear(String time){
        String today = DateFormattingUtils.date2String(new Date());
        return !(today.indexOf(time) == -1);
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */

    public static Date parse(String strDate, String pattern) {

        if (TextUtils.isEmpty(strDate)) {
            return null;
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */

    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }
}
