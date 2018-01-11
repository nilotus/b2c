package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.ShopMapper;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.service.ShopService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public String shop(String img) {
        Shop shop = shopMapper.findImg(img);

        int shop_id = shop.getShop_id();

        Goods goods = shopMapper.findShop_id(shop_id);

        return goods.getName()+" "+goods.getPrice()+" "+goods.getRestnum()
                +" "+goods.getTotalnum()+" "+goods.getStatus()+" "+goods.getImg()
                +" "+goods.getShop_id()+" "+shop.getName()+" "+shop.getDescribe();
    }

    /**
     * Created by SunFuRong
     * 全局搜索功能（店铺）
     * 输入关键字跳出模糊查询的店铺图片
     */

    @Override
    public MSG shopFindAll(String key) {
        Shop shop =shopMapper.findAll(key);
        return new MSG(1,"搜索成功",shop);
    }

}
