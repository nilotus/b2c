package cn.edu.jit.b2c.pojo;

public class Shop {
    private int shop_id;

    private int type_id;

    private int user_id;

    private String name;

    private String describe;

    private String img;

    public Shop(){
    }

    public Shop(int shop_id, int type_id, int user_id, String name, String describe, String img) {
        this.shop_id = shop_id;
        this.type_id = type_id;
        this.user_id = user_id;
        this.name = name;
        this.describe = describe;
        this.img = img;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
