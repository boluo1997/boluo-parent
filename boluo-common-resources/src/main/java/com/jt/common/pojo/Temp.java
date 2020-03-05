package com.jt.common.pojo;

public class Temp {

    //伪领养表  在用户申请领养时 暂时存放在这个表中  等待管理员批准
    private Integer tempId;
    private Integer userId;
    private Integer animalId;
    private Integer statusId;
    private String userName;

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "tempId=" + tempId +
                ", userId=" + userId +
                ", animalId=" + animalId +
                ", statusId=" + statusId +
                ", userName='" + userName + '\'' +
                '}';
    }

}
