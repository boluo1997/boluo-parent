package com.jt.common.pojo;

//患者表
public class Huanzhe {
    private int huanzheId;      //表ID
    private String diqu;        //地区
    private String xianyou;     //现有确诊
    private String leiji;       //累计确诊
    private String bijiao;      //较上日
    private String live;        //治愈
    private String death;       //死亡

    public int getHuanzheId() {
        return huanzheId;
    }

    public void setHuanzheId(int huanzheId) {
        this.huanzheId = huanzheId;
    }

    public String getDiqu() {
        return diqu;
    }

    public void setDiqu(String diqu) {
        this.diqu = diqu;
    }

    public String getXianyou() {
        return xianyou;
    }

    public void setXianyou(String xianyou) {
        this.xianyou = xianyou;
    }

    public String getLeiji() {
        return leiji;
    }

    public void setLeiji(String leiji) {
        this.leiji = leiji;
    }

    public String getBijiao() {
        return bijiao;
    }

    public void setBijiao(String bijiao) {
        this.bijiao = bijiao;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    @Override
    public String toString() {
        return "Huanzhe{" +
                "huanzheId=" + huanzheId +
                ", diqu='" + diqu + '\'' +
                ", xianyou='" + xianyou + '\'' +
                ", leiji='" + leiji + '\'' +
                ", bijiao='" + bijiao + '\'' +
                ", live='" + live + '\'' +
                ", death='" + death + '\'' +
                '}';
    }
}
