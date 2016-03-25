package com.alsalam.sclzroot.TableManager;


import java.util.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class EventTbl {

    @com.google.gson.annotations.SerializedName("id")
    private String id;



    private String status;

    public final static String WAITING = "WAITING";
    public final static String ACCEPTED = "ACCEPTED";
    public final static String CANCELED = "CANCELED";
    public final static String REJECTED = "REJECTED";
    @com.google.gson.annotations.SerializedName("addressLocation")
    private String addressLocation;
    @com.google.gson.annotations.SerializedName("date")
    private Date date;
    @com.google.gson.annotations.SerializedName("month")
    private int month   ;
    @com.google.gson.annotations.SerializedName("year")
    private int year   ;

    @com.google.gson.annotations.SerializedName("hours")
    private int hours;
    @com.google.gson.annotations.SerializedName("hostId")
    private String hostId;
    @com.google.gson.annotations.SerializedName("maxParticipants")
    private int maxParticipants;
    @com.google.gson.annotations.SerializedName("title")
    private String title;
    @com.google.gson.annotations.SerializedName("description")
    private String description;


    @com.google.gson.annotations.SerializedName("requirements")
    private String requirements;
    @com.google.gson.annotations.SerializedName("lang")
    private double    lang;
    @com.google.gson.annotations.SerializedName("lat")
    private double    lat;

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}