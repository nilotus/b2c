package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.PushOrder;
import cn.edu.jit.b2c.service.OrderService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * Created by ZhouLiangWei
     * 下订单
     * 输入 user_id, good_id, time, status, good_num, price ，shop_id和 totalprice
     */
    @PostMapping("/dirent")
    public MSG purchaseDirent(@RequestBody PushOrder pushOrder) throws IOException{
        System.out.println(pushOrder);
         return orderService.purchaseDirent(pushOrder.getUser_id(),pushOrder.getGood_id(),pushOrder.getGood_num());
    }

    /**
     * Created by ZhouLiangWei
     *查看所有订单
     */
    @PostMapping("/lookall")
    public  MSG lookall() throws IOException{
        return orderService.ordersBrowseAll();
    }

    /**
     * Created by ZhouLiangWei
     *查看所有订单
     */
    @RequestMapping("/orderBorwse/{shop_id}")
    public MSG orderBorwse(@PathVariable("shop_id") int shop_id) throws IOException{
        return orderService.ordersBrowseOne(shop_id);
    }



    /**
     * Created by ZhouLiangWei
     * 付款后
     * 改变状态
     */
    @PostMapping("afterpay")
    public MSG afterpay(int status ,int order_id,int cart_id) throws IOException{
        return orderService.afterpay(status,order_id,cart_id);
    }

    /**
     * Created by ZhouLiangWei
     * 配货状态
     * 改变状态为3
     */
    @PostMapping("/distribution")
    public MSG distribution(int status, int order_id, String description) throws  IOException{
        return orderService.distribution(status,order_id,description);
    }

    /**
     * Created by ZhouLiangWei
     * 确认收货
     * 改变状态为4
     */
    @PostMapping("/confirmrece")
    public MSG confirmrece( int order_id) throws IOException {
        return orderService.confirmrece(order_id);
    }


    /**
     * Created by ZhouLiangWei
     * 查看全部订单
     */
    @PostMapping("/lookorder/{user_id}")
    public  MSG lookorder(@PathVariable("user_id") int user_id) throws IOException{
        return  orderService.lookorder(user_id);
    }

    /**
     * Created by ZhouLiangWei
     * 查看未付款订单
     */
    @PostMapping("/lookorder1/{user_id}")
    public  MSG lookorder1(@PathVariable("user_id") int user_id) throws IOException{
        return  orderService.lookorder1(user_id);
    }
    /**
     * Created by ZhouLiangWei
     * 查看待收货订单
     */
    @PostMapping("/lookorder2/{user_id}")
    public  MSG lookorder2(@PathVariable("user_id") int user_id) throws IOException{
        return  orderService.lookorder2(user_id);
    }
    /**
     * Created by ZhouLiangWei
     * 查看已收货订单
     */
    @PostMapping("/lookorder3/{user_id}")
    public  MSG lookorder3(@PathVariable("user_id") int user_id) throws IOException{
        return  orderService.lookorder3(user_id);
    }
    /**
     * Created by ZhouLiangWei
     * 查看退货中订单
     */
    @PostMapping("/lookorder4/{user_id}")
    public  MSG lookorder4(@PathVariable("user_id") int user_id) throws IOException{
        return  orderService.lookorder4(user_id);
    }
    /**
     * Created by ZhouLiangWei
     * 查看已退货订单
     */
    @PostMapping("/lookorder5/{user_id}")
    public  MSG lookorder5(@PathVariable("user_id") int user_id) throws IOException{
        return  orderService.lookorder5(user_id);
    }
    /**
     * Created by ZhouLiangWei
     * 查看退款中订单
     */
    @PostMapping("/lookorder6/{user_id}")
    public  MSG lookorder6(@PathVariable("user_id") int user_id) throws IOException{
        return  orderService.lookorder6(user_id);
    }
    /**
     * Created by ZhouLiangWei
     * 查看已退款订单
     */
    @PostMapping("/lookorder7/{user_id}")
    public  MSG lookorder7(@PathVariable("user_id") int user_id) throws IOException{
        return  orderService.lookorder7(user_id);
    }

    /**
     * Created by ZhouLiangWei
     * 删除订单
     */
    @GetMapping("/cancelorder1/{order_id}")
    public MSG cancelorder1(@PathVariable int order_id) throws  IOException{
        return orderService.cancelorder1(order_id);
    }

    /**
     * Created by ZhouLiangWei
     * 申请退款
     */
    @GetMapping("/cancelorder2/{order_id}")
    public MSG cancelorder2(@PathVariable("order_id") int order_id) throws IOException{
        return orderService.cancelorder2(order_id);
    }

    /**
     * Created by ZhouLiangWei
     * 申请退货
     */
    @GetMapping("/cancelorder3/{order_id}")
    public MSG cancelorder3(@PathVariable("order_id") int order_id) throws IOException{
        return orderService.cancelorder3(order_id);
    }
}
