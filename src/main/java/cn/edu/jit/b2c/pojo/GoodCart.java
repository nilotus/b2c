package cn.edu.jit.b2c.pojo;

public class GoodCart {
    private int good_id;

    private int goodnum;

    public GoodCart(int good_id, int goodnum) {
        this.good_id = good_id;
        this.goodnum = goodnum;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(int goodnum) {
        this.goodnum = goodnum;
    }
}
