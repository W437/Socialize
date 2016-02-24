package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class EventTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    @com.google.gson.annotations.SerializedName("eventLocation")
    private String eventLocation;
    @com.google.gson.annotations.SerializedName("eventBegin")
    private Date   eventBegin;
    @com.google.gson.annotations.SerializedName("eventEnd")
    private Date   eventEnd;
    @com.google.gson.annotations.SerializedName("hostId")
    private String hostId;
    @com.google.gson.annotations.SerializedName("eventMaxParticipators")
    private int    eventMaxParticipators;

    public EventTbl(String id, String eventLocation, Date eventBegin, Date eventEnd, String hostId, int eventMaxParticipators) {
        setId(id);
        setEventLocation(eventLocation);
        setEventBegin(eventBegin);
        setEventEnd(eventEnd);
        setHostId(hostId);
        setEventMaxParticipators(eventMaxParticipators);
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
