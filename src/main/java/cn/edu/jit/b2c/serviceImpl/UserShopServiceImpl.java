package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.UserShopMapper;
import cn.edu.jit.b2c.pojo.*;
import cn.edu.jit.b2c.service.UserShopService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserShopServiceImpl implements UserShopService{
    @Autowired
    private UserShopMapper userShopMapper;

    /**
     * Created by ZhouLiangWei
     * 根据user_id查看用户收藏夹的所有商品信息
     * 输出name,price,img,describe,good_id
     */
    @Override
    public MSG usershopLook(int user_id) {
        List<UserShop> userShop = userShopMapper.usershopLook(user_id);
        List<JsonUsershop> jsonUsershopList = new ArrayList<>();
        for(int i=0;i<userShop.size();i++)
        {
            jsonUsershopList.add(Json2Usershop(userShop.get(i)));
        }
        return new MSG(1,"查看成功",jsonUsershopList);
    }
    public JsonUsershop Json2Usershop(UserShop userShop){
        JsonUsershop jsonUsershop = new JsonUsershop();
        Goods goods = userShopMapper.usershopGFind(userShop.getGood_id());
        jsonUsershop.setDescription(goods.getDescribe());
        jsonUsershop.setPrice(goods.getPrice());
        jsonUsershop.setImg(goods.getImg());
        jsonUsershop.setName(goods.getName());
        jsonUsershop.setGood_id(userShop.getGood_id());
        jsonUsershop.setUsid(userShop.getUsid());
        return jsonUsershop;
    }

    /**
     * Created by ZhouLiangWei
     * 根据user_id查看用户收藏夹的所有店铺信息
     * 输出shop_id,name,price,img,describe
     */
    @Override
    public MSG usershopLook1(int user_id) {
        List<UserShop> userShop = userShopMapper.usershopLook2(user_id);
        List<JsonUsershop2> jsonUsershopList1 = new ArrayList<>();
        for(int i=0;i<userShop.size();i++)
        {
            jsonUsershopList1.add(Json3Usershop(userShop.get(i)));
        }
        return new MSG(1,"查看成功",jsonUsershopList1);
    }
    public JsonUsershop2 Json3Usershop(UserShop userShop){
        JsonUsershop2 jsonUsershop2 = new JsonUsershop2();
        Shop shop = userShopMapper.usershopSFind(userShop.getShop_id());
        jsonUsershop2.setDescribe(shop.getDescribe());
        jsonUsershop2.setImg(shop.getImg());
        jsonUsershop2.setName(shop.getName());
        jsonUsershop2.setShop_id(userShop.getShop_id());
        jsonUsershop2.setUsid(userShop.getUsid());
        return jsonUsershop2;
    }



    /**
     * Created by ZhouLiangWei
     * 在收藏夹里添加商品信息
     * 输入 user_id,shop_id,good_id,status
     */
    @Override
    public MSG usershopAdd1(int user_id, int good_id) {
        userShopMapper.usershopInsert1(user_id,good_id);
        return new MSG(1,"添加成功");
    }
    /**
     * Created by ZhouLiangWei
     * 在收藏夹里添加店铺信息
     * 输入 user_id,shop_id,good_id,status
     */

    @Override
    public MSG usershopAdd2(int user_id, int shop_id) {
        userShopMapper.usershopInsert2(user_id,shop_id);
        return new MSG(1,"添加成功");
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里删除信息
     * 输入 user_id,shop_id,good_id,status
     */
    @Override
    public MSG usershopDelete(int usid) {
        userShopMapper.delete(usid);
        return new MSG(1,"删除成功");
    }


}
