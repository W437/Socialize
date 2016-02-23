package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class UserTbl {
    private String id;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userTafkeed;
    private String userAddress;
    private Date   userBirthday;
    private String userGender;
    private String userPhone;

    public UserTbl(String id, String firstName, String lastName, String userEmail, String userTafkeed, String userAddress, Date userBirthday, String userGender, String userPhone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userTafkeed = userTafkeed;
        this.userAddress = userAddress;
        this.userBirthday = userBirthday;
        this.userGender = userGender;
        this.userPhone = userPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTafkeed() {
        return userTafkeed;
    }

    public void setUserTafkeed(String userTafkeed) {
        this.userTafkeed = userTafkeed;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "UserTbl{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userTafkeed='" + userTafkeed + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userBirthday=" + userBirthday +
                ", userGender='" + userGender + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

}
