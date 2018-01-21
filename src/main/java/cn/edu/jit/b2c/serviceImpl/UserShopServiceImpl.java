package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.UserShopMapper;
import cn.edu.jit.b2c.pojo.RMessage;
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

    /**TODO
     * Created by ZhouLiangWei
     * 查看用户收藏夹的商品信息
     * 输出status，good_id,shop_id
     */
    @Override
    public MSG usershopGFind(int good_id, int status) {
        RMessage rMessage = new RMessage();
        rMessage.setGoods(userShopMapper.usershopGFind(good_id));
        rMessage.setC(userShopMapper.usershopGFind1(rMessage.getGoods().getShop_id()));
        return new MSG(1,"查看成功",rMessage);
    }

    /**
     * Created by ZhouLiangWei
     * 查看用户收藏夹的店铺信息
     * 输出店铺的name，img
     */
    @Override
    public MSG usershopSFind(int shop_id, int status) {
        Shop ussfind  = userShopMapper.usershopSFind(shop_id);
        return new MSG(1,"查看成功",ussfind);
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
     * 在收藏夹里删除店铺信息
     * 输入 user_id,shop_id,good_id,status
     */
    @Override
    public MSG usershopDelete1(int shop_id) {
        userShopMapper.delete2(shop_id);
        return new MSG(1,"删除成功");
    }

    /**
     * Created by ZhouLiangWei
     * 在收藏夹里删除商品信息
     * 输入 user_id,shop_id,good_id,status
     */
    @Override
    public MSG usershopDelete2(int good_id) {
        userShopMapper.delete1(good_id);
        return new MSG(1,"删除成功");
    }


}
