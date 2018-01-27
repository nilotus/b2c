package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.service.ShopService;
import cn.edu.jit.b2c.util.MSG;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    /**
     * Created by SunFuRong
     * 浏览店铺
     * 输出店铺name，img
     */

    @GetMapping("/browse")
    public MSG shopBrowse(HttpServletRequest request) throws  IOException{
        return shopService.shopBrowse(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
    }

    /**
     * Created by SunFuRong
     * 全局搜索功能（店铺）
     * 输入关键字跳出模糊查询的店铺图片
     */

    @GetMapping("/search")
    public MSG shopFindAll(@RequestParam("key") String key) throws IOException{
        return shopService.shopFindAll(key);
    }

    /**
     * Created by SunFuRong
     * 查看店铺情况
     * 输出店铺交易金额，订单总数
     */

    @GetMapping("/info/{shop_id}")
    public MSG shopINFO(@PathVariable("shop_id") int shop_id) throws IOException{
        return shopService.shopINFO(shop_id);
    }

    /**
     * Created by SunFuRong
     * 删除店铺
     */
    @DeleteMapping("/deleteShop/{shop_id}")
    public MSG shopDelete(@PathVariable("shop_id") int shop_id){
        return shopService.shopDelete(shop_id);
    }

    /**
     * Created by SunFuRong
     * 更新店铺
     * 输入shop_id,name,describe,img
     */
    @PostMapping("/shopEdit")
    public MSG shopEdit(HttpServletRequest request,@RequestParam("shop_id") int shop_id,@RequestParam("name") String name,@RequestParam("describe")String descirbe,@RequestParam("img")String img){
        Shop shop =new Shop();
        shop.setName(name);
        Object user=request.getSession().getAttribute("user_id");

        if(user==null){
            return  new MSG(-1,"error");
        }
        shop.setUser_id(Integer.parseInt(user.toString()));
        shop.setDescribe(descirbe);
        shop.setImg(img);
        shop.setShop_id(shop_id);
        return shopService.shopEdit(shop);
    }

    /**
     * Created by SunFuRong
     * 根据shop_id查看会员信息
     * 输出name，img，email
     */
    @GetMapping("/fan/{shop_id}")
    public MSG shopFan(@PathVariable("shop_id") int shop_id){
        return shopService.shopFan(shop_id);
    }


    /**
     * Created by Mr.Chen
     * 根据shop_id取店铺数据
     * 输入shop_id
     */
    @RequestMapping("/getshopInfo/{shop_id}")
    public MSG getShopInfo(@PathVariable("shop_id") int shop_id) {
        return shopService.findShopInfo(shop_id);
    }

}
