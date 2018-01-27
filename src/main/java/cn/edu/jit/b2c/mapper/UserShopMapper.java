package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.pojo.UserShop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserShopMapper {
    @Select("SELECT good_id,usid FROM UserShop WHERE user_id = #{user_id} AND `status` =1")
    List<UserShop> usershopLook(@Param("user_id") int user_id);

    @Select("SELECT name, price,`describe`, img FROM Goods WHERE good_id = #{good_id}")
    Goods usershopGFind(@Param("good_id") int good_id);


    @Select("SELECT shop_id,usid FROM UserShop WHERE user_id = #{user_id} AND status = 2")
    List<UserShop> usershopLook2(@Param("user_id") int user_id);

    @Select("SELECT name,img,`describe` FROM Shop WHERE shop_id = #{shop_id}")
    Shop usershopSFind(@Param("shop_id") int shop_id);


    @Insert("INSERT INTO UserShop(user_id,good_id,status) VALUES (#{user_id},#{good_id},1)")
    int usershopInsert1(@Param("user_id") int user_id,@Param("good_id") int good_id);

    @Insert("INSERT INTO UserShop(user_id,shop_id,status) VALUES (#{user_id},#{shop_id},2)")
    int usershopInsert2(@Param("user_id") int user_id,@Param("shop_id") int shop_id);


    @Delete("DELETE FROM UserShop WHERE usid=#{usid}")
    void delete(@Param("usid") int usid);

}
