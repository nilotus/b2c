package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.service.OrderService;
import cn.edu.jit.b2c.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * Created by ZhouLiangWei
     * 直接下订单
     * 输入 user_id, good_id, time, status, good_num, price ，shop_id和 totalprice
     */
    @GetMapping("/dirent")
    public MSG purchaseDirent(int user_id, int good_id, Timestamp time, int status, int good_num) throws IOException{
        return orderService.purchaseDirent(user_id,good_id,time,status,good_num);
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
     * 购物车下订单
     * 输入 总价格toatl-pee，改变状态
     */
    @GetMapping("/pcart")
    public MSG purchaseCart(int user_id, int good_id, Timestamp time, int status,
                            int good_num, float price, int shop_id, int cart_id)  throws IOException{
        return orderService.purchaseCart(user_id,good_id,time,status,good_num,price,shop_id,cart_id);
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
    public MSG confirmrece(int status, int order_id) throws IOException {
        return orderService.confirmrece(status,order_id);
    }


    /**
     * Created by ZhouLiangWei
     * 查看订单
     */
    @PostMapping("/lookorder/{order_id}")
    public  MSG lookorder(@PathVariable("order_id") int order_id) throws IOException{
        return  orderService.lookorder(order_id);
    }

    /**
     * Created by ZhouLiangWei
     * 删除订单
     */
    @DeleteMapping("/cancelorder1")
    public MSG cancelorder1(int status, int order_id) throws  IOException{
        return orderService.cancelorder1(status,order_id);
    }

    /**
     * Created by ZhouLiangWei
     * 申请退款
     */
    @PostMapping("/cancelorder2")
    public MSG cancelorder2(int status, int order_id) throws IOException{
        return orderService.cancelorder2(status,order_id);
    }

    /**
     * Created by ZhouLiangWei
     * 申请退货
     */
    @PostMapping("/cancelorder3")
    public MSG cancelorder3(int status, int order_id) throws IOException{
        return orderService.cancelorder3(status,order_id);
    }
}
