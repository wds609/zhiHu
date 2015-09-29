package com.me.daily.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wds on 9/11/2015.
 */
public class DateUtil {

    public static String getFormatedDate(Calendar date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date.getTime());
    }

    public static String getFormatedDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static Calendar getToday() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }

}
