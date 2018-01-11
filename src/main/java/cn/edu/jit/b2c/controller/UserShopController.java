package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.service.UserShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;

@RestController
@RequestMapping("usershop")
public class UserShopController {
    @Autowired
    private UserShopService userShopService;

    @RequestMapping(value="usershop", method = RequestMethod.POST)
    public String usershop(Integer shop_id , Timestamp time) throws IOException {
        return  userShopService.usershop(shop_id,time);
    }
}
