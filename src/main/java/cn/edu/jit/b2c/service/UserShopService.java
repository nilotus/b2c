package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.util.MSG;

import java.sql.Timestamp;

public interface UserShopService {
    MSG usershopLook(int user_id);
    MSG usershopGFind(int good_id,int status);
    MSG usershopSFind(int shop_id,int status);
    MSG usershopAdd(int user_id,int good_id,int shop_id,int status);
    MSG usershopDelete(int shop_id);
}
