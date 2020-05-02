package com.jt.common.pojo;

public class Handle {

    private int handleId;       //表ID   (自增)
    private int userId;         //用户ID(cookie)
    private String userName;    //用户名(cookie)
    private int fixId;          //维修人员ID(cookie)
    private int handleStatus;   //表状态码(默认1  完成之后变成2)
    private String fixerName;   //维修人员姓名

    public int getHandleId() {
        return handleId;
    }

    public void setHandleId(int handleId) {
        this.handleId = handleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userid) {
        this.userId = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFixId() {
        return fixId;
    }

    public void setFixId(int fixId) {
        this.fixId = fixId;
    }

    public int getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(int handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getFixerName() {
        return fixerName;
    }

    public void setFixerName(String fixerName) {
        this.fixerName = fixerName;
    }

    @Override
    public String toString() {
        return "Handle{" +
                "handleId=" + handleId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", fixId=" + fixId +
                ", handleStatus=" + handleStatus +
                ", fixerName='" + fixerName + '\'' +
                '}';
    }
}
