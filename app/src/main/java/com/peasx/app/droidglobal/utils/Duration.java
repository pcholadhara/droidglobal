package com.peasx.app.droidglobal.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Duration {
        public Duration(){}

        public static long[] getToday(){
            long first  = getFirstMillisOfDay();
            long last   = 0;
            last  = first + (86400000-1);
            return new long[]{first, last};
        }

        public static long[] getThisMonth(){
            long first  = getFirstMillisOfMonth();
            long last   = System.currentTimeMillis();
            return new long[]{first, last};
        }

        public static long[] getThisYear(){
            long first  = getFirstMillisOfYear();
            long last   = System.currentTimeMillis();
            return new long[]{first, last};
        }

        private static long getFirstMillisOfDay(){
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            long first = cal.getTimeInMillis();
            return first;
        }

        private static long getFirstMillisOfMonth(){
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            long first = cal.getTimeInMillis();
            return first;
        }

        public static long getFirstMillisOfYear(){
            long firstMillis;
            SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
            long curtime = System.currentTimeMillis();
            Calendar now = Calendar.getInstance();
            now.setTimeInMillis(curtime);
            String curDat = sdf.format(now.getTime());

            String[] ddmm = curDat.split("-");
            String mm = ddmm[0];
            String yy = ddmm[1];
            int month = Integer.valueOf(mm);
            int year = Integer.valueOf(yy);

            if(month<4){
                year = year-1;
            }


            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, 3);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            firstMillis = cal.getTimeInMillis();
            return firstMillis;
        }


}
