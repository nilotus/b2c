package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.service.GoodsService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * Created by SunFuRong
     * 浏览全部商品
     * 输出name，price，img
     */
    @GetMapping("/goodsinfo")
    public MSG goodsBrowseAll() throws IOException {
        return goodsService.goodsBrowseAll();
    }

    /**
     * Created by SunFuRong
     * 详细浏览特定商品
     * 输出name，price，img，describe店铺名
     */
    @GetMapping("/info/{good_id}")
    public MSG goodsBrowseOne(@PathVariable("good_id") int good_id) throws IOException{
        return goodsService.goodsBrowseOne(good_id);
    }

    /**
     * Created by SunFuRong
     * 浏览店铺内商品
     * 输出name，price，img
     */
    @GetMapping("/shopinfo/{shop_id}")
    public MSG goodsBrowseShop(@PathVariable("shop_id") int shop_id) throws IOException{
        return goodsService.goodsBrowseShop(shop_id);
    }

    /**
     * Created by SunFuRong
     * 全局搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */
    @GetMapping("/search")
    public MSG goodsFindAll(@RequestParam("key") String key) throws IOException{
        return goodsService.goodsFindAll(key);
    }

    /**
     * Created by SunFuRong
     * 店铺搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */

    @GetMapping("/searchShop/{shop_id}")
    public MSG goodsFindShop(@PathVariable("shop_id") int shop_id,@RequestParam("key") String key) throws IOException{
        return goodsService.goodsFindShop(shop_id,key);
    }

    /**
     * Created by SunFuRong
     * 增加商品
     * 输入name,price,status,shop_id,type_id,img,totalnum,describe
     */
    @PostMapping("/add/{shop_id}")
    public MSG goodsAdd(@PathVariable("shop_id") int shop_id,Goods goods){
        goods.setShop_id(shop_id);
        return goodsService.goodsAdd(goods);
    }

    /**
     * Created by SunFuRong
     * 删除商品
     * 输入good_id
     */
    @DeleteMapping("/delete/{good_id}")
    public MSG goodsDelete(@PathVariable("good_id") int good_id){
        return goodsService.goodsDelete(good_id);
    }

    /**
     * Created by SunFuRong
     * 更新商品
     * 输入name,price,status,img,describe
     */
    @PutMapping("/update/{good_id}")
    public MSG goodsUpdate(@PathVariable("good_id") int good_id,Goods goods){
        goods.setGood_id(good_id);
        return goodsService.goodsUpdate(goods);
    }

    /**
     * Created by SunFuRong
     * 查询商品交易情况
     */
    @GetMapping("/fan/{good_id}")
    public MSG goodsSaleNum(@PathVariable("good_id") int good_id){
        return goodsService.goodsSaleNum(good_id);
    }

}
