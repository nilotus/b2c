package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.Goods;

public interface GoodsService {
      String goodsBrowse(int good_id);

      Goods goodsFindAll(String key);

      Goods goodsFindShop(int shop_id, String key);
}
