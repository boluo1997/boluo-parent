package com.jt.common.pojo;

//物资数量
public class Goods {
    private int goosId;
    private int goodsKouzhao;
    private int goodsXiaodu;
    private int goodsTiwen;

    public int getGoosId() {
        return goosId;
    }

    public void setGoosId(int goosId) {
        this.goosId = goosId;
    }

    public int getGoodsKouzhao() {
        return goodsKouzhao;
    }

    public void setGoodsKouzhao(int goodsKouzhao) {
        this.goodsKouzhao = goodsKouzhao;
    }

    public int getGoodsXiaodu() {
        return goodsXiaodu;
    }

    public void setGoodsXiaodu(int goodsXiaodu) {
        this.goodsXiaodu = goodsXiaodu;
    }

    public int getGoodsTiwen() {
        return goodsTiwen;
    }

    public void setGoodsTiwen(int goodsTiwen) {
        this.goodsTiwen = goodsTiwen;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goosId=" + goosId +
                ", goodsKouzhao=" + goodsKouzhao +
                ", goodsXiaodu=" + goodsXiaodu +
                ", goodsTiwen=" + goodsTiwen +
                '}';
    }

}
