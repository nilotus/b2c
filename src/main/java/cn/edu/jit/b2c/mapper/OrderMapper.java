package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO Orders(order_id,time,good_id,user_id,good_num ,price,shop_id,status) " +
            "VALUES (#{user_id},#{time},#{good_id},#{user_id},#{good_num},#{price},#{shop_id},1)")
    int insertorder1(@Param("order_id") int order_id,@Param("time")Timestamp time,@Param("good_id") int good_id,
                    @Param("user_id") int user_id,@Param("good_num") int good_num,
                     @Param("price") float price ,@Param("shop_id") int shop_id);

    @Select("SELECT pirce,shop_id,img from Goods WHERE good_id = #{good_id}")
    Goods findPSid(@Param("good_id") int good_id);

    @Insert("INSERT INTO Orders(totalprice) VALUES Orders.price * Orders.good_num")
    int totalprice();

    @Select("SELECT img FROM Goods where good_id = #{good_id}")
    Goods findimg(@Param("good_id") int good_id);

    @Insert("INSERT INTO Orders(img) VALUES (#{img})")
    int insertimg(@Param("img") String img);

    @Select("SELECT order_id,cart_id,time,user_id,description,status,price,totalprice,img,good_num FROM Orders where order_id = #{order_id}")
    List<Order> lookorder(@Param("order_id") int order_id);

    @Select("SELECT order_id,cart_id,time,user_id,description,status,price FROM Orders")
    Order browseAll();


    @Insert("INSERT INTO Orders(time,good_id,user_id,good_num,cart_id,shop_id,price,status) " +
            "VALUES (#{time},#{good_id},#{user_id},num=#{num},#{cart_id},#{shop_id},#{price},1")
    int insertorder2(@Param("time")Timestamp time,@Param("good_id") int good_id,
                    @Param("user_id") int user_id,@Param("good_num") int good_num,
                     @Param("shop_id") int shop_id,@Param("cart_id") int cart_id,
                     @Param("price") float price);

    @Update("UPDATE Orders SET status = 2 where order_id=#{order_id}")
    void afterpay(int status,@Param("oder_id") int order_id);

    @Delete("DELETE FROM Cart WHERE cart_id = #{cart_id}")
    void deletecart(@Param("cart_id") int cart_id);

    //下面是配送
    @Insert("INSERT INTO Orders(description) VALUES #{description} WHERE order_id = #{order_id}")
    int insertdesc(@Param("description") String description,@Param("order_id") int order_id);

    @Update("UPDATE Orders SET status = 3 where order_id=#{order_id}")
    void aftersend(int status,@Param("oder_id") int order_id);

    //下面是取消订单
    @Select("SELECT status from Orders WHERE order_id=#{order_id}")
    int findstatus(@Param("order_id") int order_id);

    @Delete("DELETE FROM Orders WHERE order_id =#{order_id}")
    void deletedd(@Param("oder_id") int order_id);

    @Update("UPDATE Orders SET status = 5 where order_id=#{order_id}")
    void tuikuan(int status,@Param("oder_id") int order_id);

    @Update("UPDATE Orders SET status = 6 where order_id=#{order_id}")
    void tuihuo(int status,@Param("oder_id") int order_id);

    @Update("UPDATE Orders SET status = 4 where order_id=#{order_id}")
    void confirmrece(int status,@Param("oder_id") int order_id);

}
