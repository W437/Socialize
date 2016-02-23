package com.alsalam.sclzroot.TableManager;

/**
 * Created by משתמש on 2/23/2016.
 */
public class GroupTbl {
    private String id;
    private String userId;
    private String groupName;
    private int    groupMaxParticipants;
    private int    groupMinAge;
    private int    groupMaxAge;
    private String groupAddress;
    private String groupLocation;
    private String groupSubject;

    public GroupTbl(String id, String userId, String groupName, int groupMaxParticipants, int groupMinAge, int groupMaxAge, String groupAddress, String groupLocation, String groupSubject) {
        this.id = id;
        this.userId = userId;
        this.groupName = groupName;
        this.groupMaxParticipants = groupMaxParticipants;
        this.groupMinAge = groupMinAge;
        this.groupMaxAge = groupMaxAge;
        this.groupAddress = groupAddress;
        this.groupLocation = groupLocation;
        this.groupSubject = groupSubject;
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
