package cn.edu.jit.b2c.pojo;

import java.sql.Timestamp;

public class Order {
    private int order_id;

    private int cart_id;

    private Timestamp time;

    private float price;

    private int user_id;

    private int shop_id;

    private int totalprice;

    private String description;

    private int status;

    public Order(){
    }

    public Order(int order_id, int cart_id, Timestamp time, float price, int user_id, int shop_id, int totalprice, String description, int status) {
        this.order_id = order_id;
        this.cart_id = cart_id;
        this.time = time;
        this.price = price;
        this.user_id = user_id;
        this.shop_id = shop_id;
        this.totalprice = totalprice;
        this.description = description;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
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

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
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
