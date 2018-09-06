package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.UserMapper;
import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.service.UserService;
import cn.edu.jit.b2c.util.MD5Util;
import cn.edu.jit.b2c.util.MSG;
import cn.edu.jit.b2c.util.SmsDemo;
import org.apache.ibatis.jdbc.Null;
import cn.edu.jit.b2c.util.MSG;
import cn.edu.jit.b2c.util.SmsDemo;
import com.aliyuncs.exceptions.ClientException;
import org.hibernate.validator.constraints.ModCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

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
    public MSG login(String phone, String password, HttpServletRequest request) {

        User user = userMapper.findPhone(phone);
        System.out.println(user.getPassword());
//        System.out.println(password);
        System.out.println(MD5Util.string2MD5(password));
//        System.out.println(MD5Util.convertMD5(MD5Util.convertMD5(password)));
//        System.out.println(MD5Util.convertMD5(MD5Util.convertMD5(user.getPassword())));
//        System.out.println(MD5Util.string2MD5(user.getPassword()));
        if(user == null){
            return new MSG(-1,"该用户不存在");
        }
        else if (!user.getPassword().equals(MD5Util.string2MD5(password))){
            return new MSG(-1,"密码错误");
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("admin_now",phone);
            session.setAttribute("user_id",user.getUser_id());
            ArrayList userInfo = new ArrayList();
            userInfo.add(user.getUser_id());
            userInfo.add(user.getRole_id());
            return new MSG(1,"登陆成功",userInfo);
        }
    }

    /**
     * Created by Mr.Chen
     * 获取用户信息
     */
    @Override
    public MSG getUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object phoneSession = session.getAttribute("admin_now");
        if(phoneSession == null)
            return new MSG(-1,"failed");
        User userInfo = userMapper.findPhone(phoneSession.toString());
        userInfo.setPassword(null);
        return new MSG(1,"success",userInfo);
    }

    /**
     * Created by Mr.Chen
     * 发送验证码
     */
    @Override
    public MSG sendVericode(String phone) throws ClientException {
        code = vericode.sendSms(phone);
        return new MSG(1,"成功",code);
    }

    /**
     * Created by SunFuRong
     * 注册功能
     * 输入phone,password,role_id, name,address,email信息
     */

    @Override
    public MSG register(User user, String message) {
        //判断用户是否存在
        if (user == null || user.getPhone() == null || user.getPassword() == null || user.getPhone().isEmpty() || user.getPassword().isEmpty()) {
            return new MSG(-1, "用户名或密码不能为空");
        } else {
            if (userMapper.findPhone(user.getPhone()) != null)
                return new MSG(-1, "用户已存在，请更换用户名");
            else {
                if(code.equals(message)) {
                    user.setPassword(MD5Util.string2MD5(user.getPassword()));
                    userMapper.addUser(user);
                    return new MSG(1, "注册成功");
                }
                else{
                    return new MSG(-1,"验证码错误");
                }

            }
        }
    }

    /**
     * Created by Mr.Chen
     * 退出登录状态
     */
    @Override
    public MSG loginOut(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("admin_now"));
        request.getSession().invalidate();
        System.out.println(request.getSession().getAttribute("admin_now"));
        return new MSG(1,"成功退出");
    }

    /**
     * Created by SunFuRong
     * 查看所有用户信息
     * 信息：phone,role_id, name,address,email
     */

    @Override
    public MSG userFindAll(){
        List<User> userAll =userMapper.findAll();
        return new MSG(1,"查询成功",userAll);
    }

    /**
     * Created by SunFuRong
     * 调出指定用户信息
     * 信息：phone,role_id, name,address,email
     */

    @Override
    public MSG userFindOne(int user_id){
        User userOne=userMapper.findOne(user_id);
        return new MSG(1,"查询成功",userOne);
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
    public MSG userUpdate(int user_id,String name, String phone, String address, String email){
        boolean result;
        result=userMapper.update(user_id,name,phone,address, email);
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
