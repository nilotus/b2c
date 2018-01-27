package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.util.MSG;

import java.sql.Timestamp;

public interface UserShopService {
    MSG usershopLook(int user_id);
    MSG usershopLook1(int user_id);
    MSG usershopAdd1(int user_id,int good_id);
    MSG usershopAdd2(int user_id,int shop_id);
    MSG usershopDelete(int usid);
}
