package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.OrderMapper;
import cn.edu.jit.b2c.service.OrderService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    /**
     * Created by ZhouLiangWei
     * 直接下订单
     * 输入 user_id, shop_id, time, status, num和price
     */
    @Override
    public MSG purchaseDirent(int user_id, int good_id, Timestamp time, int status, int good_num, float price) {
        orderMapper.insertorder(time,good_id,user_id,good_num);
        orderMapper.insertprice(good_id);
        orderMapper.insertorderid(good_id);
        orderMapper.waitpurchase(status);
        orderMapper.totalprice();
        return new MSG(1,"下订单成功");
    }
    }

    /**
     * Created by ZhouLiangWei
     * 已付款
     * 输入 总价格toatl-pee，改变状态
     */


