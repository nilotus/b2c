package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper

public interface UserMapper {
    @Select("SELECT * FROM User WHERE phone =#{phone}")
    User findPhone(@Param("phone") String phone);
    @Insert("INSERT INTO User(phone,password,role_id,name,address,email) VALUES(#{phone},#{password},#{role_id},#{name},#{address},#{email})")
    boolean addUser(User user);
    @Select("SELECT phonne,name,role_id,address,email FROM User")
    User findAll();
    @Select("SELECT phonne,name,role_id,address,email FROM User WHERE user_id =#{user_id}")
    User findOne(@Param("user_id") int user_id);
    @Delete("DELECT FROM User WHERE user_id =#{user_id}")
    boolean delete(@Param("user_id") int user_id);
    @Update("UPDATE User set phone=#{phone},password=#{password},role_id=#{role_id},name=#{name},address=#{address},email=#{email} WHERE user_id =#{user_id}")
    boolean update(@Param("user_id") int user_id,@Param("phone") String phone,@Param("password") String password,@Param("role_id") int role_id,@Param("name") String name,@Param("address") String address,@Param("email") String email);
    @Update("UPDATE User set img=#{img} WHERE user_id =#{user_id}")
    boolean setImg(@Param("user_id")int user_id,@Param("img")String img);

}
