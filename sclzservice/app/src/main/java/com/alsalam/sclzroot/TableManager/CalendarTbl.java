package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class CalendarTbl {
    private String id;
    private String subjectId;
    private Date   calendarEvent;

    public CalendarTbl(String id, String subjectId, Date calendarEvent) {
        this.id = id;
        this.subjectId = subjectId;
        this.calendarEvent = calendarEvent;
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
