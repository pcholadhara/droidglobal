package com.peasx.app.droidglobal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class DateTimes {
    public DateTimes(){}
    public DateTimes(String dateFormat){
            this.dtFormat = dateFormat;
    }


    public long getMillis(String StrDate, String format){
        long millis             = System.currentTimeMillis();
        SimpleDateFormat sdf    = new SimpleDateFormat(format);
        Calendar cal            = Calendar.getInstance();

        try {
            Date d = sdf.parse(StrDate);
            cal.setTime(d);
            millis = cal.getTimeInMillis();
        } catch (ParseException ex) {
        }
        return millis;
    }

    public String getStringDate(long millis){
        return getStringDate(millis, dtFormat);
    }

    public int getDayOfMonth(long millis){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth(long millis){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.MONTH);
    }

    public int getYear(long millis){
           Calendar calendar = Calendar.getInstance();
           calendar.setTimeInMillis(millis);
           return calendar.get(Calendar.YEAR);
    }

    public long getFirstMillis(int day, int month, int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public long getLastMillis(int day, int month, int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTimeInMillis();
    }

    public String getStringTime(long millis){
        return getStringDate(millis, FORMAT_HMS);
    }

    public String getStringDate(long millis, String format){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        return new SimpleDateFormat(format).format(cal.getTimeInMillis());
    }


    public static final long ONE_DAY_MILLIS = 86400000;
    String dtFormat = "dd MMM, yyyy";
    public static final String FORMAT_DMY = "dd MMM, yyyy";
    public static final String FORMAT_DMYHM = "dd MMM, yyyy hh:mm";
    public static final String FORMAT_DDMMMYY = "dd MMM, yy";
    public static final String FORMAT_HMS = "hh:mm:ss";
}
