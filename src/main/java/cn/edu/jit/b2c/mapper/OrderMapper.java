package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO Order(time,good_id,user_id,good_num) VALUES time = #{time},good_id = #{good_id}" +
            ",user_id=#{user_id},num=#{num}")
    int insertorder(@Param("time")Timestamp time,@Param("good_id") int good_id,
                    @Param("user_id") int user_id,@Param("good_num") int good_num);

    @Insert("INSERT INTO Order(price) SELECT pirce from Goods WHERE good_id = #{good_id}")
    int insertprice(@Param("good_id") int good_id);

    @Insert("INSERT INTO Order(shop_id) SELECT shop_id from Goods WHERE good_id = #{good_id}")
    int insertshopid(@Param("good_id") int good_id);

    @Insert("INSERT INTO Order(order_id) VALUES Order.user_id where Order.good_id=#{good_id}")
    void insertorderid(@Param("good_id") int good_id);

    @Insert("INSERT INTO Order(totalprice) VALUES Order.price * Order.good_num")
    int totalprice();

    @Update("UPDATE Order SET status = 1 where good_id=#{good_id}")
    void waitpurchase(int status);

    @Update("UPDATE Order SET status = 2 where good_id=#{good_id}")
    void afterpurchase(int status);

    @Update("UPDATE Order SET status = 3 where shop_id=#{shop_id}")
    void aftersend(int status);



    @Update("UPDATE Order SET status = 4 where shop_id=#{shop_id}")
    void afterece(Order status);

}
