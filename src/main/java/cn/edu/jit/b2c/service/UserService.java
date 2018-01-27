package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.util.MSG;
import com.aliyuncs.exceptions.ClientException;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    MSG login(String phone, String password, HttpServletRequest request);

    MSG getUserInfo(HttpServletRequest request);

    MSG sendVericode(String phone) throws ClientException;

    MSG userFindAll();

    MSG userFindOne(int user_id);

    MSG  userDelete(int user_id);

    MSG  userUpdate(int user_id,String name, String address, String email);

    MSG userImgUpdate(int user_id, String img);

    MSG register(User user, String message);
}
