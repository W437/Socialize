package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class CalendarTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    @com.google.gson.annotations.SerializedName("subjectId")
    private String subjectId;
    @com.google.gson.annotations.SerializedName("calendarEvent")
    private Date   calendarEvent;

    public CalendarTbl(String id, String subjectId, Date calendarEvent) {
        setId(id);
        setSubjectId(subjectId);
        setCalendarEvent(calendarEvent);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Date getCalendarEvent() {
        return calendarEvent;
    }

    public void setCalendarEvent(Date calendarEvent) {
        this.calendarEvent = calendarEvent;
    }
}
