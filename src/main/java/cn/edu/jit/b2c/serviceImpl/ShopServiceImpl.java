package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.ShopMapper;
import cn.edu.jit.b2c.pojo.RMessage;
import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.service.ShopService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    /**
     * Created by SunFuRong
     * 浏览店铺
     * 输出店铺name，img
     */

    @Override
    public MSG shopBrowse(){
        Shop shop =shopMapper.browse();
        return new MSG(1,"浏览商品",shop);
    }


    /**
     * Created by SunFuRong
     * 全局搜索功能（店铺）
     * 输入关键字跳出模糊查询的店铺图片
     */

    @Override
    public MSG shopFindAll(String key) {
        Shop shop =shopMapper.findAll(key);
        return new MSG(1,"搜索成功",shop);
    }

    /**
     * Created by SunFuRong
     * 查看店铺情况
     * 输出店铺交易金额，订单总数
     */
    @Override
    public MSG shopINFO(int shop_id){
        float money= shopMapper.money(shop_id);
        int order=shopMapper.order(shop_id);
        RMessage rMessage = new RMessage();
        rMessage.setA(order);
        rMessage.setB(order);
        return new MSG(1,"查看成功",rMessage);
    }

    /**
     * Created by SunFuRong
     * 添加店铺
     * 输入name,describe,user_id,img
     */
    @Override
    public MSG shopAdd(Shop shop){
        boolean result =shopMapper.add(shop);
        if (result)
            return new MSG(1,"添加店铺成功");
        else
            return new MSG(-1,"添加失败");
    }

    /**
     * Created by SunFuRong
     * 删除店铺
     */
    @Override
    public MSG shopDelete(int shop_id){
        boolean result =shopMapper.delete(shop_id);
        if (result)
            return new MSG(1,"删除店铺成功");
        else
            return new MSG(-1,"删除失败");
    }

    /**
     * Created by SunFuRong
     * 更新店铺
     * 输入输入shop_id,name,describe,img
     */
    @Override
    public MSG shopUpdate(Shop shop){
        boolean result =shopMapper.update(shop);
        if (result)
            return new MSG(1,"更新店铺成功");
        else
            return new MSG(-1,"更新失败");
    }

    /**
     * Created by SunFuRong
     * 查看会员信息
     * 输出name，img，email
     */
    @Override
    public MSG shopFan(int shop_id){
        User user=shopMapper.fan(shop_id);
        return new MSG(1,"查看会员信息",user);
    }


}
