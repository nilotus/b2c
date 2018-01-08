package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService iUserService;

    /**
     * Created by SunFuRong
     * 登陆功能
     */

    @PostMapping("/login")
    //@RequestMapping(value="login", method = RequestMethod.POST)
    public String login(@RequestParam String phone, @RequestParam String password) throws IOException{
        return iUserService.login(phone,password);
    }

    /**
     * Created by SunFuRong
     * 注册功能
     */

    @PostMapping("/register")
    public String register(User user) throws IOException{
        return iUserService.register(user);
    }

    //@GetMapping("/loginOut")

    /**
     * Created by SunFuRong
     * 查看所有用户信息
     */

    @GetMapping("/userinfo")//查看所有人的信息
    public User userFindAll () throws IOException{
        return iUserService.userFindAll();
    }

    /**
            * Created by SunFuRong
     * 调出指定用户信息
     */

    @GetMapping("/userinfo/{user_id}")//调出用户信息
    public User userFindOne(@PathVariable("user_id") int user_id) throws IOException {
        return iUserService.userFindOne(user_id);
    }

    /**
     * Created by SunFuRong
     * 删除指定用户信息
     */

    @DeleteMapping("/userinfo/{user_id}")//删除用户
    public void userDelete(@PathVariable("user_id") int user_id) throws IOException{
        iUserService.userDelete(user_id);
    }

    /**
     * Created by SunFuRong
     * 修改指定用户信息（不包含头像）
     */

    @PutMapping("/userinfo/{user_id}")//修改信息，不包括头像
    public String userUpdate(@PathVariable("user_id") int user_id,@RequestParam String phone, @RequestParam String password, @RequestParam int role_id,@RequestParam String name,@RequestParam String address,@RequestParam String email) throws IOException{

        return userUpdate(user_id, phone,password,role_id, name,address,email);
    }

    /**
     * Created by SunFuRong
     * 修改指定用户信息（头像）
     */

    @PutMapping("/userimg/{user_id}")//修改头像
    public String userImgUpdate(@PathVariable("user_id") int user_id,@RequestParam String img) throws IOException{
        return userImgUpdate(user_id,img);
    }


}
