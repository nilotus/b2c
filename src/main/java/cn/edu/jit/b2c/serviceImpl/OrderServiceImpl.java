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
     * 下订单,带付款
     * 输入 user_id, shop_id, time, status, num和price
     */
    @Override
    public MSG purchaseWait(int user_id, int shop_id, Timestamp time, int status, int num) {
        orderMapper.insertorder(time,shop_id,user_id,num);
        orderMapper.price(shop_id);
        orderMapper.waitpurchase(status);
        orderMapper.totalprice();
        return new MSG(1,"下订单成功");
    }

    /**
     * Created by ZhouLiangWei
     * 已付款
     * 输入 总价格toatl-pee，改变状态
     */
    @Override
    public MSG payWait(int status) {
        orderMapper.afterpurchase(status);
    }


}
