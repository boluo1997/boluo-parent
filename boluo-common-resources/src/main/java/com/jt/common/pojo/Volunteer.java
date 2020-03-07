package com.jt.common.pojo;

public class Volunteer {

    private Integer volunteerId;    //主键
    private Integer userId;         //外键

    private String volunteerName;   //姓名
    private String volunteerGender; //性别
    private String volunteerAge;    //年龄

    private String volunteerAddress; //地址
    private String volunteerPhone;   //手机号
    private String volunteerImage;   //头像

    private Integer volunteerStatus; //状态码

    public Integer getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Integer volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getVolunteerGender() {
        return volunteerGender;
    }

    public void setVolunteerGender(String volunteerGender) {
        this.volunteerGender = volunteerGender;
    }

    public String getVolunteerAge() {
        return volunteerAge;
    }

    public void setVolunteerAge(String volunteerAge) {
        this.volunteerAge = volunteerAge;
    }

    public String getVolunteerAddress() {
        return volunteerAddress;
    }

    public void setVolunteerAddress(String volunteerAddress) {
        this.volunteerAddress = volunteerAddress;
    }

    public String getVolunteerPhone() {
        return volunteerPhone;
    }

    public void setVolunteerPhone(String volunteerPhone) {
        this.volunteerPhone = volunteerPhone;
    }

    public String getVolunteerImage() {
        return volunteerImage;
    }

    public void setVolunteerImage(String volunteerImage) {
        this.volunteerImage = volunteerImage;
    }

    public Integer getVolunteerStatus() {
        return volunteerStatus;
    }

    public void setVolunteerStatus(Integer volunteerStatus) {
        this.volunteerStatus = volunteerStatus;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "volunteerId=" + volunteerId +
                ", userId=" + userId +
                ", volunteerName='" + volunteerName + '\'' +
                ", volunteerGender='" + volunteerGender + '\'' +
                ", volunteerAge='" + volunteerAge + '\'' +
                ", volunteerAddress='" + volunteerAddress + '\'' +
                ", volunteerPhone='" + volunteerPhone + '\'' +
                ", volunteerImage='" + volunteerImage + '\'' +
                ", volunteerStatus=" + volunteerStatus +
                '}';
    }

}
