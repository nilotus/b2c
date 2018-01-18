package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.util.MSG;

import java.sql.Timestamp;

public interface OrderService {
    MSG purchaseDirent(int user_id, int good_id, Timestamp time, int status, int good_num);

    MSG purchaseCart(int user_id, int good_id, Timestamp time, int status, int good_num, float price, int shop_id,
                     int cart_id);

    MSG afterpay(int status, int order_id, int cart_id);

    MSG distribution(int status, int order_id, String description);

    MSG confirmrece(int status, int order_id);

    MSG cancelorder1(int status, int order_id);

    MSG cancelorder2(int status, int order_id);

    MSG cancelorder3(int status, int order_id);

    MSG lookorder(int order_id);

    MSG ordersBrowseAll();

}
