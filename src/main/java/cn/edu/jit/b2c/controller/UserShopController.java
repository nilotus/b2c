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
     * 查看用户收藏夹的所有属性
     * 输出status，good_id,shop_id
     */
    @PostMapping("/uslook/{user_id}")
    public MSG usershopLook(@PathVariable("user_id") int user_id) throws IOException {
        return userShopService.usershopLook(user_id);
    }

    /**
     * Created by ZhouLiangWei
     * 查看用户收藏夹的商品信息
     * 输出status，good_id,shop_id
     */
    @PostMapping("/usglook")
    public MSG usershopGLook(int good_id, int status) throws IOException {
        return userShopService.usershopGFind(good_id, status);
    }

    /**
     * Created by ZhouLiangWei
     * 查看用户收藏夹的店铺信息
     * 输出店铺的name，img
     */
    @PostMapping("/usslook")
    public MSG usershopSLook(int shop_id, int status) throws IOException {
        return userShopService.usershopSFind(shop_id, status);
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里添加商品信息
     * 输入 user_id,shop_id,good_id,status
     */
    @PostMapping("/usadd1")
    public MSG usershopAdd1(int user_id,int good_id) throws IOException {
        return userShopService.usershopAdd1(user_id, good_id);
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里添加店铺信息
     * 输入 user_id,shop_id,good_id,status
     */
    @PostMapping("/usadd2")
    public MSG usershopAdd2(int user_id,int shop_id) throws IOException {
        return userShopService.usershopAdd2(user_id, shop_id);
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里删除店铺信息
     * 输入 user_id,shop_id,good_id,status
     */
    @PostMapping("/usdel1")
    public MSG usershopDelete1(int shop_id) {
        return userShopService.usershopDelete1(shop_id);
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里删除商品信息
     * 输入 user_id,shop_id,good_id,status
     */
    @PostMapping("/usdel2")
    public MSG usershopDelete2(int good_id) {
        return userShopService.usershopDelete2(good_id);
    }
}
