package com.ngse.whenend;

import java.util.Calendar;

/**
 * Created by Henry on 8/27/15.
 */
public class Schedule {

    private ColonTime[] ct;
    private int month;

    private Schedule(int month, ColonTime[] ct) {
        this.ct = ct;
        this.month = month;
    }

    private static String[] tn = {
            "A PERIOD",
            "1st Period",
            "2nd Period",
            "Brunch",
            "3rd Period",
            "4th Period",
            "Lunch",
            "5th Period",
            "6th Period",
            "SSR",
            "SS"
    };

    private static ColonTime[] normalday = {
            new ColonTime(7,50, tn[0]),
            new ColonTime(8,45, tn[1]),
            new ColonTime(9,5, tn[10]),
            new ColonTime(10,0, tn[2]),
            new ColonTime(10,10, tn[3]),
            new ColonTime(11,10, tn[4]),
            new ColonTime(12,5, tn[11]),
            new ColonTime(12,40, tn[5]),
            new ColonTime(1,15, tn[6]),
            new ColonTime(2,10, tn[7]),
            new ColonTime(3,5, tn[8]),
    };
    private static ColonTime[] shortday = {
            new ColonTime(7,50, tn[0]),
            new ColonTime(8,45, tn[1]),
            new ColonTime(9,5, tn[10]),
            new ColonTime(10,0, tn[2]),
            new ColonTime(10,10, tn[3]),
            new ColonTime(11,10, tn[4]),
            new ColonTime(12,5, tn[11]),
            new ColonTime(12,40, tn[5]),
            new ColonTime(1,15, tn[6]),
            new ColonTime(2,10, tn[7]),
            new ColonTime(3,5, tn[8]),
    };
    private static ColonTime[] longday = {
            new ColonTime(7,50, tn[0]),
            new ColonTime(8,45, tn[1]),
            new ColonTime(9,5, tn[10]),
            new ColonTime(10,0, tn[2]),
            new ColonTime(10,10, tn[3]),
            new ColonTime(11,10, tn[4]),
            new ColonTime(12,5, tn[11]),
            new ColonTime(12,40, tn[5]),
            new ColonTime(1,15, tn[6]),
            new ColonTime(2,10, tn[7]),
            new ColonTime(3,5, tn[8]),
    };

    // main method for getting daily schedule
    private static Schedule getScheduleFromDay(int month,int day) {
        ColonTime[] sch = null;
        if(day == Calendar.MONDAY || day == Calendar.FRIDAY || day == Calendar.THURSDAY) {
            sch = normalday;
        } else if (day == Calendar.TUESDAY) {
            sch = longday;
        } else if(day == Calendar.WEDNESDAY) {
            sch = shortday;
        }
        return new Schedule(month, sch);
    }

    public static ColonTime getPeriodEndFromTime(int month, int day, int hr, int min) {
        Schedule sch = getScheduleFromDay(month, day);
        return sch.getNextPeriodEndFromTime(new ColonTime(hr,min,null));
    }

    public ColonTime getNextPeriodEndFromTime(ColonTime t) {
        for(int x = this.ct.length-1; x >= 0 ; x--) {
            if(t.isBefore(ct[x])) {
                return ct[x];
            }
        }
        return null;
    }

}
