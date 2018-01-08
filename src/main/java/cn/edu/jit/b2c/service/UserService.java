package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.User;

/**
 * Created by ChenQF on 2018/1/5.
 */
public interface UserService {
    String login(String phone, String password);
    String register(User user);

}
