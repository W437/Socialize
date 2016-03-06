package com.alsalam.sclzroot.TableManager;


import java.util.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class EventTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    @com.google.gson.annotations.SerializedName("eventLocation")
    private String eventLocation;
    private String adress;
    @com.google.gson.annotations.SerializedName("eventBegin")
    private Date   eventBegin;
    @com.google.gson.annotations.SerializedName("eventEnd")
    private Date   eventEnd;
    @com.google.gson.annotations.SerializedName("hostId")
    private String hostId;
    @com.google.gson.annotations.SerializedName("eventMaxParticipators")
    private int    eventMaxParticipators;
    private String title;

    public EventTbl(String id, String eventLocation, String adress, Date eventBegin, Date eventEnd, String hostId, int eventMaxParticipators, String title) {
        this.id = id;
        this.eventLocation = eventLocation;
        this.adress = adress;
        this.eventBegin = eventBegin;
        this.eventEnd = eventEnd;
        this.hostId = hostId;
        this.eventMaxParticipators = eventMaxParticipators;
        this.title = title;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
