package com.jt.common.pojo;

public class Wenzhang {

    private int wenzhangId;
    private String wenzhangTitle;
    private String wenzhangInfo;
    private String wenzhangImg;
    private String userName;
    private int wenzhangStatus;
    private String cTime;

    public int getWenzhangId() {
        return wenzhangId;
    }

    public void setWenzhangId(int wenzhangId) {
        this.wenzhangId = wenzhangId;
    }

    public String getWenzhangTitle() {
        return wenzhangTitle;
    }

    public void setWenzhangTitle(String wenzhangTitle) {
        this.wenzhangTitle = wenzhangTitle;
    }

    public String getWenzhangInfo() {
        return wenzhangInfo;
    }

    public void setWenzhangInfo(String wenzhangInfo) {
        this.wenzhangInfo = wenzhangInfo;
    }

    public String getWenzhangImg() {
        return wenzhangImg;
    }

    public void setWenzhangImg(String wenzhangImg) {
        this.wenzhangImg = wenzhangImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWenzhangStatus() {
        return wenzhangStatus;
    }

    public void setWenzhangStatus(int wenzhangStatus) {
        this.wenzhangStatus = wenzhangStatus;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "Wenzhang{" +
                "wenzhangId=" + wenzhangId +
                ", wenzhangTitle='" + wenzhangTitle + '\'' +
                ", wenzhangInfo='" + wenzhangInfo + '\'' +
                ", wenzhangImg='" + wenzhangImg + '\'' +
                ", userName='" + userName + '\'' +
                ", wenzhangStatus=" + wenzhangStatus +
                ", cTime='" + cTime + '\'' +
                '}';
    }
}
