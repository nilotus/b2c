package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShopMapper {
    @Select("SELECT * FROM Shop WHERE img =#{img}")
    Shop findImg(@Param("img") String img);

    @Select("SElECT * FROM Goods WHERE shop_id = #{shop_id}")
    Goods findShop_id(@Param("shop_id") Integer shop_id);
}
