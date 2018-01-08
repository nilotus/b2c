package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM User WHERE phone =#{phone}")
    User findPhone(@Param("phone") String phone);
    @Insert("INSERT INTO User(phone,password,role_id,name,address,email) VALUES(#{phone},#{password},#{role_id},#{name},#{address},#{email})")
    boolean setPhone(User user);
    @Select("SELECT * FROM User WHERE phone =#{phone}")
    User findAll();
    @Select("SELECT phonne,name,role_id,address,email FROM User WHERE user_id =#{user_id}")
    User findOne(int user_id);
    @Delete("DELECT FROM User WHERE user_id =#{user_id}")
    void delete(int user_id);
    @Update("UPDATE User set phone=#{phone},password=#{password},role_id=#{role_id},name=#{name},address=#{address},email=#{email} WHERE user_id =#{user_id}")
    boolean update(int user_id, String phone, String password, int role_id, String name, String address, String email);
    @Update("UPDATE User set img=#{img} WHERE user_id =#{user_id}")
    boolean setImg(int user_id,String img);

}
