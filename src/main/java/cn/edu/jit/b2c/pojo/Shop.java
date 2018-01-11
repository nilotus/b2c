package cn.edu.jit.b2c.pojo;

public class Shop {
    private int shop_id;

    private int type_id;

    private String name;

    private String describe;

    private int user_id;

    private String img;

    public Shop(int shop_id, int type_id, String name, String describe, int user_id, String img) {
        this.shop_id = shop_id;
        this.type_id = type_id;
        this.name = name;
        this.describe = describe;
        this.user_id = user_id;
        this.img = img;
    }
    public Shop(){
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
