package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO Orders(time,good_id,user_id,good_num ,price,`status`,img,description) " +
            "VALUES (#{time},#{good_id},#{user_id},#{good_num},#{price},1,#{img},#{description})")
    int insertorder1(@Param("time")Timestamp time,@Param("good_id") int good_id,
                     @Param("user_id") int user_id,@Param("good_num") int good_num,
                     @Param("price") float price,@Param("img") String img,@Param("description") String descption);

    @Select("SELECT order_id,time,user_id,description,status,price,img,good_num,good_id FROM Orders where user_id = #{user_id} AND `delete`=1")
    List<Order> lookorder(@Param("user_id") int user_id);

    @Select("SELECT order_id,time,user_id,description,status,price,img,good_num,good_id FROM Orders where user_id = #{user_id} AND `status`=1 AND `delete`=1")
    List<Order> lookorder1(@Param("user_id") int user_id);

    @Select("SELECT order_id,time,user_id,description,status,price,img,good_num,good_id FROM Orders where user_id = #{user_id} AND `status`=2 AND `delete`=1")
    List<Order> lookorder2(@Param("user_id") int user_id);

    @Select("SELECT order_id,time,user_id,description,status,price,img,good_num,good_id FROM Orders where user_id = #{user_id} AND `status`=3 AND `delete`=1")
    List<Order> lookorder3(@Param("user_id") int user_id);

    @Select("SELECT order_id,time,user_id,description,status,price,img,good_num,good_id FROM Orders where user_id = #{user_id} AND `status`=4 AND `delete`=1")
    List<Order> lookorder4(@Param("user_id") int user_id);

    @Select("SELECT order_id,time,user_id,description,status,price,img,good_num,good_id FROM Orders where user_id = #{user_id} AND `status`=5 AND `delete`=1")
    List<Order> lookorder5(@Param("user_id") int user_id);

    @Select("SELECT order_id,time,user_id,description,status,price,img,good_num,good_id FROM Orders where user_id = #{user_id} AND `status`=6 AND `delete`=1")
    List<Order> lookorder6(@Param("user_id") int user_id);

    @Select("SELECT order_id,time,user_id,description,status,price,img,good_num,good_id FROM Orders where user_id = #{user_id} AND `status`=7 AND `delete`=1")
    List<Order> lookorder7(@Param("user_id") int user_id);

    @Select("SELECT price,good_num FROM Orders WHERE order_id = #{order_id} AND user_id= #{user_id}")
    Order fukuan(@Param("order_id") int order_id, @Param("user_id") int user_id);

    @Update("UPDATE Orders SET status = 2 where order_id=#{order_id} AND user_id=#{user_id}")
    void afterpay(@Param("order_id") int order_id,@Param("user_id") int user_id);

    @Update("UPDATE Orders SET status = 3 where order_id=#{order_id} AND user_id=#{user_id}")
    void confirmrece(@Param("order_id") int order_id,@Param("user_id") int user_id);
    //下面是取消订单

    @Update("UPDATE  Orders SET `delete`=0 WHERE order_id =#{order_id}")
    void deletedd(@Param("order_id") int order_id);

    @Update("UPDATE Orders SET status = 6 where order_id=#{order_id}")
    void tuikuan(@Param("order_id") int order_id);

    @Update("UPDATE Orders SET status = 4 where order_id=#{order_id}")
    void tuihuo(@Param("order_id") int order_id);

    @Select("SELECT Orders.order_id, Orders.time, Orders.user_id, Orders.description, Orders.status,Orders.good_id, Orders.good_num, Orders.price, Orders.delete \n" +
            "from Shop, Orders, Goods\n" +
            "WHERE Goods.shop_id = Shop.shop_id and Orders.good_id = Goods.good_id and Shop.shop_id = #{shop_id}")
    List<Order> shop(@Param("shop_id") int shop_id);


}
