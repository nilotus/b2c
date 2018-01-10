package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.util.MSG;
import com.aliyuncs.exceptions.ClientException;
import cn.edu.jit.b2c.util.MSG;

public interface UserService {
    MSG login(String phone, String password);

    MSG sendVericode(String phone) throws ClientException;

    User userFindAll();

    User userFindOne(int user_id);

    MSG  userDelete(int user_id);

    MSG  userUpdate(int user_id, String phone, String password, int role_id, String name, String address, String email);

    MSG userImgUpdate(int user_id, String img);

    MSG register(User user, String message);
}
