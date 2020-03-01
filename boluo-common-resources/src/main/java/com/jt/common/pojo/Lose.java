package com.jt.common.pojo;

public class Lose {
    //丢失动物表

    private Integer loseId;     //丢失动物找寻表ID
    private String loseTitle;   //标题
    private String loseImage;   //照片
    private String loseInfo;    //信息

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


}
