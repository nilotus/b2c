package cn.edu.jit.b2c.pojo;

import java.sql.Timestamp;

public class Order {
    private int order_id;

    private Timestamp time;

    private float price;

    private int user_id;

    private int num;

    private int good_id;

    private float total_fee;

    private int shop_id;

    private String description;

    private int status;

    public Order(int order_id, Timestamp time, float price, int user_id, int num, int good_id, float total_fee, int shop_id, String description, int status) {
        this.order_id = order_id;
        this.time = time;
        this.price = price;
        this.user_id = user_id;
        this.num = num;
        this.good_id = good_id;
        this.total_fee = total_fee;
        this.shop_id = shop_id;
        this.description = description;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
