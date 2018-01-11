package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.pojo.UserShop;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

@Mapper
public interface UserShopMapper {
    @Select("SELECT status,shop_id,good_id FROM UserShop WHERE user_id = #{user_id}")
    UserShop usershopLook(@Param("user_id") int user_id);

    @Select("SELECT Goods.name,Goods.price,Goods.img,Shop.name, FROM UserShop,Goods " +
            "WHERE UserShop.shop_id = #{shop_id} and UserShop.status = #{status} and UserShop.shop_id=Good.shop_id")
    UserShop usershopFind(@Param("user_id") int user_id ,@Param("status") int status);

    @Select("SELECT name,img FROM Shop WHERE shop_id = #{shop_id},status = #{status}")
    Shop usershopSFind(@Param("shop_id") int shop_id,@Param("status") int status);

    @Insert("INSERT INTO UserShop(user_id,shop_id,good_id,status) VALUES (#{user_id},#{shop_id},#{good_id},#{status})")
    int usershopInsert(@Param("user_id") int user_id,@Param("shop_id") int shop_id,
                      @Param("good_id") int good_id,@Param("status") int status);

    @Delete("DELETE FROM UserShop WHERE good_id=#{good_id}")
    void delete(@Param("good_id") int good_id);
}
