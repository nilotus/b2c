package cn.edu.jit.b2c.pojo;

public class RMessage {
    private Cart cart;
    private GoodCart goodCart;
    private GoodOrder goodOrder;
    private Goods goods;
    private Order order;
    private Shop shop;
    private User user;
    private UserShop userShop;
    private int a;
    private float b;
    private String c;
    public RMessage(){
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public GoodCart getGoodCart() {
        return goodCart;
    }

    public void setGoodCart(GoodCart goodCart) {
        this.goodCart = goodCart;
    }

    public GoodOrder getGoodOrder() {
        return goodOrder;
    }

    public void setGoodOrder(GoodOrder goodOrder) {
        this.goodOrder = goodOrder;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserShop getUserShop() {
        return userShop;
    }

    public void setUserShop(UserShop userShop) {
        this.userShop = userShop;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
