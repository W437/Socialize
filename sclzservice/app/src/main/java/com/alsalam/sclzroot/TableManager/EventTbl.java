package com.alsalam.sclzroot.TableManager;


import java.util.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class EventTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    private String Adress="home";
    private String EventSummary;
    private boolean isCompleted=false;
    private boolean isAccepted;
    @com.google.gson.annotations.SerializedName("eventLocation")
    private String eventLocation;
    @com.google.gson.annotations.SerializedName("eventBegin")
    private String   eventBegin;
    @com.google.gson.annotations.SerializedName("eventEnd")
    private String   eventEnd;
    @com.google.gson.annotations.SerializedName("hostId")
    private String hostId;
    @com.google.gson.annotations.SerializedName("eventMaxParticipators")
    private int    eventMaxParticipators;
    @com.google.gson.annotations.SerializedName("eventTitle")
    private String    eventTitle;
    @com.google.gson.annotations.SerializedName("eventDate")
    private String    eventDate;
    @com.google.gson.annotations.SerializedName("eventPurpose")
    private String    eventPurpose;
    @com.google.gson.annotations.SerializedName("eventProp")
    private String    eventProp;
    @com.google.gson.annotations.SerializedName("eventActivityLocation")
    private String    eventActivityLocation;
    @com.google.gson.annotations.SerializedName("eventGenderPref")
    private String    eventGenderPref;
    @com.google.gson.annotations.SerializedName("EventAgeRange")
    private String    EventAgeRange;

    public EventTbl(String id, String adress, String eventSummary, String eventLocation, String eventBegin, String eventEnd, String hostId, int eventMaxParticipators, String eventTitle, String eventDate, String eventPurpose, String eventProp, String eventActivityLocation, String eventGenderPref, String eventAgeRange) {
        this.id = id;
        Adress = adress;
        EventSummary = eventSummary;
        this.eventLocation = eventLocation;
        this.eventBegin = eventBegin;
        this.eventEnd = eventEnd;
        this.hostId = hostId;
        this.eventMaxParticipators = eventMaxParticipators;
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventPurpose = eventPurpose;
        this.eventProp = eventProp;
        this.eventActivityLocation = eventActivityLocation;
        this.eventGenderPref = eventGenderPref;
        EventAgeRange = eventAgeRange;
    }

    public EventTbl() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getEventSummary() {
        return EventSummary;
    }

    public void setEventSummary(String eventSummary) {
        EventSummary = eventSummary;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventBegin() {
        return eventBegin;
    }

    public void setEventBegin(String eventBegin) {
        this.eventBegin = eventBegin;
    }

    public String getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(String eventEnd) {
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

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
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

    public String getEventActivityLocation() {
        return eventActivityLocation;
    }

    public void setEventActivityLocation(String eventActivityLocation) {
        this.eventActivityLocation = eventActivityLocation;
    }

    public String getEventGenderPref() {
        return eventGenderPref;
    }

    public void setEventGenderPref(String eventGenderPref) {
        this.eventGenderPref = eventGenderPref;
    }

    public String getEventAgeRange() {
        return EventAgeRange;
    }

    public void setEventAgeRange(String eventAgeRange) {
        EventAgeRange = eventAgeRange;
    }

    @Override
    public String toString() {
        return "EventTbl{" +
                "id='" + id + '\'' +
                ", Adress='" + Adress + '\'' +
                ", EventSummary='" + EventSummary + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventBegin='" + eventBegin + '\'' +
                ", eventEnd='" + eventEnd + '\'' +
                ", hostId='" + hostId + '\'' +
                ", eventMaxParticipators=" + eventMaxParticipators +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventPurpose='" + eventPurpose + '\'' +
                ", eventProp='" + eventProp + '\'' +
                ", eventActivityLocation='" + eventActivityLocation + '\'' +
                ", eventGenderPref='" + eventGenderPref + '\'' +
                ", EventAgeRange='" + EventAgeRange + '\'' +
                '}';
    }
}