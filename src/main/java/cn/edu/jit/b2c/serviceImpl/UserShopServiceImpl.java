package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.UserShopMapper;
import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.pojo.UserShop;
import cn.edu.jit.b2c.service.UserShopService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserShopServiceImpl implements UserShopService{
    @Autowired
    private UserShopMapper userShopMapper;

    /**
     * Created by ZhouLiangWei
     * 查看用户收藏夹的所有属性
     * 输出status，good_id,shop_id
     */
    @Override
    public MSG usershopLook(int user_id) {
        UserShop uslook = userShopMapper.usershopLook(user_id);
        return new MSG(1,"查看成功",uslook);
    }

    /**
     * Created by ZhouLiangWei
     * 查看用户收藏夹的商品信息
     * 输出status，good_id,shop_id
     */
    @Override
    public MSG usershopGFind(int good_id, int status) {
        UserShop usgfind = userShopMapper.usershopFind(good_id,status);
        return new MSG(1,"查看成功",usgfind);
    }

    /**
     * Created by ZhouLiangWei
     * 查看用户收藏夹的店铺信息
     * 输出店铺的name，img
     */
    @Override
    public MSG usershopSFind(int shop_id, int status) {
        Shop ussfind  = userShopMapper.usershopSFind(shop_id,status);
        return new MSG(1,"查看成功",ussfind);
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里添加商品信息
     * 输入 user_id,shop_id,good_id,status
     */
    @Override
    public MSG usershopAdd(int user_id, int good_id, int shop_id, int status) {
        userShopMapper.usershopInsert(user_id,shop_id,good_id,status);
        return new MSG(1,"添加成功");
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里删除商品信息
     * 输入 user_id,shop_id,good_id,status
     */
    @Override
    public MSG usershopDelete(int shop_id) {
        userShopMapper.delete(shop_id);
        return new MSG(1,"删除成功");
    }
}
