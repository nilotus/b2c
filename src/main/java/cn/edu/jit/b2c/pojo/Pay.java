package cn.edu.jit.b2c.pojo;

public class Pay {
    private int pay_id;

    private int order_id;

    private int num;

    private float price;

    private int good_id;

    private float total_fee;

    public Pay(int pay_id, int order_id, int num, float price, int good_id, float total_fee) {
        this.pay_id = pay_id;
        this.order_id = order_id;
        this.num = num;
        this.price = price;
        this.good_id = good_id;
        this.total_fee = total_fee;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public float getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(float total_fee) {
        this.total_fee = total_fee;
    }
}
