package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Cart;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {
    @Select("SELECT cart_id,good_id FROM Cart WHERE user_id =#{user_id}")
    List<Cart> checkone(@Param("user_id") int user_id);

    @Select("SELECT name,price,img,good_id FROM Goods WHERE good_id =#{good_id}")
    Goods checktwo1(@Param("good_id") int good_id);

    @Select("SELECT name FROM Shop WHERE shop_id =#{shop_id}")
    String checktwo2(@Param("shop_id") int shop_id);

    @Select("SELECT good_num ,price FROM Cart WHERE cart_id =#{cart_id}" )
    Cart checkthree(@Param("cart_id") int cart_id);

    @Insert("INSERT INTO Cart(user_id,good_id,price,shop_id) VALUES (#{user_id},#{good_id}," +
            "#{price},#{shop_id})")
    int insertCart(@Param("user_id") int user_id,@Param("good_id") int good_id,
                   @Param("price") float price,@Param("shop_id") int shop_id);

    @Select("SELECT shop_id,price FROM Goods WHERE good_id=#{good_id}")
    Goods findSidP(@Param("good_id") int good_id);

    @Delete("DELETE FROM Cart WHERE cart_id=#{cart_id}")
    void delete(@Param("cart_id") int cart_id);
}
