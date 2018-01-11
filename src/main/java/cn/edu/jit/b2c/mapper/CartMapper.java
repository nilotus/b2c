package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Cart;
import cn.edu.jit.b2c.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {
    @Select("SELECT cart_id,good_id FROM Cart WHERE user_id =#{user_id}")
    Goods checkone(@Param("user_id") int user_id);

    @Select("SELECT Good.name,Good.price,Good.img,Shop.name FROM Good,Shop WHERE Good.good_id =#{good_id} and Shop.shop_id = Good.shop_id")
    List<String> checktwo(@Param("good_id") int good_id);

    @Select("SELECT goodnum ,price FROM Cart WHERE cart_id =#{cart_id}" )
    List<String> checkthree(@Param("cart_id") int cart_id);

    @Insert("INSERT INTO Cart(user_id,good_id,good_num,status) VALUES user_id = #{user_id},good_id = #{good_id}" +
            ",good_num=#{good_num}")
    int insertCart(@Param("user_id") int user_id,@Param("good_id") int good_id,@Param("good_num") int good_num);

    @Insert("INSERT INTO Cart(price) Values good_num * Goods.price WHERE Goods.good_id = #{good_id} and Good.good.id = Cart.good_id")
    int insertPrice(@Param("good_id") int good_id);

    @Delete("DELETE FROM Cart WHERE good_id=#{good_id}")
    void delete(@Param("good_id") int good_id);
}
