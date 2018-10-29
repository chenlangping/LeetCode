package com.util;

import java.util.Calendar;
import java.util.TimeZone;

public class Time {
    public static String getCurrentTime() {
        Calendar cal;
        String hour;
        String minute;
        String second;
        String millisecond;
        String time;
        cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        if (cal.get(Calendar.AM_PM) == 0) {
            hour = String.valueOf(cal.get(Calendar.HOUR));
        } else {
            hour = String.valueOf(cal.get(Calendar.HOUR) + 12);
        }
        minute = String.valueOf(cal.get(Calendar.MINUTE));
        second = String.valueOf(cal.get(Calendar.SECOND));
        millisecond = String.valueOf(cal.get(Calendar.MILLISECOND));
        if (1 == hour.length()) {
            hour = "0" + hour;
        }
        if (1 == minute.length()) {
            minute = "0" + minute;
        }
        if (1 == second.length()) {
            second = "0" + second;
        }
        if (1 == millisecond.length()) {
            millisecond = "00" + millisecond;
        } else if (2 == millisecond.length()) {
            millisecond = "0" + millisecond;
        }
        time = hour + ":" + minute + ":" + second + ":" + millisecond + "\t\t";
        return time;
    }

    public static void showCurrentTime(){
        System.out.println(getCurrentTime());
    }
}
