package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.CartMapper;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartMapper cartMapper;

    @Override
    public String cart(Integer good_id ,Integer status){

        Goods goods = cartMapper.findGood_id(good_id);

        Float price = goods.getPrice();

        cartMapper.insertCart(price,good_id);
        cartMapper.insertCart_s(status);

        return goods.getName()+" "+goods.getPrice()+" "+goods.getRestnum()
                +" "+goods.getTotalnum()+" "+goods.getStatus()+" "+goods.getImg()
                +goods.getShop_id()+good_id;
    }
}
