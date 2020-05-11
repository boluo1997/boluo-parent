package com.jt.common.pojo;

import java.util.Date;

public class Adoption {
    private int userId;
    private String userName;
    private int animalId;
    private String animalName;
    private Date adoptCreateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Date getAdoptCreateTime() {
        return adoptCreateTime;
    }

    public void setAdoptCreateTime(Date adoptCreateTime) {
        this.adoptCreateTime = adoptCreateTime;
    }


}
