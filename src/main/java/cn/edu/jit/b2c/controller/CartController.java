package cn.edu.jit.b2c.controller;


import cn.edu.jit.b2c.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "cart", method = RequestMethod.POST)
    public String cart(@RequestParam Integer good_id,@RequestParam Integer status) throws IOException {
        return cartService.cart(good_id,status);
    }


}
