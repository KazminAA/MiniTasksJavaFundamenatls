package com.company;

import java.util.Date;

public class Day {
    public String countDays(Date d) {
        Date today = new Date();
        if (d.before(today)) {
            return "The day is in the past!";
        }
        if (d.equals(today)) {
            return "Today is the day!";
        }
        return Long.valueOf((d.getTime() - today.getTime()) / 86400000).toString();
    }
}
