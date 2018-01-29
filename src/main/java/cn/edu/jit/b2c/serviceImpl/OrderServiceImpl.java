package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.GoodsMapper;
import cn.edu.jit.b2c.mapper.OrderMapper;
import cn.edu.jit.b2c.mapper.UserMapper;
import cn.edu.jit.b2c.pojo.*;
import cn.edu.jit.b2c.service.OrderService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    /**TODO
     * Created by ZhouLiangWei
     * 下订单
     * 输入 user_id, good_id, time, status, good_num, price,img,description
     */
    @Override
    public MSG purchaseDirent(int user_id, List<Integer> good_id,List<Integer> good_num) {
        for (int i = 0; i < good_id.size(); i++){
            Goods goods = goodsMapper.browseOne1(good_id.get(i));
        Timestamp time = new Timestamp(System.currentTimeMillis());
        orderMapper.insertorder1(time, good_id.get(i), user_id, good_num.get(i), goods.getPrice(), goods.getImg(), goods.getDescribe());
    }
        return new MSG(1,"下订单成功");
    }


    /**
     * Created by ZhouLiangWei
     * 付款
     */
    @Override
    public MSG fukuan(int order_id,int user_id) {
        Order order = orderMapper.fukuan(order_id,user_id);
        return new MSG(1,"查找成功",order);
    }


    /**
     * Created by ZhouLiangWei
     * 付款之后
     * 改变状态为2
     */
    @Override
    public MSG distribution(int order_id, int user_id) {
        orderMapper.afterpay(order_id,user_id);
        return new MSG(1,"配送中");
    }

    /**
     * Created by ZhouLiangWei
     * 确认收货
     * 改变状态为4
     */
    @Override
    public MSG confirmrece(int order_id,int user_id) {
        orderMapper.confirmrece(order_id,user_id);
        return new MSG(1,"已确认收货");
    }



    /**TODO
     * Created by ZhouLiangWei
     * 取消订单,申请退款，申请退货
     */
    @Override
    public MSG cancelorder1(int order_id) {
        orderMapper.deletedd(order_id);
        return new MSG(1,"取消订单成功");
    }
    @Override
    public MSG cancelorder2(int order_id) {
        orderMapper.tuikuan(order_id);
        return new MSG(1,"退款中");
    }
    @Override
    public MSG cancelorder3( int order_id) {
        orderMapper.tuihuo(order_id);
        return new MSG(1,"退货中");
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 根据user_id输出订单里的一切内容
     */
    @Override
    public MSG lookorder(int user_id) {
        List<Order> order=orderMapper.lookorder(user_id);
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
            case 1:
                jsonOrder.setStatus("待付款");
                break;
            case 2:
                jsonOrder.setStatus("待收货");
                break;
            case 3:
                jsonOrder.setStatus("已收货");
                break;
            case 4:
                jsonOrder.setStatus("退货中");
                break;
            case 5:
                jsonOrder.setStatus("已退货");
                break;
            case 6:
                jsonOrder.setStatus("退款中");
                break;
            case 7:
                jsonOrder.setStatus("已退款");
                break;
            default:
                jsonOrder.setStatus("未知状态");
                break;
        }
        jsonOrder.setDescription(order.getDescription());
        jsonOrder.setImg(order.getImg());
        jsonOrder.setPrice(order.getPrice());
        jsonOrder.setTime(order.getTime());
        jsonOrder.setGood_num(order.getGood_num());
        jsonOrder.setGood_id(order.getGood_id());
        jsonOrder.setOrder_id(order.getOrder_id());
        return jsonOrder;
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 根据user_id输出订单里的代付款信息
     */
    @Override
    public MSG lookorder1(int user_id) {
        List<Order> order1=orderMapper.lookorder1(user_id);
        List<JsonOrder> jsonOrderList = new ArrayList<>();
        for (int i = 0; i < order1.size(); i++) {
            jsonOrderList.add(Order3JsonOrder(order1.get(i)));
        }
        return new MSG(1,"查看成功",jsonOrderList);
    }
    public JsonOrder Order3JsonOrder(Order order1){
        //TODO
        JsonOrder jsonOrder = new JsonOrder();
        User user = userMapper.findOne(order1.getUser_id());
        jsonOrder.setUsername(user.getName());
        switch (order1.getStatus()){
            case 1:
                jsonOrder.setStatus("待付款");
        }
        jsonOrder.setDescription(order1.getDescription());
        jsonOrder.setImg(order1.getImg());
        jsonOrder.setPrice(order1.getPrice());
        jsonOrder.setTime(order1.getTime());
        jsonOrder.setGood_num(order1.getGood_num());
        jsonOrder.setGood_id(order1.getGood_id());
        jsonOrder.setOrder_id(order1.getOrder_id());
        return jsonOrder;
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 根据user_id输出订单里的代收货信息
     */
    @Override
    public MSG lookorder2(int user_id) {
        List<Order> order=orderMapper.lookorder2(user_id);
        List<JsonOrder> jsonOrderList = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            jsonOrderList.add(Order4JsonOrder(order.get(i)));
        }
        return new MSG(1,"查看成功",jsonOrderList);
    }
    public JsonOrder Order4JsonOrder(Order order){
        //TODO
        JsonOrder jsonOrder = new JsonOrder();
        User user = userMapper.findOne(order.getUser_id());
        jsonOrder.setUsername(user.getName());
        switch (order.getStatus()){
            case 2:
                jsonOrder.setStatus("待收货");
        }
        jsonOrder.setDescription(order.getDescription());
        jsonOrder.setImg(order.getImg());
        jsonOrder.setPrice(order.getPrice());
        jsonOrder.setTime(order.getTime());
        jsonOrder.setGood_num(order.getGood_num());
        jsonOrder.setGood_id(order.getGood_id());
        jsonOrder.setOrder_id(order.getOrder_id());
        return jsonOrder;
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 根据user_id输出订单里的已收货信息
     */
    @Override
    public MSG lookorder3(int user_id) {
        List<Order> order=orderMapper.lookorder3(user_id);
        List<JsonOrder> jsonOrderList = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            jsonOrderList.add(Order5JsonOrder(order.get(i)));
        }
        return new MSG(1,"查看成功",jsonOrderList);
    }
    public JsonOrder Order5JsonOrder(Order order){
        //TODO
        JsonOrder jsonOrder = new JsonOrder();
        User user = userMapper.findOne(order.getUser_id());
        jsonOrder.setUsername(user.getName());
        switch (order.getStatus()){
            case 3:
                jsonOrder.setStatus("已收货");
        }
        jsonOrder.setDescription(order.getDescription());
        jsonOrder.setImg(order.getImg());
        jsonOrder.setPrice(order.getPrice());
        jsonOrder.setTime(order.getTime());
        jsonOrder.setGood_num(order.getGood_num());
        jsonOrder.setGood_id(order.getGood_id());
        jsonOrder.setOrder_id(order.getOrder_id());
        return jsonOrder;
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 根据user_id输出订单里的退货中信息
     */
    @Override
    public MSG lookorder4(int user_id) {
        List<Order> order=orderMapper.lookorder4(user_id);
        List<JsonOrder> jsonOrderList = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            jsonOrderList.add(Order6JsonOrder(order.get(i)));
        }
        return new MSG(1,"查看成功",jsonOrderList);
    }
    public JsonOrder Order6JsonOrder(Order order){
        //TODO
        JsonOrder jsonOrder = new JsonOrder();
        User user = userMapper.findOne(order.getUser_id());
        jsonOrder.setUsername(user.getName());
        switch (order.getStatus()){
            case 4:
                jsonOrder.setStatus("退货中");
        }
        jsonOrder.setDescription(order.getDescription());
        jsonOrder.setImg(order.getImg());
        jsonOrder.setPrice(order.getPrice());
        jsonOrder.setTime(order.getTime());
        jsonOrder.setGood_num(order.getGood_num());
        jsonOrder.setGood_id(order.getGood_id());
        jsonOrder.setOrder_id(order.getOrder_id());
        return jsonOrder;
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 根据user_id输出订单里的已退货信息
     */
    @Override
    public MSG lookorder5(int user_id) {
        List<Order> order=orderMapper.lookorder5(user_id);
        List<JsonOrder> jsonOrderList = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            jsonOrderList.add(Order7JsonOrder(order.get(i)));
        }
        return new MSG(1,"查看成功",jsonOrderList);
    }
    public JsonOrder Order7JsonOrder(Order order){
        //TODO
        JsonOrder jsonOrder = new JsonOrder();
        User user = userMapper.findOne(order.getUser_id());
        jsonOrder.setUsername(user.getName());
        switch (order.getStatus()){
            case 5:
                jsonOrder.setStatus("已退货");
        }
        jsonOrder.setDescription(order.getDescription());
        jsonOrder.setImg(order.getImg());
        jsonOrder.setPrice(order.getPrice());
        jsonOrder.setTime(order.getTime());
        jsonOrder.setGood_num(order.getGood_num());
        jsonOrder.setGood_id(order.getGood_id());
        jsonOrder.setOrder_id(order.getOrder_id());
        return jsonOrder;
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 根据user_id输出订单里的退款中信息
     */
    @Override
    public MSG lookorder6(int user_id) {
        List<Order> order=orderMapper.lookorder6(user_id);
        List<JsonOrder> jsonOrderList = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            jsonOrderList.add(Order8JsonOrder(order.get(i)));
        }
        return new MSG(1,"查看成功",jsonOrderList);
    }
    public JsonOrder Order8JsonOrder(Order order){
        //TODO
        JsonOrder jsonOrder = new JsonOrder();
        User user = userMapper.findOne(order.getUser_id());
        jsonOrder.setUsername(user.getName());
        switch (order.getStatus()){
            case 6:
                jsonOrder.setStatus("退款中");
        }
        jsonOrder.setDescription(order.getDescription());
        jsonOrder.setImg(order.getImg());
        jsonOrder.setPrice(order.getPrice());
        jsonOrder.setTime(order.getTime());
        jsonOrder.setGood_num(order.getGood_num());
        jsonOrder.setGood_id(order.getGood_id());
        jsonOrder.setOrder_id(order.getOrder_id());
        return jsonOrder;
    }

    /**
     * Created by ZhouLiangWei
     * 查看订单
     * 根据user_id输出订单里的已退款信息
     */
    @Override
    public MSG lookorder7(int user_id) {
        List<Order> order=orderMapper.lookorder7(user_id);
        List<JsonOrder> jsonOrderList = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            jsonOrderList.add(Order9JsonOrder(order.get(i)));
        }
        return new MSG(1,"查看成功",jsonOrderList);
    }
    public JsonOrder Order9JsonOrder(Order order){
        //TODO
        JsonOrder jsonOrder = new JsonOrder();
        User user = userMapper.findOne(order.getUser_id());
        jsonOrder.setUsername(user.getName());
        switch (order.getStatus()){
            case 7:
                jsonOrder.setStatus("已退款");
        }
        jsonOrder.setDescription(order.getDescription());
        jsonOrder.setImg(order.getImg());
        jsonOrder.setPrice(order.getPrice());
        jsonOrder.setTime(order.getTime());
        jsonOrder.setGood_num(order.getGood_num());
        jsonOrder.setGood_id(order.getGood_id());
        jsonOrder.setOrder_id(order.getOrder_id());
        return jsonOrder;
    }
}
