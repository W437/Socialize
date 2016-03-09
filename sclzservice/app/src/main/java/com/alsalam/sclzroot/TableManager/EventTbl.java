package com.alsalam.sclzroot.TableManager;


import java.util.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class EventTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    private String eventSummary ;
    private String adress;
    private String eventTitle;
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

    public EventTbl(String id, String eventSummary, String adress, String eventTitle, String eventLocation, Date eventBegin, Date eventEnd, String hostId, int eventMaxParticipators) {
        this.id = id;
        this.eventSummary = eventSummary;
        this.adress = adress;
        this.eventTitle = eventTitle;
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

    public String getEventSummary() {
        return eventSummary;
    }

    public void setEventSummary(String eventSummary) {
        this.eventSummary = eventSummary;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
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
