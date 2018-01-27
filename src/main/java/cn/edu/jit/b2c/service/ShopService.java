package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.util.MSG;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public interface ShopService {
    MSG shopBrowse(int user_id);

    MSG shopFindAll(String key);

    MSG shopINFO(int shop_id);

    MSG shopEdit(Shop shop);

    MSG shopDelete(int shop_id);

    MSG shopFan(int shop_id);

    MSG findShopInfo(int shop_id);
}
