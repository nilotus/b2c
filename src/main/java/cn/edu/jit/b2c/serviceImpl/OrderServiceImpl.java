package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.OrderMapper;
import cn.edu.jit.b2c.mapper.UserMapper;
import cn.edu.jit.b2c.pojo.*;
import cn.edu.jit.b2c.service.OrderService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * Created by ZhouLiangWei
     * 直接下订单
     * 输入 user_id, good_id, time, status, good_num, price ，shop_id和 totalprice
     */
    @Override
    public MSG purchaseDirent(int user_id, int good_id, Timestamp time,int status,int good_num) {

        RMessage rMessage = new RMessage();
        rMessage.setGoods(orderMapper.findPSid(good_id));
        float price = rMessage.getGoods().getPrice();
        int shop_id = rMessage.getGoods().getShop_id();

        Goods g_img = orderMapper.findimg(good_id);
        String img = g_img.getImg();
        orderMapper.insertimg(img);

        orderMapper.insertorder1(user_id,time,good_id,user_id,good_num,price,shop_id);
        orderMapper.totalprice();
        return new MSG(1,"下订单成功");
    }

    /**
     * Created by ZhouLiangWei
     * 购物车下订单
     * 输入 总价格toatl-pee，改变状态
     */
    @Override
    public MSG purchaseCart(int user_id, int good_id, Timestamp time, int status, int good_num, float price, int shop_id, int cart_id) {
        orderMapper.insertorder2(time,good_id,user_id,good_num,shop_id,cart_id,price);
        orderMapper.totalprice();
        return new MSG(1,"下订单成功");
    }




    /**
     * Created by ZhouLiangWei
     * 付款（未完成）
     */




    /**
     * Created by ZhouLiangWei
     * 付款后
     * 改变状态
     */
    @Override
    public MSG afterpay(int status ,int order_id,int cart_id) {
        orderMapper.afterpay(status,order_id);
        orderMapper.deletecart(cart_id);
        return new MSG(1,"付款成功");
    }

    /**
     * Created by ZhouLiangWei
     * 配货状态
     * 改变状态为3
     */
    @Override
    public MSG distribution(int status, int order_id, String description) {
        orderMapper.insertdesc(description,order_id);
        orderMapper.aftersend(status,order_id);
        return new MSG(1,"配送中");
    }

    /**
     * Created by ZhouLiangWei
     * 确认收货
     * 改变状态为4
     */
    @Override
    public MSG confirmrece(int status, int order_id) {
        orderMapper.confirmrece(status,order_id);
        return new MSG(1,"已确认收货");
    }

    /**
     * Created by ZhouLiangWei
     * 取消订单
     * 申请退款，申请退货
     */
    @Override
    public MSG cancelorder1(int status, int order_id) {
        RMessage rMessage = new RMessage();
        rMessage.setA(orderMapper.findstatus(order_id));
        if (rMessage.getA()== 1) orderMapper.deletedd(order_id);
        return new MSG(1,"取消订单成功");
    }
    @Override
    public MSG cancelorder2(int status, int order_id) {
        RMessage rMessage = new RMessage();
        rMessage.setA(orderMapper.findstatus(order_id));
        if (rMessage.getA()== 2) orderMapper.tuikuan(status,order_id);
        return new MSG(1,"退款中");
    }
    @Override
    public MSG cancelorder3(int status, int order_id) {
        RMessage rMessage = new RMessage();
        rMessage.setA(orderMapper.findstatus(order_id));
        if (rMessage.getA()== 3) orderMapper.tuihuo(status,order_id);
        return new MSG(1,"退货中");
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 输出订单里的一切内容
     */
    @Override
    public MSG lookorder(int order_id) {
        List<Order> order=orderMapper.lookorder(order_id);
        List<JsonOrder> jsonOrderList = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            jsonOrderList.add(Order2JsonOrder(order.get(i)));
        }
        return new MSG(1,"查看成功",jsonOrderList);
    }

    public JsonOrder Order2JsonOrder(Order order){
        //TODO
        JsonOrder jsonOrder = new JsonOrder();
        User user = userMapper.findOne(order.getUser_id());
        jsonOrder.setUsername(user.getName());
        switch (order.getStatus()){
            case 3:
                jsonOrder.setStatus("已付款");
                break;
            case 4:
                jsonOrder.setStatus("已收货");
                break;
            default:
                jsonOrder.setStatus("未知状态");
                break;
        }
        jsonOrder.setDescription(order.getDescription());
        jsonOrder.setImg(order.getImg());
        jsonOrder.setPrice(order.getPrice());
        jsonOrder.setTime(order.getTime());
        jsonOrder.setTotalprice(order.getTotalprice());
        jsonOrder.setGood_num(order.getGood_num());
        return jsonOrder;
    }

    /**
     * Created by ZhouLiangWei
     *查看所有订单
     */
    @Override
    public MSG ordersBrowseAll() {
        Order order1=orderMapper.browseAll();
        return new MSG(1,"查看成功",order1);
    }
}
