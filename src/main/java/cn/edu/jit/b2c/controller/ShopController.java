package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("user")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "img", method = RequestMethod.POST)
    public String shop(@RequestParam String img) throws IOException {
        return shopService.shop(img);
    }

    /**
     * Created by SunFuRong
     * 全局搜索功能（店铺）
     * 输入关键字跳出模糊查询的店铺图片
     */

    @PostMapping("/search")
    public Shop shopFindAll(@RequestParam String key) throws IOException{
        return shopService.shopFindAll(key);
    }
}
