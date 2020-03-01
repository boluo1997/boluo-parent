package com.jt.common.pojo;

public class Temp {

    //伪领养表  在用户申请领养时 暂时存放在这个表中  等待管理员批准
    private Integer tempId;
    private Integer userId;
    private Integer animalId;

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
}
