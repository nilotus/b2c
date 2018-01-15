package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.util.MSG;

public interface GoodsService {
      MSG goodsBrowseAll();
      MSG goodsBrowseOne(int good_id);
      MSG goodsBrowseShop(int shop_id);
      MSG goodsFindAll( String key);
      MSG goodsFindShop(int shop_id,String key);
      MSG goodsAdd(Goods goods);
      MSG goodsDelete(int good_id);
      MSG goodsUpdate(Goods goods);
      MSG goodsSaleNum(int good_id);
}
