package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.Shop;

public interface ShopService {
        String shop(String img);
        Shop shopFindAll(String key);
}
