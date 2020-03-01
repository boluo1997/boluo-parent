package com.jt.common.pojo;

import java.util.Date;

public class Adopt {
    //领养信息表
    private Integer userId;
    private Integer animalId;
    private Date AdoptCreateTime;

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

    public Date getAdoptCreateTime() {
        return AdoptCreateTime;
    }

    public void setAdoptCreateTime(Date adoptCreateTime) {
        AdoptCreateTime = adoptCreateTime;
    }
}
