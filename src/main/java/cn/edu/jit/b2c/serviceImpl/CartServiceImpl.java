package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.CartMapper;
import cn.edu.jit.b2c.pojo.Cart;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.service.CartService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartMapper cartMapper;
    /**
     * Created by ZhouLiangWei
     * 查看商量功能1
     * 输出cart_id,good_id
     */
    @Override
    public MSG goodsCheckOne(int user_id) {
        Goods goods1 = cartMapper.checkone(user_id);
        return new MSG(1,"查看成功",goods1);
    }

    /**
     * Created by ZhouLiangWei
     * 查看商量功能2
     * 输出商品name,price,img,shop_id所对应的店铺名name（浏览商品功能）
     */
    @Override
    public MSG goodsCheckTwo(int good_id) {
        List<String> goods2 = cartMapper.checktwo(good_id);
        return new MSG(1,"浏览成功",goods2);
    }

    /**
     * Created by ZhouLiangWei
     * 查看商量功能3
     * 输出goodnum ，price（总）
     */
    @Override
    public MSG goodsCheckThree(int cart_id) {
        List<String> goods3 = cartMapper.checkthree(cart_id);
        return new MSG(1,"查看成功",goods3);
    }

    /**
     * Created by ZhouLiangWei
     * 添加购物车
     * 将该商品good_id，用户user_id添加到Cart表中，
     * 选择数量，将商品good_id，goodnum，cart_id添加到GoodCart表中
     * Cart表中加入 price总金额
     */
    @Override
    public MSG goodsAdd(int good_id, int user_id, int goodnum) {
        cartMapper.insertGoodCart(goodnum,good_id);
        cartMapper.insertCart(user_id,good_id);
        cartMapper.insertPrice(good_id);
        return new MSG(1,"添加成功");
    }

     /**
     * Created by ZhouLiangWei
     * 删除商品
     * 将该商品good_id的删除
     */
    @Override
    public MSG goodsDelete(int good_id) {
        cartMapper.delete(good_id);
        return new MSG(1,"删除成功");
    }
}
