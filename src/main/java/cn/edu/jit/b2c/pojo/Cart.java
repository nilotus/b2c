package cn.edu.jit.b2c.pojo;

public class Cart {
    private int cart_id;

    private int user_id;

    private float price;

    private int good_id;

    public Cart(int cart_id, int user_id, float price, int good_id) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.price = price;
        this.good_id = good_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
}
