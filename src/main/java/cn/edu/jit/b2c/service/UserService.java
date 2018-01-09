package cn.edu.jit.b2c.service;

import cn.edu.jit.b2c.pojo.User;
import com.aliyuncs.exceptions.ClientException;

public interface UserService {
    String login(String phone, String password);

    String register(User user,String vericode);

    String sendVericode(String phone) throws ClientException;

    public User userFindAll();

    public User userFindOne(int user_id);

    public void userDelete(int user_id);

    public String userUpdate(int user_id, String phone, String password, int role_id, String name, String address, String email);

    public String userImgUpdate(int user_id, String img);
}
