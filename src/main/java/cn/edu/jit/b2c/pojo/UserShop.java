package cn.edu.jit.b2c.pojo;

import java.sql.Timestamp;

public class UserShop {
    private int user_id;

    private int shop_id;

    private Timestamp time;

    public UserShop(){
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
