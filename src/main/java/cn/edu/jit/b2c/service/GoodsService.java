package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.Goods;

public interface GoodsService {
      String goods(String img);

      Goods goodsFindAll(String key);

      Goods goodsFindShop(int shop_id, String key);
}
