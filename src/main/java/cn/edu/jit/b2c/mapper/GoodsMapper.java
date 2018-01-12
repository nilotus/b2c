package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {
    @Select("SELECT name,price,img FROM Goods")
    Goods browseAll();
    /*sql语句多表查询*/
    @Select("SELECT t1.name,t1.price,t1.img,t2.name FROM Goods t1,Shop t2 WHERE t1.good_id =#{good_id} AND t1.shop_id =t2.shop_id")
    Goods browseOne(@Param("good_id") int good_id);
    @Select("SELECT t1.name,t1.price,t1.img,t2.name FROM Goods WHERE shop_id =#{shop_id}")
    Goods browseShop(@Param("shop_id") int shop_id);
    @Select("SELECT img FROM Goods WHERE name like '%key%'")
    Goods findAll(@Param("key") String key);
    @Select("SELECT img FROM Goods WHERE name like '%key%' WHERE shop_id =#{shop_id}")
    Goods findShop(@Param("shop_id") int shop_id, @Param("key") String key);
}
