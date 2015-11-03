package com.ngse.whenend;

/**
 * Created by Henry on 8/27/15.
 */
public class ColonTime {

    private int hr;
    private int min;

    private String name;

    public ColonTime(int hr, int min, String name) {
        this.hr = hr;
        this.min = min;
        this.name = name;
    }

    public ColonTime(int hr, int min) {
        this.hr = hr;
        this.min = min;
        this.name = null;
    }

    public int getHr() {
        return hr;
    }

    public int getMin() {
        return min;
    }
    public String getName() {
        return name;
    }

    public boolean isBefore(ColonTime c) {
        if(this.hr < c.getHr()) {
            if(this.min < c.getMin()) {
                return true;
            }
        }
        return false;
    }

    public ColonTime correct() {
        while(this.min >60 || this.hr >12) {
            if (this.min > 60) {
                this.min -= 60;
                this.hr++;
            }
            if (this.hr > 12) {
                this.hr -= 12;
            }
        }
        return this;
    }

    public String toString() {
        this.correct();
        String s = this.hr + ":";
        if(this.min < 10) {
            s += "0";
        }
        s+= this.min;
        return s;
    }
}
