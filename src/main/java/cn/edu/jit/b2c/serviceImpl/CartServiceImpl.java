package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.CartMapper;
import cn.edu.jit.b2c.pojo.Cart;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.JsonCart;
import cn.edu.jit.b2c.pojo.RMessage;
import cn.edu.jit.b2c.service.CartService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartMapper cartMapper;

    /**
     * Created by ZhouLiangWei
     * 查看商量功能1
     * 根据user_id输出商品的name,price,img
     */
    @Override
    public MSG goodsCheckOne(int user_id) {
        List<Cart> cart = cartMapper.checkone(user_id);
        List<JsonCart> jsonCartList = new ArrayList<>();
        for(int i= 0 ;i< cart.size();i++)
        {
            jsonCartList.add(Cart2JsonOrder(cart.get(i)));
        }
        return new MSG(1,"查看成功",jsonCartList);
    }

    public JsonCart Cart2JsonOrder(Cart cart){
        JsonCart jsonCart = new JsonCart();
        Goods goods = cartMapper.checktwo1(cart.getGood_id());
        jsonCart.setGood_name(goods.getName());
        jsonCart.setImg(goods.getImg());
        jsonCart.setPrice(goods.getPrice());
        jsonCart.setGood_id(goods.getGood_id());
        jsonCart.setCart_id(cart.getCart_id());
        return  jsonCart;
    }

    /**
     * Created by ZhouLiangWei
     * 查看商量功能2
     * 根据good_id输出商品name,price,img,shop_id所对应的店铺名name（浏览商品功能）
     */
    @Override
    public MSG goodsCheckTwo(int good_id) {
        RMessage  rMessage = new RMessage();
        rMessage.setGoods(cartMapper.checktwo1(good_id));
        rMessage.setC(cartMapper.checktwo2(rMessage.getGoods().getShop_id()));
        return new MSG(1,"浏览成功",rMessage);
    }


    /**
     * Created by ZhouLiangWei
     * 查看商量功能3
     * 根据cart_id输出good_num ，price（总）
     */
    @Override
    public MSG goodsCheckThree(int cart_id) {
        Cart goods3 = cartMapper.checkthree(cart_id);
        return new MSG(1,"查看成功",goods3);
    }



    /**TODO
     * Created by ZhouLiangWei
     * 添加购物车
     * 根据good_id,user_id,good_num将商品的属性都加入cart表中
     */
    @Override
    public MSG goodsAdd(int good_id, int user_id, int good_num) {
        RMessage rMessage = new RMessage();
        rMessage.setGoods(cartMapper.findSidP(good_id));

        float price = rMessage.getGoods().getPrice() * good_num;
        int shop_id = rMessage.getGoods().getShop_id();
        cartMapper.insertCart(user_id, good_id, good_num, price, shop_id);
        return new MSG(1,"添加成功");
    }

     /**
     * Created by ZhouLiangWei
     * 删除商品
     * 将该商品good_id的删除
     */
    @Override
    public MSG goodsDelete(int cart_id) {
        cartMapper.delete(cart_id);
        return new MSG(1,"删除成功");
    }

}
