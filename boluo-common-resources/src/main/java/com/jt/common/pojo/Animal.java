package com.jt.common.pojo;

public class Animal {
    private Integer animalId;
    private String animalName;
    private String animalImage;
    private String animalType;
    private String animalInfo;

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalInfo() {
        return animalInfo;
    }

    public void setAnimalInfo(String animalInfo) {
        this.animalInfo = animalInfo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", animalName='" + animalName + '\'' +
                ", animalImage='" + animalImage + '\'' +
                ", animalType='" + animalType + '\'' +
                ", animalInfo='" + animalInfo + '\'' +
                '}';
    }
}
