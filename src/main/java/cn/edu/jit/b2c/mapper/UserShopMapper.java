package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Shop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

@Mapper
public interface UserShopMapper {
    @Select("SELECT * FROM Shop WHERE shop_id = #{shop_id}")
    Shop findUsershop(@Param("shop_id") Integer shop_id);

    @Insert("INSERT INTO UserShop(time) VALUES #{time}")
    int intertime(@Param("time") Timestamp time);

    @Insert("INSERT INTO UserShop(shop_id) VALUES #{shop_id}")
    int intershop_id(@Param("shop_id") Integer shop_id);
}
