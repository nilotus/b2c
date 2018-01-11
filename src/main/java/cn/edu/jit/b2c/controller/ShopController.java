package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.service.ShopService;
import cn.edu.jit.b2c.serviceImpl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "shop", method = RequestMethod.POST)
    public String shop(@RequestParam String img) throws IOException {
        return shopService.shop(img);
    }
}
