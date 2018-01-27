package cn.edu.jit.b2c.pojo;

public class UserShop {
    private Integer user_id;

    private int status;

    private Integer good_id;

    private Integer shop_id;

    private int usid;

    public UserShop() {
    }


    public UserShop(Integer user_id, int status, Integer good_id, Integer shop_id, int usid) {
        this.user_id = user_id;
        this.status = status;
        this.good_id = good_id;
        this.shop_id = shop_id;
        this.usid = usid;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }
}
