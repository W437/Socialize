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
    @com.google.gson.annotations.SerializedName("eventTime")
    private String   eventTime;
    @com.google.gson.annotations.SerializedName("eventHours")
    private String   eventHours;
    @com.google.gson.annotations.SerializedName("hostId")
    private String hostId;
    @com.google.gson.annotations.SerializedName("eventParticipantsLimit")
    private int    eventParticipantsLimit;
    @com.google.gson.annotations.SerializedName("eventRequirements")
    private String    eventRequirements;
    @com.google.gson.annotations.SerializedName("eventDate")
    private String    eventDate;
    @com.google.gson.annotations.SerializedName("eventActivityLocation")
    private String    eventActivityLocation;
    @com.google.gson.annotations.SerializedName("eventGenderPref")
    private String    eventGenderPref;
    @com.google.gson.annotations.SerializedName("eventAgeRange")
    private String    eventAgeRange;
    @com.google.gson.annotations.SerializedName("eventTitle")
    private String    eventTitle;
    @com.google.gson.annotations.SerializedName("eventDescription")
    private String    eventDescription;

    public EventTbl(String id, String eventLocation, String eventTime, String eventHours, String hostId, int eventParticipantsLimit, String eventRequirements, String eventDate, String eventActivityLocation, String eventGenderPref, String eventAgeRange, String eventTitle, String eventDescription) {
        this.id = id;
        this.eventLocation = eventLocation;
        this.eventTime = eventTime;
        this.eventHours = eventHours;
        this.hostId = hostId;
        this.eventParticipantsLimit = eventParticipantsLimit;
        this.eventRequirements = eventRequirements;
        this.eventDate = eventDate;
        this.eventActivityLocation = eventActivityLocation;
        this.eventGenderPref = eventGenderPref;
        this.eventAgeRange = eventAgeRange;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
    }

    public EventTbl(){}

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

    public int getEventParticipantsLimit() {
        return eventParticipantsLimit;
    }

    public void setEventParticipantsLimit(int eventParticipantsLimit) {
        this.eventParticipantsLimit = eventParticipantsLimit;
    }

    public String getEventRequirements() {
        return eventRequirements;
    }

    public void setEventRequirements(String eventRequirements) {
        this.eventRequirements = eventRequirements;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
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
}