package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.GoodsMapper;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.service.GoodsService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * Created by SunFuRong
     * 浏览全部商品
     * 输出name，price，img
     */

    public MSG goodsBrowseAll(){
        Goods goods =goodsMapper.browseAll();
        return new MSG(1,"浏览成功",goods);
    }

    /**
     * Created by SunFuRong
     * 详细浏览特定商品
     * 输出name，price，img，店铺名
     */

    public MSG goodsBrowseOne(int good_id){
        Goods goods =goodsMapper.browseOne(good_id);
        return new MSG(1,"浏览成功",goods);
    }

    /**
     * Created by SunFuRong
     * 浏览店铺内商品
     * 输出name，price，img
     */

    public MSG goodsBrowseShop(int shop_id){
        Goods goods =goodsMapper.browseShop(shop_id);
        return new MSG(1,"浏览成功",goods);
    }


    /**
     * Created by SunFuRong
     * 全局搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */

    @Override
    public MSG goodsFindAll(String key){
        Goods goods =goodsMapper.findAll(key);
        return new MSG(1,"搜索成功",goods);
    }

    /**
     * Created by SunFuRong
     * 店铺搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */

    @Override
    public MSG goodsFindShop(int shop_id, String key){
        Goods goods =goodsMapper.findShop(shop_id,key);
        return new MSG(1,"搜索成功",goods);
    }
}
