package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("search")

public class SearchController {
    @Autowired
    private  SearchController isearchController;

    /**
     * Created by SunFuRong
     * 全局搜索功能（商品）
     */
    @GetMapping("/goods")
    public Goods goodsFindAll() throws IOException{
        return isearchController.goodsFindAll();
    }


}
