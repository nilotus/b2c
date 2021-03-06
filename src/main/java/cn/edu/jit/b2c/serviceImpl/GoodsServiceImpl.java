package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.GoodsMapper;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.RMessage;
import cn.edu.jit.b2c.service.GoodsService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Goods> goods =goodsMapper.browseAll();
        return new MSG(1,"浏览成功",goods);
    }

    /**
     * Created by SunFuRong
     * 详细浏览特定商品
     * 输出name，price，img，店铺名
     */

    public MSG goodsBrowseOne(int good_id){
        Goods goods=goodsMapper.browseOne1(good_id);
       // String name=goodsMapper.browseOne2(good_id);
        //RMessage rMessage=new RMessage();
       // rMessage.setC(name);
       // rMessage.setGoods(goods);
        return new MSG(1,"浏览成功",goods);
    }

    /**
     * Created by SunFuRong
     * 浏览店铺内商品
     * 输出name，price，img,restnum
     */

    public MSG goodsBrowseShop(int shop_id){
        List<Goods> goods =goodsMapper.browseShop(shop_id);
        return new MSG(0,"浏览成功",goods);
    }


    /**
     * Created by SunFuRong
     * 全局搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */

    @Override
    public MSG goodsFindAll(String key){
        List<Goods> goods = goodsMapper.findAll(key);
        if (goods.size() == 0) {
            return new MSG(-1,"没有商品");
        }
        System.out.println(goods);
        return new MSG(1,"搜索成功",goods);
    }

    /**
     * Created by SunFuRong
     * 店铺搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */

    @Override
    public MSG goodsFindShop(int shop_id, String key){
        List<Goods> goods =goodsMapper.findShop(shop_id,key);
        return new MSG(1,"搜索成功",goods);
    }

    /**
     * Created by SunFuRong
     * 增加商品
     * 输入name,price,status,shop_id,type_id,img,totalnum,describe
     */
    @Override
    public MSG goodsAdd(Goods goods){
        System.out.println(goods.toString());
        boolean result=goodsMapper.add(goods);
        if(result)
            return new MSG(1,"添加成功");
        else
            return new MSG(1,"添加失败");
    }

    /**
     * Created by SunFuRong
     * 删除商品
     * 输入good_id
     */
    @Override
    public MSG goodsDelete(int good_id){
        boolean result=goodsMapper.delete(good_id);
        if(result)
            return new MSG(1,"删除成功");
        else
            return new MSG(1,"删除失败");
    }

    /**
     * Created by SunFuRong
     * 更新商品
     * 输入name,price,status,img,describe
     */
    @Override
    public MSG goodsUpdate(Goods goods){
        boolean result=goodsMapper.update(goods);
        if(result)
            return new MSG(1,"更新成功");
        else
            return new MSG(1,"更新失败");

    }

    /**
     * Created by SunFuRong
     * 查询商品交易情况
     */
    @Override
    public MSG goodsSaleNum(int good_id){
        Goods num =goodsMapper.salenum(good_id);
        int salenum=num.getTotalnum()-num.getRestnum();
        return new MSG(1,"查询成功",salenum);
    }

     /**
     * Created by Mr.Chen
     * 查询单一商品信息
     */
    @Override
    public MSG findGoodInfo(int good_id) {
        Goods goods;
        if(good_id == 0) {
            goods = new Goods(0);
        }else {
            goods = goodsMapper.selectGoodInfo(good_id).get(0);
        }
        return new MSG(1,"success",goods);
    }

    /**
     * Created by Mr.Chen
     * 查询单一商品的店铺名称
     */
    @Override
    public MSG selectGoodShop(int good_id) {
        String shopName = goodsMapper.selectGoodsShop(good_id);
        return new MSG(1,"success",shopName);
    }

    /**
     * Created by SunFuRong
     * 二级联动
     * 输出name，price，img
     */

    public MSG goodsBrowseType(int type_id){
        List<Goods> goods =goodsMapper.browseType(type_id);
        return new MSG(1,"浏览成功",goods);
    }


}
