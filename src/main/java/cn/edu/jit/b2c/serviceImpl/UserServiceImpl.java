package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.UserMapper;
import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.service.UserService;
import cn.edu.jit.b2c.util.MSG;
import cn.edu.jit.b2c.util.SmsDemo;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static cn.edu.jit.b2c.util.SmsDemo.sendSms;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private SmsDemo vericode;
    String code;

    /**
     * Created by SunFuRong
     * 登陆功能
     * 输入phone,password
     */

    @Override
    public MSG login(String phone, String password) {
        User user = userMapper.findPhone(phone);
        if(user == null){
            return new MSG(-1,"该用户不存在");
        }
        else if (!user.getPhone().equals(user.getPassword())){
            return new MSG(-1,"密码错误");
        }
        else {
            return new MSG(1,"登陆成功");
        }
    }

    /**
     * Created by SunFuRong
     * 注册功能
     * 输入phone,password,role_id, name,address,email信息
     */

    @Override
    public MSG register(User user,String vericode) {
        //判断验证码是否正确
        if (code.equals(vericode)) {
            //注册
            boolean result;
            result = userMapper.setPhone(user);
            if (result)
                return new MSG(1,"注册成功");
            else
                return new MSG(-1,"注册失败");
        }
        else
            return new MSG(-1,"验证码错误");
    }

    /**
     * Created by SunFuRong
     * 发送验证码功能
     * 输入phone信息
     */

    @Override
    public MSG sendVericode(String phone) throws ClientException {
        //判断用户是否存在
        if(userMapper.findPhone(phone) == null){
            code=vericode.sendSms(phone);
            return new MSG(1,"验证码已发送");
        }
        else {
            return new MSG(-1,"用户已存在");
        }
    }

    /**
     * Created by SunFuRong
     * 查看所有用户信息
     * 信息：phone,role_id, name,address,email
     */

    @Override
    public User userFindAll(){
        return userMapper.findAll();
    }

    /**
     * Created by SunFuRong
     * 调出指定用户信息
     * 信息：phone,role_id, name,address,email
     */

    @Override
    public User userFindOne(int user_id){
        return userMapper.findOne(user_id);
    }

    /**
     * Created by SunFuRong
     * 删除指定用户信息（路径上的id）
     */

    @Override
    public MSG userDelete(int user_id){
        boolean result;
        result=userMapper.delete(user_id);
        if(result)
            return new MSG(1,"删除成功");

        else
            return new MSG(-1,"删除失败");
    }

    /**
     * Created by SunFuRong
     * 修改指定用户信息（不包含头像）
     * 信息phone,password,role_id, name,address,email
     */

    @Override
    public MSG userUpdate(int user_id, String phone, String password, int role_id, String name, String address, String email){
        boolean result;
        result=userMapper.update(user_id,phone,password, role_id, name,address, email);
        if(result)
            return new MSG(1,"修改信息成功");

        else
            return new MSG(-1,"修改信息失败");

    }

    /**
     * Created by SunFuRong
     * 修改指定用户信息（头像）
     * 信息：img
     */

    @Override
    public MSG userImgUpdate(int user_id, String img){
        boolean result;
        result = userMapper.setImg(user_id,img);
        if(result)
            return new MSG(1,"头像更换成功");
        else
            return new MSG(-1,"上传头像失败");
    }


}
