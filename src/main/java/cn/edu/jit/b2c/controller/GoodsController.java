package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "img", method = RequestMethod.POST)
    public String goods(@RequestParam String img) throws IOException {
        return goodsService.goods(img);
    }

    /**
     * Created by SunFuRong
     * 全局搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */
    @PostMapping("/search")
    public Goods goodsFindAll(@RequestParam String key) throws IOException{
        return goodsService.goodsFindAll(key);
    }

    /**
     * Created by SunFuRong
     * 店铺搜索功能（商品）
     * 输入关键字跳出模糊查询的商品图片
     */

    @PostMapping("/searchShop/{shop_id}")
    public Goods goodsFindShop(@PathVariable("shop_id") int shop_id,@RequestParam String key) throws IOException{
        return goodsService.goodsFindShop(shop_id,key);
    }


}
