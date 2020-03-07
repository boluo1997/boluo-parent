package com.jt.common.pojo;

public class LeaveMessage {

    private Integer leaveId;
    private Integer loseId;
    private String userName;
    private String leaveMessage;

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getLoseId() {
        return loseId;
    }

    public void setLoseId(Integer loseId) {
        this.loseId = loseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    @Override
    public String toString() {
        return "LeaveMessage{" +
                "leaveId=" + leaveId +
                ", loseId=" + loseId +
                ", userName='" + userName + '\'' +
                ", leaveMessage='" + leaveMessage + '\'' +
                '}';
    }

}
