package com.jt.common.pojo;

public class Handle {

    private int handleId;       //表ID   (自增)
    private int userid;         //用户ID(cookie)
    private String userName;    //用户名(cookie)
    private int fixId;          //维修人员ID(cookie)
    private int handleStatus;   //表状态码(默认1  完成之后变成2)

    public int getHandleId() {
        return handleId;
    }

    public void setHandleId(int handleId) {
        this.handleId = handleId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    @Override
    public String toString() {
        return "Handle{" +
                "handleId=" + handleId +
                ", userid=" + userid +
                ", userName='" + userName + '\'' +
                ", fixId=" + fixId +
                ", handleStatus=" + handleStatus +
                '}';
    }

}
