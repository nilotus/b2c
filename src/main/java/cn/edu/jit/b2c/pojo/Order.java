package cn.edu.jit.b2c.pojo;

import java.sql.Timestamp;

public class Order {
    private int order_id;

    private Timestamp time;

    private int user_id;

    private String description;

    private int status;

    private int good_id;

    private int good_num;

    private float price;

    private String img;

    public Order(){
    }

    public Order(int order_id, int cart_id, Timestamp time, int user_id, int shop_id, String description, int status, int totalprice, int good_id, int good_num, float price,String img) {
        this.order_id = order_id;
        this.time = time;
        this.user_id = user_id;
        this.description = description;
        this.status = status;
        this.good_id = good_id;
        this.good_num = good_num;
        this.price = price;
        this.img = img;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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


    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
