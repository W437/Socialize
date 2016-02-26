package com.alsalam.sclzroot.TableManager;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by samih on 26/02/2016.
 */
public class TestTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    public  String  st;
    public Date date;
    public int x;

    public TestTbl(String st, Date date, int x) {
        this.st = st;
        this.date = date;
        this.x = x;
    }

    public TestTbl() {
        this.st = "hi";
        this.date = Calendar.getInstance().getTime();
        this.x = 1234;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
