package com.jt.common.pojo;

public class Message {
    private int messageId;
    private int wenzhangId;
    private String userName;
    private String leaveMessage;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getWenzhangId() {
        return wenzhangId;
    }

    public void setWenzhangId(int wenzhangId) {
        this.wenzhangId = wenzhangId;
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
        return "Message{" +
                "messageId=" + messageId +
                ", wenzhangId=" + wenzhangId +
                ", userName='" + userName + '\'' +
                ", leaveMessage='" + leaveMessage + '\'' +
                '}';
    }
}
