package com.jt.common.pojo;

public class Fix {

    private int fixId;
    private String userName;
    private String gender;
    private String grade;   //年级
    private String num;     //宿舍楼号
    private String phone;
    private String date;
    private String object;
    private String info;
    private String Image;
    private int status;

    public int getFixId() {
        return fixId;
    }

    public void setFixId(int fixId) {
        this.fixId = fixId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Fix{" +
                "fixId=" + fixId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                ", num='" + num + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", object='" + object + '\'' +
                ", info='" + info + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
