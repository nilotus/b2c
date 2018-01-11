package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.util.MSG;

import java.sql.Timestamp;

public interface OrderService {
    MSG purchaseWait(int user_id, int shop_id, Timestamp time,int status,int num);
    MSG payWait(int status);
    MSG statusOrder(int status,String description);
    MSG afertpay(int status);
}
