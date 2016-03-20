package com.alsalam.sclzroot.TableManager;


import java.util.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class EventTbl {

    @com.google.gson.annotations.SerializedName("id")
    private String id;

    public final static String WAITING="waiting";
    public final static String ACCEPTED="ACCEPTED";
    public final static String REJECTED="REJECTED";
    @com.google.gson.annotations.SerializedName("status")
    private String status=WAITING;
    @com.google.gson.annotations.SerializedName("eventLocation")
    private String eventLocation;
    @com.google.gson.annotations.SerializedName("address")
    private String address="home";
//    @com.google.gson.annotations.SerializedName("eventBegin")
//    private String   eventBegin;
//    @com.google.gson.annotations.SerializedName("eventEnd")
//    private String   eventEnd;
    @com.google.gson.annotations.SerializedName("hostId")
    private String hostId;
    @com.google.gson.annotations.SerializedName("eventMaxParticipators")
    private int    eventMaxParticipators;
    @com.google.gson.annotations.SerializedName("eventTitle")
    private String    eventTitle;
    @com.google.gson.annotations.SerializedName("eventDate")
    private Date    eventDate;
    @com.google.gson.annotations.SerializedName("eventPurpose")
    private String    eventPurpose;
    @com.google.gson.annotations.SerializedName("eventProp")
    private String    eventProp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public static String getWAITING() {
        return WAITING;
    }

    public static String getACCEPTED() {
        return ACCEPTED;
    }

    public static String getREJECTED() {
        return REJECTED;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPurpose() {
        return eventPurpose;
    }

    public void setEventPurpose(String eventPurpose) {
        this.eventPurpose = eventPurpose;
    }

    public String getEventProp() {
        return eventProp;
    }

    public void setEventProp(String eventProp) {
        this.eventProp = eventProp;
    }
}