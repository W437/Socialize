package com.alsalam.sclzroot.TableManager;

/**
 * Created by samih on 14/03/2016.
 */
public class GuestsToEvent {

    @com.google.gson.annotations.SerializedName("id")
    private String id;
    private String eventid;
    private String userId;//Guest
    private boolean isApproved=false;

    public GuestsToEvent(String eventid, String userId, boolean isApproved) {
        this.eventid = eventid;
        this.userId = userId;
        this.isApproved = isApproved;
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

    public boolean isApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    @Override
    public String toString() {
        return "GuestsToEvent{" +
                "id='" + id + '\'' +
                ", eventid='" + eventid + '\'' +
                ", userId='" + userId + '\'' +
                ", isApproved=" + isApproved +
                '}';
    }
}
