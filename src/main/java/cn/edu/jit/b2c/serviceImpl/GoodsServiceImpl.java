package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.GoodsMapper;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public String goodsBrowse(int good_id){
        Goods goods = goodsMapper.browse(good_id);
        return goods.getName()+" "+goods.getPrice()+" "+goods.getImg();
    }

    /**
     * Created by SunFuRong
     * 全局搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */

    @Override
    public Goods goodsFindAll(String key){
        return goodsMapper.findAll(key);
    }

    /**
     * Created by SunFuRong
     * 店铺搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */

    @Override
    public Goods goodsFindShop(int shop_id, String key){
        return goodsMapper.findShop(shop_id,key);
    }
}
