package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.util.MSG;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    MSG purchaseDirent(int user_id, List<Integer> good_id, List<Integer> good_num);

    MSG distribution(int order_id, int user_id);

    MSG confirmrece(int order_id, int user_id);

    MSG cancelorder1(int order_id);

    MSG cancelorder2(int order_id);

    MSG cancelorder3(int order_id);

    MSG lookorder(int user_id);

    MSG lookorder1(int user_id);
    MSG lookorder2(int user_id);
    MSG lookorder3(int user_id);
    MSG lookorder4(int user_id);
    MSG lookorder5(int user_id);
    MSG lookorder6(int user_id);
    MSG lookorder7(int user_id);

    MSG fukuan(int order_id,int user_id);
    MSG ordersShop(int shop_id);

}
