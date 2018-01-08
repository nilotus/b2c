package cn.edu.jit.b2c.pojo;

public class UserShop {
    private int user_id;

    private int status;

    private float price;

    private int good_id;

    private int shop_id;

    public UserShop(int user_id, int status, float price, int good_id, int shop_id) {
        this.user_id = user_id;
        this.status = status;
        this.price = price;
        this.good_id = good_id;
        this.shop_id = shop_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }
}
