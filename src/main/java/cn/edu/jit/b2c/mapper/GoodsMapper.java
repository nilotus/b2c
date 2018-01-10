package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {
    @Select("SELECT name,price,img FROM Goods WHERE good_id =#{good_id}")
    Goods browse(@Param("good_id") int good_id);
    @Select("SELECT img FROM Goods WHERE name like '%key%'")
    Goods findAll(@Param("key") String key);
    @Select("SELECT img FROM Goods WHERE name like '%key%' WHERE shop_id =#{shop_id}")
    Goods findShop(@Param("shop_id") int shop_id, @Param("key") String key);
}
