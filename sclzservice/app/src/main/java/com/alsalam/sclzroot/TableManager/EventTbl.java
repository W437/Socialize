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


    public EventTbl(String id, String eventLocation, String eventTitle, String eventBegin, String eventDate, String eventEnd, String hostId, int eventMaxParticipators,
                    String eventPurpose, String eventProp, String eventActivityLocation, String eventGenderPref, String EventAgeRange) {
        setId(id);
        setEventLocation(eventLocation);
        setEventBegin(eventBegin);
        setEventEnd(eventEnd);
        setHostId(hostId);
        setEventMaxParticipators(eventMaxParticipators);
        setEventTitle(eventTitle);
        setEventDate(eventDate);
        setEventPurpose(eventPurpose);
        setEventProp(eventProp);
        setEventActivityLocation(eventActivityLocation);
        setEventGenderPref(eventGenderPref);
        setEventAgeRange(EventAgeRange);

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setEventAgeRange(String EventAgeRange) {
        this.EventAgeRange = EventAgeRange;
    }

    @Override
    public String toString() {
        return "EventTbl{" +
                "id='" + id + '\'' +
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
