package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.pojo.UserShop;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

@Mapper
public interface UserShopMapper {
    @Select("SELECT status,shop_id,good_id FROM UserShop WHERE user_id = #{user_id}")
    UserShop usershopLook(@Param("user_id") int user_id);

    @Select("SELECT Goods.name,Goods.price,Goods.img,Goods.shop_id FROM Goods WHERE good_id = #{good_id}")
    Goods usershopGFind(@Param("good_id") int good_id);

    @Select("SELECT name FROM Shop WHERE shop_id = #{shop_id}")
    String usershopGFind1(@Param("shop_id") int shop_id);


    @Select("SELECT name,img FROM Shop WHERE shop_id = #{shop_id}")
    Shop usershopSFind(@Param("shop_id") int shop_id);


    @Insert("INSERT INTO UserShop(user_id,good_id,status) VALUES (#{user_id},#{good_id},1)")
    int usershopInsert1(@Param("user_id") int user_id,@Param("good_id") int good_id);

    @Insert("INSERT INTO UserShop(user_id,shop_id,status) VALUES (#{user_id},#{shop_id},2)")
    int usershopInsert2(@Param("user_id") int user_id,@Param("shop_id") int shop_id);


    @Delete("DELETE FROM UserShop WHERE good_id=#{good_id}")
    void delete1(@Param("good_id") int good_id);

    @Delete("DELETE FROM UserShop WHERE shop_id=#{shop_id}")
    void delete2(@Param("shop_id") int shop_id);
}
