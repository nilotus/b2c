package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.UserMapper;
import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ChenQF on 2018/1/5.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String phone, String password) {
        User user = userMapper.findPhone(phone);

        if(user.getPassword().equals(password)&&user.getPhone().equals(phone)) {
            return new String("1");
        } else{
            return new String("0");
        }
    }


}
