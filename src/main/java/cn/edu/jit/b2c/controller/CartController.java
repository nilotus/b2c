package cn.edu.jit.b2c.controller;


import cn.edu.jit.b2c.service.CartService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * Created by ZhouLiangWei
     * 查看商量功能1
     * 输出cart_id,good_id
     */
    @PostMapping("/userlook/{user_id}")
    public MSG goodCheckOne(@PathVariable("user_id") int user_id) throws IOException {
        return cartService.goodsCheckOne(user_id);
    }

    /**
     * Created by ZhouLiangWei
     * 查看商量功能2
     * 输出商品name,price,img,shop_id所对应的店铺名name（浏览商品功能）
     */
    @PostMapping("/brose")
    public MSG goodCheckTwo(int good_id) throws IOException {
        return cartService.goodsCheckTwo(good_id);
    }

    /**
     * Created by ZhouLiangWei
     * 查看商量功能3
     * 输出goodnum ，price（总）
     */
    @PostMapping("/numprice")
    public MSG goodCheckThree(int cart_id) throws IOException {
        return cartService.goodsCheckThree(cart_id);
    }

    /**
     * Created by ZhouLiangWei
     * 查看商量功能3
     * 输出goodnum ，price（总）
     */
    @PostMapping("/addgoods")
    public MSG goodsAdd(int good_id, int user_id, int goodnum) throws IOException{
        return cartService.goodsAdd(good_id,user_id,goodnum);
    }

    /**
     * Created by ZhouLiangWei
     * 删除商品
     * 将该商品good_id的删除
     */
    @PostMapping("/delgoods")
    public MSG goodsDelete(int good_id) throws IOException{
        return cartService.goodsDelete(good_id);
    }
}
