package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.util.MSG;

public interface CartService {
    MSG goodsCheckOne(int user_id);
    MSG goodsCheckTwo(int good_id);
    MSG goodsCheckThree(int cart_id);
    MSG goodsAdd(int good_id,int user_id);
    MSG goodsDelete(int cart_id);
}
