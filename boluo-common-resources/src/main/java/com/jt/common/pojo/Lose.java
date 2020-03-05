package com.jt.common.pojo;

import java.util.Date;

public class Lose {
    //丢失动物信息发布表

    private Integer loseId;         //丢失动物找寻表ID
    private String loseTitle;       //标题
    private String loseImage;       //照片
    private String loseInfo;        //信息
    private String loseType;        //类型(猫、狗)
    private Date loseCreateTime;    //创建时间
    private String loseName;        //丢失者姓名
    private String loseAddress;     //丢失者地址
    private String losePhone;       //丢失者电话

    private String MessageName;     //留言者姓名
    private String MessageContent;  //留言内容

    public Integer getLoseId() {
        return loseId;
    }

    public void setLoseId(Integer loseId) {
        this.loseId = loseId;
    }

    public String getLoseTitle() {
        return loseTitle;
    }

    public void setLoseTitle(String loseTitle) {
        this.loseTitle = loseTitle;
    }

    public String getLoseImage() {
        return loseImage;
    }

    public void setLoseImage(String loseImage) {
        this.loseImage = loseImage;
    }

    public String getLoseInfo() {
        return loseInfo;
    }

    public void setLoseInfo(String loseInfo) {
        this.loseInfo = loseInfo;
    }

    public String getLoseType() {
        return loseType;
    }

    public void setLoseType(String loseType) {
        this.loseType = loseType;
    }

    public Date getLoseCreateTime() {
        return loseCreateTime;
    }

    public void setLoseCreateTime(Date loseCreateTime) {
        this.loseCreateTime = loseCreateTime;
    }

    public String getLoseName() {
        return loseName;
    }

    public void setLoseName(String loseName) {
        this.loseName = loseName;
    }

    public String getLoseAddress() {
        return loseAddress;
    }

    public void setLoseAddress(String loseAddress) {
        this.loseAddress = loseAddress;
    }

    public String getLosePhone() {
        return losePhone;
    }

    public void setLosePhone(String losePhone) {
        this.losePhone = losePhone;
    }

    public String getMessageName() {
        return MessageName;
    }

    public void setMessageName(String messageName) {
        MessageName = messageName;
    }

    public String getMessageContent() {
        return MessageContent;
    }

    public void setMessageContent(String messageContent) {
        MessageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Lose{" +
                "loseId=" + loseId +
                ", loseTitle='" + loseTitle + '\'' +
                ", loseImage='" + loseImage + '\'' +
                ", loseInfo='" + loseInfo + '\'' +
                ", loseType='" + loseType + '\'' +
                ", loseCreateTime=" + loseCreateTime +
                ", loseName='" + loseName + '\'' +
                ", loseAddress='" + loseAddress + '\'' +
                ", losePhone='" + losePhone + '\'' +
                ", MessageName='" + MessageName + '\'' +
                ", MessageContent='" + MessageContent + '\'' +
                '}';
    }
}
