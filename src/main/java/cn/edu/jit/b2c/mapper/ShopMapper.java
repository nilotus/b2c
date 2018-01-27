package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Shop;
import cn.edu.jit.b2c.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopMapper {
    @Select("SELECT shop_id,name,img FROM Shop")
    List<Shop> browse();
    @Select("SELECT shop_id,`name`,img,`describe` FROM Shop WHERE user_id =#{user_id}")
    List<Shop> browseByUser(@Param("user_id") int user_id);
    @Select("SELECT shop_id,`name`,img,`describe` FROM Shop WHERE shop_id =#{shop_id}")
    Shop browseOne(@Param("shop_id") int shop_id);
    @Select("SELECT shop_id,name,img FROM Shop WHERE name like CONCAT(CONCAT('%', #{key}), '%')")
    List<Shop> findAll(@Param("key") String key);
    @Select("SELECT shop_id,`name`,`describe`,img FROM Shop WHERE shop_id =#{shop_id}")
    List<Shop> selectShopInfo(@Param("shop_id") int shop_id);
    @Select("SELECT SUM(totalprice) FROM Orders WHERE shop_id =#{shop_id}")
    float money(@Param("shop_id") int shop_id);
    @Select("SELECT COUNT(order_id) FROM Orders WHERE shop_id =#{shop_id}")
    int order(@Param("shop_id") int shop_id);
    @Insert("INSERT INTO Shop(`name`,`describe`,user_id,img) VALUES(#{name},#{describe},#{user_id},#{img})")
    boolean add(Shop shop);
    @Update("UPDATE Shop set `isdelete` = 1 WHERE shop_id = #{shop_id}")
    boolean delete(@Param("shop_id") int shop_id);
    @Update("UPDATE Shop set `name`=#{name},`describe`=#{describe},img=#{img} WHERE shop_id =#{shop_id}")
    boolean update(Shop shop);
    @Select("SELECT User.user_id,User.name,User.address,User.email,User.img FROM User,UserShop WHERE UserShop.shop_id =#{shop_id} AND UserShop.user_id=User.user_id")
    List<User> fan(@Param("shop_id") int shop_id);
}
