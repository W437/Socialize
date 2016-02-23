package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class EventTbl {
    private String id;
    private String eventLocation;
    private Date   eventBegin;
    private Date   eventEnd;
    private String hostId;
    private int    eventMaxParticipators;

    public EventTbl(String id, String eventLocation, Date eventBegin, Date eventEnd, String hostId, int eventMaxParticipators) {
        this.id = id;
        this.eventLocation = eventLocation;
        this.eventBegin = eventBegin;
        this.eventEnd = eventEnd;
        this.hostId = hostId;
        this.eventMaxParticipators = eventMaxParticipators;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Date getEventBegin() {
        return eventBegin;
    }

    public void setEventBegin(Date eventBegin) {
        this.eventBegin = eventBegin;
    }

    public Date getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(Date eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public int getEventMaxParticipators() {
        return eventMaxParticipators;
    }

    public void setEventMaxParticipators(int eventMaxParticipators) {
        this.eventMaxParticipators = eventMaxParticipators;
    }
}
