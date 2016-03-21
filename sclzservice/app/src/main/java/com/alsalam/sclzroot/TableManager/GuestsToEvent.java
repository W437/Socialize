package com.alsalam.sclzroot.TableManager;

/**
 * Created by samih on 14/03/2016.
 */
public class GuestsToEvent {

    @com.google.gson.annotations.SerializedName("id")
    private String id;
    private String eventid;
    private String userId;//Guest
    private String Status= EventTbl.WAITING;

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
