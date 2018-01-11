package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO Order(time,good_id,user_id,num) VALUES time = #{time},good_id = #{good_id}" +
            ",user_id=#{user_id},num=#{num}")
    int insertorder(@Param("time")Timestamp time,@Param("shop_id") int shop_id,
                    @Param("user_id") int user_id,@Param("num") int num);

    @Insert("INSERT INTO Order(price) SELECT pirce from Goods WHERE shop_id = #{shop_id}")
    int price(@Param("shop_id") int shop_id);

    @Insert("INSERT INTO Order(total_fee) VALUES Order.price * Order.num")
    Order totalprice();

    @Update("UPDATE Order SET status = 1 where shop_id=#{shop_id}")
    void waitpurchase(int status);

    @Update("UPDATE Order SET status = 2 where shop_id=#{shop_id}")
    void afterpurchase(int status);

    @Update("UPDATE Order SET status = 3 where shop_id=#{shop_id}")
    void aftersend(int status);



    @Update("UPDATE Order SET status = 4 where shop_id=#{shop_id}")
    void afterece(Order status);

}
