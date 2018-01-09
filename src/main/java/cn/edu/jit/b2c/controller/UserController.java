package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static cn.edu.jit.b2c.util.MD5Util.getMD5;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService iUserService;

    /**
     * Created by SunFuRong
     * 登陆功能
     * 输入phone,password
     */

    @PostMapping("/login")
    //@RequestMapping(value="login", method = RequestMethod.POST)
    public String login(@RequestParam String phone, @RequestParam String password) throws IOException{
        password = getMD5(password);
        return iUserService.login(phone,password);
}

    /**
     * Created by SunFuRong
     * 注册功能
     * 输入phone,password,role_id, name,address,email信息
     */

    @PostMapping("/register")
    public String register(User user) throws IOException{
        user.setPassword(getMD5(user.getPassword()));
        return iUserService.register(user);
    }

    //@GetMapping("/loginOut")

    /**
     * Created by SunFuRong
     * 查看所有用户信息
     * 信息：phone,,role_id, name,address,email
     */

    @GetMapping("/userinfo")//查看所有人的信息
    public User userFindAll () throws IOException{
        return iUserService.userFindAll();
    }

    /**
     * Created by SunFuRong
     * 调出指定用户信息（路径上的id）
     * 信息：phone,role_id, name,address,email
     */

    @GetMapping("/userinfo/{user_id}")//调出用户信息
    public User userFindOne(@PathVariable("user_id") int user_id) throws IOException {
        return iUserService.userFindOne(user_id);
    }

    /**
     * Created by SunFuRong
     * 删除指定用户信息（路径上的id）
     */

    @DeleteMapping("/userinfo/{user_id}")//删除用户
    public void userDelete(@PathVariable("user_id") int user_id) throws IOException{
        iUserService.userDelete(user_id);
    }

    /**
     * Created by SunFuRong
     * 修改指定用户信息（不包含头像）
     * 信息phone,password,role_id, name,address,email
     */

    @PutMapping("/userinfo/{user_id}")//修改信息，不包括头像
    public String userUpdate(@PathVariable("user_id") int user_id,@RequestParam String phone, @RequestParam String password, @RequestParam int role_id,@RequestParam String name,@RequestParam String address,@RequestParam String email) throws IOException{
        password = getMD5(password);
        return userUpdate(user_id, phone,password,role_id, name,address,email);
    }

    /**
     * Created by SunFuRong
     * 修改指定用户信息（头像）
     * 信息：img
     */

    @PutMapping("/userimg/{user_id}")//修改头像
    public String userImgUpdate(@PathVariable("user_id") int user_id,@RequestParam String img) throws IOException{
        return userImgUpdate(user_id,img);
    }


}
