package cn.edu.jit.b2c.pojo;

public class Goods {
    private int good_id;

    private int status;

    private int shop_id;

    private int type_id;

    private String name;

    private String img;

    private float price;

    private int restnum;

    private int totalnum;

    public Goods(){
    }

    public Goods(int good_id, int status, int shop_id, int type_id, String name, String img, float price, int restnum, int totalnum) {
        this.good_id = good_id;
        this.status = status;
        this.shop_id = shop_id;
        this.type_id = type_id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.restnum = restnum;
        this.totalnum = totalnum;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRestnum() {
        return restnum;
    }

    public void setRestnum(int restnum) {
        this.restnum = restnum;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }
}
