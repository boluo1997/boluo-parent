package com.jt.common.pojo;

public class Shenqing {

    private int shenqingId;
    private int userId;
    private String userName;
    private String userPhone;
    private String userInfo;
    private String shenqingStatus;
    private String shenqingAddress;
    private int shenqingType;

    public int getShenqingId() {
        return shenqingId;
    }

    public void setShenqingId(int shenqingId) {
        this.shenqingId = shenqingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getShenqingStatus() {
        return shenqingStatus;
    }

    public void setShenqingStatus(String shenqingStatus) {
        this.shenqingStatus = shenqingStatus;
    }

    public String getShenqingAddress() {
        return shenqingAddress;
    }

    public void setShenqingAddress(String shenqingAddress) {
        this.shenqingAddress = shenqingAddress;
    }

    public int getShenqingType() {
        return shenqingType;
    }

    public void setShenqingType(int shenqingType) {
        this.shenqingType = shenqingType;
    }

    @Override
    public String toString() {
        return "Shenqing{" +
                "shenqingId=" + shenqingId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", shenqingStatus='" + shenqingStatus + '\'' +
                ", shenqingAddress='" + shenqingAddress + '\'' +
                ", shenqingType=" + shenqingType +
                '}';
    }

}
