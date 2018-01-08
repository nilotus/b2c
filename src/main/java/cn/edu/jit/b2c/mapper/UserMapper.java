package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ChenQF on 2018/1/5.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM User WHERE phone =#{phone}")
    User findPhone(@Param("phone") String phone);

    @Insert("INSERT INTO User(phone,password) VALUES(#{phone},#{password})")
    int insertUser(@Param("name") String phone, @Param("age") Integer password);

}
