package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Cart;
import cn.edu.jit.b2c.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {
    @Select("SELECT cart_id,good_id FROM Cart WHERE user_id =#{user_id}")
    Goods checkone(@Param("user_id") int user_id);

    @Select("SELECT name,price,img FROM Goods WHERE good_id =#{good_id}")
    Goods checktwo1(@Param("good_id") int good_id);

    @Select("SELECT shop.name FROM Goods,Shop WHERE Goods.good_id =#{good_id} AND Goods.shop_id=Shop.shop_id")
     String checktwo2(@Param("good_id") int good_id);

    @Select("SELECT good_num ,price FROM Cart WHERE cart_id =#{cart_id}" )
    Cart checkthree(@Param("cart_id") int cart_id);

    @Insert("INSERT INTO Cart(user_id,good_id,good_num,status) VALUES user_id = #{user_id},good_id = #{good_id}" +
            ",good_num=#{good_num}")
    int insertCart(@Param("user_id") int user_id,@Param("good_id") int good_id,@Param("good_num") int good_num);

    @Insert("INSERT INTO Cart(shop_id) VALUES Good.shop_id WHERE Goods.good_id = #{good_id} and Goods.shop_id = Shop.shop_id")
    int insertCart2(@Param("good_id") int good_id);

    @Insert("INSERT INTO Cart(price) Values good_num * Goods.price WHERE Goods.good_id = #{good_id} and Good.good.id = Cart.good_id")
    int insertPrice(@Param("good_id") int good_id);

    @Delete("DELETE FROM Cart WHERE good_id=#{good_id}")
    void delete(@Param("good_id") int good_id);
}
