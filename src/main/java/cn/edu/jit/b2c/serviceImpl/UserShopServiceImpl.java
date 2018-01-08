package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.UserShopMapper;
import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.service.UserShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserShopServiceImpl implements UserShopService{
    @Autowired
    private UserShopMapper userShopMapper;

    @Override
    public String usershop(Integer shop_id, Timestamp time) {
        Shop shop = userShopMapper.findUsershop(shop_id);
        userShopMapper.intertime(time);
        userShopMapper.intershop_id(shop_id);
        return shop.getDescribe()+" "+shop.getName()+" "+shop.getType_id()
                +" "+shop.getShop_id()+" "+shop.getImg();
    }
}
