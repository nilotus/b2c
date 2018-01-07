package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by ChenQF on 2018/1/5.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService iUserService;

    //@PostMapping("/login")
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String login(@RequestParam String phone, @RequestParam String password) throws IOException{
        return iUserService.login(phone,password);
    }
}
