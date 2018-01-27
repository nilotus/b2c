package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.ShopMapper;
import cn.edu.jit.b2c.pojo.RMessage;
import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.service.ShopService;
import cn.edu.jit.b2c.util.MSG;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public MSG shopBrowse(int user_id){
        List<Shop> shopList =shopMapper.browse(user_id);
        return new MSG(0,"浏览商品",shopList, shopList.size());
    }


    /**
     * Created by SunFuRong
     * 全局搜索功能（店铺）
     * 输入关键字跳出模糊查询的店铺图片
     */

    @Override
    public MSG shopFindAll(String key) {
        List<Shop> shop =shopMapper.findAll(key);
        return new MSG(1,"搜索成功",shop);
    }

    /**
     * Created by SunFuRong
     * 查看店铺情况
     * 输出店铺交易金额，订单总数
     */
    @Override
    public MSG shopINFO(int shop_id){
        float ordermoney= shopMapper.money(shop_id);
        int ordernum=shopMapper.order(shop_id);
        RMessage rMessage = new RMessage();
        rMessage.setA(ordernum);
        rMessage.setB(ordermoney);
        return new MSG(1,"查看成功",rMessage);
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
     * 增加/编辑店铺
     * 输入输入shop_id,name,describe,img
     */
    @Override
    public MSG shopEdit(Shop shop){
        if(shop.getShop_id()==0){
            shopMapper.add(shop);
        }else{
           shopMapper.update(shop);
        }
        return new MSG(1,"操作成功");
    }

    /**
     * Created by SunFuRong
     * 查看会员信息
     * 输出name，img，email
     */
    @Override
    public MSG shopFan(int shop_id){
        List<User> user=shopMapper.fan(shop_id);
        System.out.println("shop_id:"+shop_id);
        return new MSG(0,"查看会员信息",user);
    }

    /**
     * Created by Mr.Chen
     * 查看店铺信息
     * 输出name，img，email
     */
    @Override
    public MSG findShopInfo(int shop_id) {
        Shop shop;
        if(shop_id==0){
            shop=new Shop(0);
        }else {
            shop=  shopMapper.selectShopInfo(shop_id).get(0);
        }
        return new MSG(1,"success",shop);
    }


}
