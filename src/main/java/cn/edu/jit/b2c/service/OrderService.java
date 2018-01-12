package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.util.MSG;

import java.sql.Timestamp;

public interface OrderService {
    MSG purchaseDirent(int user_id, int good_id, Timestamp time,int status,int good_num,float price);
    MSG purchaseCart(int user_id, int good_id, Timestamp time,int status,int good_num,float price);
    MSG statusOrder(int status,String description);
    MSG afertpay(int status);
}
