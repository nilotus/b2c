package cn.edu.jit.b2c.controller;

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
    //@RequestMapping(value = "img", method = RequestMethod.POST)
    public MSG goodsBrowseAll() throws IOException {
        return goodsService.goodsBrowseAll();
    }

    /**
     * Created by SunFuRong
     * 详细浏览特定商品
     * 输出name，price，img，describe店铺名
     */
    @GetMapping("/goodsinfo/{good_id}")
    public MSG goodsBrowseOne(@PathVariable("good_id") int good_id) throws IOException{
        return goodsService.goodsBrowseOne(good_id);
    }

    /**
     * Created by SunFuRong
     * 浏览店铺内商品
     * 输出name，price，img
     */
    @GetMapping("/goodsinfo/{shop_id}")
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


}
