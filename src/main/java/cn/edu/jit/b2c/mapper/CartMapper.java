package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CartMapper {
    @Insert("INSERT INTO Cart(price,good_id) FROM Good(price,good_id) WHERE good_id = #{good_id}")
    int insertCart(@Param("price") Float price,@Param("good_id") Integer good_id);

    @Select("SELECT * FROM Goods WHERE good_id =#{good_id}")
    Goods findGood_id(@Param("good_id") Integer good_id);

    @Insert("INSERT INTO Cart(status) VALUES #{status}")
    int insertCart_s(@Param("status") Integer status);
}
