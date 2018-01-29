package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface UserMapper {
    @Select("SELECT * FROM User WHERE phone =#{phone}")
    User findPhone(@Param("phone") String phone);
    @Insert("INSERT INTO User(phone,password,role_id,name,address,email) VALUES(#{phone},#{password},#{role_id},#{name},#{address},#{email})")
    boolean addUser(User user);
    @Select("SELECT phone,role_id,name,address,email FROM User")
    List<User> findAll();
    @Select("SELECT phone,name,address,email,img FROM User WHERE user_id =#{user_id}")
    User findOne(@Param("user_id") int user_id);
    @Delete("DELETE FROM User WHERE user_id =#{user_id}")
    boolean delete(@Param("user_id") int user_id);
    @Update("UPDATE User set name=#{name},phone=#{phone},address=#{address},email=#{email} WHERE user_id =#{user_id}")
    boolean update(@Param("user_id") int user_id,@Param("name") String name, @Param("phone") String phone,@Param("address") String address,@Param("email") String email);
    @Update("UPDATE User set img=#{img} WHERE user_id =#{user_id}")
    boolean setImg(@Param("user_id")int user_id,@Param("img")String img);

}
