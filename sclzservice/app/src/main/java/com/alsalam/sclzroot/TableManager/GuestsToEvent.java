package com.alsalam.sclzroot.TableManager;

/**
 * Created by samih on 14/03/2016.
 */
public class GuestsToEvent {

    @com.google.gson.annotations.SerializedName("id")
    private String id;
    @com.google.gson.annotations.SerializedName("eventid")

    private String eventid;
    @com.google.gson.annotations.SerializedName("userId")

    private String userId;//Guest
    @com.google.gson.annotations.SerializedName("Status")

    private String Status= EventTbl.WAITING;
    @com.google.gson.annotations.SerializedName("iNeed")

    private String iNeed;
    @com.google.gson.annotations.SerializedName("iBring")

    private  String iBring;
    @com.google.gson.annotations.SerializedName("countP")

    private String countP;



    public GuestsToEvent() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getiNeed() {
        return iNeed;
    }

    public void setiNeed(String iNeed) {
        this.iNeed = iNeed;
    }

    public String getiBring() {
        return iBring;
    }

    public void setiBring(String iBring) {
        this.iBring = iBring;
    }

    public String getCountP() {
        return countP;
    }

    public void setCountP(String countP) {
        this.countP = countP;
    }

    public GuestsToEvent(String id, String eventid, String userId, String status) {
        this.id = id;
        this.eventid = eventid;
        this.userId = userId;
        Status = status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus() {

        return Status;
    }

    @Override
    public String toString() {
        return "GuestsToEvent{" +
                "id='" + id + '\'' +
                ", eventid='" + eventid + '\'' +
                ", userId='" + userId + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }


}
