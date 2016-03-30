package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016
 */
public class UserTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    @com.google.gson.annotations.SerializedName("firstName")
    private String firstName;
    @com.google.gson.annotations.SerializedName("lastName")
     private String lastName ;


    @com.google.gson.annotations.SerializedName("status")

    private String status;

    @com.google.gson.annotations.SerializedName("userEmail")
    private String userEmail;
    @com.google.gson.annotations.SerializedName("userTafkeed")
    private String userTafkeed;

    public final static String Wait = "Wait";
    public final static String Maneger = "Maneger";
    public final static String Teenager = "Teenager";

    public final static String Coordinator = "Coordinator";
    public final static String Guide = "Guide";
    @com.google.gson.annotations.SerializedName("userAddress")
    private String userAddress;
    @com.google.gson.annotations.SerializedName("userBirthday")
    private Date   userBirthday;
    @com.google.gson.annotations.SerializedName("userGender")
    private String userGender;
    @com.google.gson.annotations.SerializedName("userPhone")
    private String userPhone;
    @com.google.gson.annotations.SerializedName("userName")
    private String userName;
    @com.google.gson.annotations.SerializedName("userPassword")
    private String userPassword;

    public UserTbl(String mid, String userName, String userPassword, String firstName, String lastName, String userEmail, String userTafkeed, String userAddress, Date userBirthday, String userGender, String userPhone) {
        setId(mid);
        setFirstName(firstName);
        setLastName(lastName);
        setUserEmail(userEmail);
        setUserTafkeed(userTafkeed);
        setUserAddress(userAddress);
        setUserBirthday(userBirthday);
        setUserGender(userGender);
        setUserPhone(userPhone);
        setUserName(userName);
        setUserPassword(userPassword);
    }



    public UserTbl() {
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

    public String getUserPassword() {
        return userPassword;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
