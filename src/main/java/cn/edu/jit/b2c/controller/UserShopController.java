package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.service.UserShopService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;

@RestController
@RequestMapping("usershop")
public class UserShopController {
    @Autowired
    private UserShopService userShopService;

    /**
     * Created by ZhouLiangWei
     * 根据用user_id查看用户收藏夹的所有商品信息
     * 输出所有商品信息的name，img，price，describe
     */
    @PostMapping("/uslook/{user_id}")
    public MSG usershopLook(@PathVariable("user_id") int user_id) throws IOException {
        return userShopService.usershopLook(user_id);
    }


    /**
     * Created by ZhouLiangWei
     * 根据用user_id查看用户收藏夹的所有店铺信息
     * 输出所有店铺信息的name，img，describe
     */
    @PostMapping("/uhlook/{user_id}")
    public MSG usershopLook1(@PathVariable("user_id") int user_id) throws IOException {
        return userShopService.usershopLook1(user_id);
    }



    /**
     * Created by ZhouLiangWei
     * 在收藏夹里添加商品信息
     * 输入 user_id,shop_id,good_id,status
     */
    @GetMapping("/user_add1")
    public MSG usershopAdd1(@RequestParam("user_id") int user_id,@RequestParam("good_id") int good_id) throws IOException {
        return userShopService.usershopAdd1(user_id, good_id);
    }




    /**
     * Created by ZhouLiangWei
     * 在收藏夹里添加店铺信息
     * 输入 user_id,shop_id,good_id,status
     */
    @GetMapping("/user_add2")
    public MSG usershopAdd2(@RequestParam("user_id") int user_id,@RequestParam("shop_id") int shop_id) throws IOException {
        return userShopService.usershopAdd2(user_id, shop_id);
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里删除店铺信息
     */
    @DeleteMapping("/usdel2/{usid}")
    public MSG usershopDelete1(@PathVariable("usid") int usid) {
        return userShopService.usershopDelete(usid);
    }

}
