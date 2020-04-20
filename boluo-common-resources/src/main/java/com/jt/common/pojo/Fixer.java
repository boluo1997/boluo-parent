package com.jt.common.pojo;

public class Fixer {
    private int fixerId;        //ID
    private String userName;    //用户名
    private String password;    //密码
    private String name;        //真实姓名
    private String shenfenNum;  //身份证号
    private String phone;       //手机号
    private int status;         //状态码

    public int getFixerId() {
        return fixerId;
    }

    public void setFixerId(int fixerId) {
        this.fixerId = fixerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShenfenNum() {
        return shenfenNum;
    }

    public void setShenfenNum(String shenfenNum) {
        this.shenfenNum = shenfenNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Fixer{" +
                "fixerId=" + fixerId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", shenfenNum='" + shenfenNum + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
