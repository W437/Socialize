package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class UserTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String mid;
    @com.google.gson.annotations.SerializedName("firstName")
    private String firstName;
    @com.google.gson.annotations.SerializedName("lastName")
    private String lastName;
    @com.google.gson.annotations.SerializedName("userEmail")
    private String userEmail;
    @com.google.gson.annotations.SerializedName("userTafkeed")
    private String userTafkeed;
    @com.google.gson.annotations.SerializedName("userAddress")
    private String userAddress;
    @com.google.gson.annotations.SerializedName("userBirthday")
    private Date   userBirthday;
    @com.google.gson.annotations.SerializedName("userGender")
    private String userGender;
    @com.google.gson.annotations.SerializedName("userPhone")
    private String userPhone;

    public UserTbl(String id, String firstName, String lastName, String userEmail, String userTafkeed, String userAddress, Date userBirthday, String userGender, String userPhone) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setUserEmail(userEmail);
        setUserTafkeed(userTafkeed);
        setUserAddress(userAddress);
        setUserBirthday(userBirthday);
        setUserGender(userGender);
        setUserPhone(userPhone);
    }

    public UserTbl() {
    }

    public String getId() {
        return mid;
    }

    public void setId(String id) {
        this.mid = id;
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
                "id='" + mid + '\'' +
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
