package com.alsalam.sclzroot.TableManager;

/**
 * Created by משתמש on 2/23/2016.
 */
public class GroupTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    @com.google.gson.annotations.SerializedName("userId")
    private String userId;
    @com.google.gson.annotations.SerializedName("groupName")
    private String groupName;
    @com.google.gson.annotations.SerializedName("groupMaxParticipants")
    private int    groupMaxParticipants;
    @com.google.gson.annotations.SerializedName("groupMinAge")
    private int    groupMinAge;
    @com.google.gson.annotations.SerializedName("groupMaxAge")
    private int    groupMaxAge;
    @com.google.gson.annotations.SerializedName("groupAddress")
    private String groupAddress;
    @com.google.gson.annotations.SerializedName("groupLocation")
    private String groupLocation;
    @com.google.gson.annotations.SerializedName("groupSubject")
    private String groupSubject;

    public GroupTbl(String id, String userId, String groupName, int groupMaxParticipants, int groupMinAge, int groupMaxAge, String groupAddress, String groupLocation, String groupSubject) {
        setId(id);
        setUserId(userId);
        setGroupName(groupName);
        setGroupMaxParticipants(groupMaxParticipants);
        setGroupMinAge(groupMinAge);
        setGroupMaxAge(groupMaxAge);
        setGroupAddress(groupAddress);
        setGroupLocation(groupLocation);
        setGroupSubject(groupSubject);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupMaxParticipants() {
        return groupMaxParticipants;
    }

    public void setGroupMaxParticipants(int groupMaxParticipants) {
        this.groupMaxParticipants = groupMaxParticipants;
    }

    public int getGroupMinAge() {
        return groupMinAge;
    }

    public void setGroupMinAge(int groupMinAge) {
        this.groupMinAge = groupMinAge;
    }

    public int getGroupMaxAge() {
        return groupMaxAge;
    }

    public void setGroupMaxAge(int groupMaxAge) {
        this.groupMaxAge = groupMaxAge;
    }

    public String getGroupAddress() {
        return groupAddress;
    }

    public void setGroupAddress(String groupAddress) {
        this.groupAddress = groupAddress;
    }

    public String getGroupLocation() {
        return groupLocation;
    }

    public void setGroupLocation(String groupLocation) {
        this.groupLocation = groupLocation;
    }

    public String getGroupSubject() {
        return groupSubject;
    }

    public void setGroupSubject(String groupSubject) {
        this.groupSubject = groupSubject;
    }


}
