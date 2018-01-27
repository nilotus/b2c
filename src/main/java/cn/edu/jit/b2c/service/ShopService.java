package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.util.MSG;

public interface ShopService {
        MSG shopBrowse();
        MSG shopBrowseOne(int shop_id);
        MSG shopFindAll(String key);
        MSG shopINFO(int shop_id);
        MSG shopAdd(Shop shop);
        MSG shopDelete(int shop_id);
        MSG shopUpdate(Shop shop);
        MSG shopFan(int shop_id);
}
