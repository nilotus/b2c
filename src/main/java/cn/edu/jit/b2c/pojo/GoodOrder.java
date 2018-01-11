package cn.edu.jit.b2c.pojo;

public class GoodOrder {
    private int pay_id;

    private int good_id;

    private int goodnum;

    private float price;

    public GoodOrder(int pay_id, int good_id,float price, int goodnum) {
        this.pay_id = pay_id;
        this.good_id = good_id;
        this.price = price;
        this.goodnum = goodnum;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public GoodOrder(int good_id, int goodnum) {
        this.good_id = good_id;
        this.goodnum = goodnum;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(int goodnum) {
        this.goodnum = goodnum;
    }
}
