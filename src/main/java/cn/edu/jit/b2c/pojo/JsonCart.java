package cn.edu.jit.b2c.pojo;

public class JsonCart {
    private String good_name;
    private int cart_id;
    private String img;
    private float price;
    private int good_id;

    public String getGood_name() {
        return good_name;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
