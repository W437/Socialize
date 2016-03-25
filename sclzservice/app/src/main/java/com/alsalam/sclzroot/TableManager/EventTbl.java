package com.alsalam.sclzroot.TableManager;


import java.util.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class EventTbl {

    @com.google.gson.annotations.SerializedName("id")
    private String id;


    public final static String WAITING = "WAITING";
    public final static String ACCEPTED = "ACCEPTED";
    public final static String CANCELED = "CANCELED";
    public final static String REJECTED = "REJECTED";

    public String getSatus() {
        return satus;
    }

    public void setSatus(String satus) {
        this.satus = satus;
    }

    public double getLang() {
        return lang;
    }

    public double getLat() {
        return lat;
    }

    @com.google.gson.annotations.SerializedName("eventLocation")
    private String  satus;

    private String eventLocation;
    @com.google.gson.annotations.SerializedName("eventDate")
    private String   eventDate;
    @com.google.gson.annotations.SerializedName("eventTime")
    private String   eventTime;
    @com.google.gson.annotations.SerializedName("eventHours")
    private String   eventHours;
    @com.google.gson.annotations.SerializedName("hostId")
    private String hostId;
    @com.google.gson.annotations.SerializedName("eventMaxParticipants")
    private int    eventMaxParticipants;
    @com.google.gson.annotations.SerializedName("eventTitle")
    private String    eventTitle;
    @com.google.gson.annotations.SerializedName("eventDescription")
    private String    eventDescription;
    @com.google.gson.annotations.SerializedName("eventActivityLocation")
    private String    eventActivityLocation;
    @com.google.gson.annotations.SerializedName("eventGenderPref")
    private String    eventGenderPref;
    @com.google.gson.annotations.SerializedName("eventAgeRange")
    private String    eventAgeRange;
    @com.google.gson.annotations.SerializedName("eventRequirements")
    private String    eventRequirements;
    @com.google.gson.annotations.SerializedName("lang")
    private double    lang;
    @com.google.gson.annotations.SerializedName("lat")
    private double    lat;



    public EventTbl(String id, String eventLocation, String eventDate, String eventTime, String eventHours, String hostId, int eventMaxParticipants, String eventTitle, String eventDescription, String eventActivityLocation, String eventGenderPref, String eventAgeRange, String eventRequirements, String eventSummary) {
        this.id = id;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventHours = eventHours;
        this.hostId = hostId;
        this.eventMaxParticipants = eventMaxParticipants;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventActivityLocation = eventActivityLocation;
        this.eventGenderPref = eventGenderPref;
        this.eventAgeRange = eventAgeRange;
        this.eventRequirements = eventRequirements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public static String getWAITING() {
        return WAITING;
    }

    public static String getACCEPTED() {
        return ACCEPTED;
    }

    public static String getCANCELED() {
        return CANCELED;
    }

    public static String getREJECTED() {
        return REJECTED;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventHours() {
        return eventHours;
    }

    public void setEventHours(String eventHours) {
        this.eventHours = eventHours;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public int getEventMaxParticipants() {
        return eventMaxParticipants;
    }

    public void setEventMaxParticipants(int eventMaxParticipants) {
        this.eventMaxParticipants = eventMaxParticipants;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
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
        return eventAgeRange;
    }

    public void setEventAgeRange(String eventAgeRange) {
        this.eventAgeRange = eventAgeRange;
    }

    public String getEventRequirements() {
        return eventRequirements;
    }

    public void setEventRequirements(String eventRequirements) {
        this.eventRequirements = eventRequirements;
    }

    public EventTbl() {

    }


    @Override
    public String toString() {
        return "EventTbl{" +
                "id='" + id + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", eventHours='" + eventHours + '\'' +
                ", hostId='" + hostId + '\'' +
                ", eventMaxParticipants=" + eventMaxParticipants +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventActivityLocation='" + eventActivityLocation + '\'' +
                ", eventGenderPref='" + eventGenderPref + '\'' +
                ", eventAgeRange='" + eventAgeRange + '\'' +
                ", eventRequirements='" + eventRequirements + '\'' +
                '}';
    }
}