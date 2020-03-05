package com.jt.common.pojo;

public class Animal {
    private Integer animalId;
    private String animalName;
    private String animalImage;
    private String animalType;
    private String animalInfo;

    private String giveName;
    private String giveTitle;
    private String givePhone;
    private String giveAddress;

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

    public String getGiveName() {
        return giveName;
    }

    public void setGiveName(String giveName) {
        this.giveName = giveName;
    }

    public String getGiveTitle() {
        return giveTitle;
    }

    public void setGiveTitle(String giveTitle) {
        this.giveTitle = giveTitle;
    }

    public String getGivePhone() {
        return givePhone;
    }

    public void setGivePhone(String givePhone) {
        this.givePhone = givePhone;
    }

    public String getGiveAddress() {
        return giveAddress;
    }

    public void setGiveAddress(String giveAddress) {
        this.giveAddress = giveAddress;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", animalName='" + animalName + '\'' +
                ", animalImage='" + animalImage + '\'' +
                ", animalType='" + animalType + '\'' +
                ", animalInfo='" + animalInfo + '\'' +
                ", giveName='" + giveName + '\'' +
                ", giveTitle='" + giveTitle + '\'' +
                ", givePhone='" + givePhone + '\'' +
                ", giveAddress='" + giveAddress + '\'' +
                '}';
    }

}
