package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.User;
import cn.edu.jit.b2c.service.UserService;
import cn.edu.jit.b2c.util.MSG;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.edu.jit.b2c.util.MD5Util.getMD5;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService iUserService;

    @RequestMapping("init")
    public MSG init() {
        System.out.println("server init");
        return new MSG(1, "server init", "data");
    }



    /**
     * Created by SunFuRong
     * 登陆功能
     * 输入phone,password
     */

    @PostMapping("/login")
    //@RequestMapping(value="login", method = RequestMethod.POST)
    public MSG login(@RequestParam String phone, @RequestParam String password) throws IOException{
        password = getMD5(password);
        return iUserService.login(phone,password);
}

    /**
     * Created by SunFuRong
     * 注册功能
     * 输入phone,password,role_id, name,address,email,vericode（验证码）信息
     */

    @PostMapping("/register")
    public MSG register(User user, @RequestParam("message") String message) throws IOException{
        user.setPassword(getMD5(user.getPassword()));
        return iUserService.register(user,message);
    }

    /**
     * Created by SunFuRong
     * 发送验证码功能
     * 输入phone信息
     */

    @PostMapping("/sendVericode")
    public MSG sendVericode(@RequestParam("phone") String phone) throws ClientException {
        return iUserService.sendVericode(phone);
    }

//    @PutMapping("/article/img/qiniu")
//    public String uploadImgQiniu(@RequestParam("editormd-image-file") MultipartFile multipartFile) throws IOException {
//        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
//        User currentUser = userService.getCurrentUser();
//        String path = QiniuUtil.uploadImg(inputStream, currentUser.getUsername()+"_"+ Constants.getUUID());
//        return path;
//    }

//    @PutMapping("/article/img/qiniu")
//    public String uploadImgQiniu(@RequestParam("editormd-image-file") MultipartFile multipartFile) throws IOException {
//        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
//        User currentUser = userService.getCurrentUser();
//        String path = QiniuUtil.uploadImg(inputStream,  Constants.getUUID());
//        return path;
//    }



    /**
     * Created by Mr.Chen
     * 上传图片
     */
    @Resource
    public UserService userService;

    @PostMapping("/upload")
    @ResponseBody
    public MSG upload(HttpServletRequest request,
                  HttpServletResponse response, ModelMap model,HttpSession session) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile mFile = multipartRequest.getFile("file");
        //String path = "F:\\img\\";
        String path = request.getSession().getServletContext().getRealPath("/resources/upload");
        String filename = mFile.getOriginalFilename();
        InputStream inputStream = mFile.getInputStream();
        byte[] b = new byte[1048576];
        int length = inputStream.read(b);
        Date date = new Date();
        SimpleDateFormat F = new SimpleDateFormat("yyyyMMddHHmmss");
        String prefix=filename.substring(filename.lastIndexOf("."));
        filename = "123" + F.format(date) + prefix;
        String url =path +"/"+ filename;
        System.out.println(url);
        FileOutputStream outputStream = new FileOutputStream(url);
        outputStream.write(b, 0, length);
        inputStream.close();
        outputStream.close();
        return new MSG(1,"success","url");
    }


    //@GetMapping("/loginOut")

    /**
     * Created by SunFuRong
     * 查看所有用户信息
     * 信息：phone,,role_id, name,address,email
     */

    @GetMapping("/userinfo")//查看所有人的信息
    public MSG userFindAll () throws IOException{
        return iUserService.userFindAll();
    }

    /**
     * Created by SunFuRong
     * 调出指定用户信息（路径上的id）
     * 信息：phone,role_id, name,address,email
     */

    @GetMapping("/userinfo/{user_id}")//调出用户信息
    public MSG userFindOne(@PathVariable("user_id") int user_id) throws IOException {
        return iUserService.userFindOne(user_id);
    }

    /**
     * Created by SunFuRong
     * 删除指定用户信息（路径上的id）
     */

    @DeleteMapping("/userinfo/{user_id}")//删除用户
    public MSG userDelete(@PathVariable("user_id") int user_id) throws IOException{
        return iUserService.userDelete(user_id);
    }

    /**
     * Created by SunFuRong
     * 修改指定用户信息（不包含头像）
     * 信息phone,password,role_id, name,address,email
     */

    @PutMapping("/userinfo/{user_id}")//修改信息，不包括头像
    public MSG userUpdate(@PathVariable("user_id") int user_id, @RequestParam("phone")String phone, @RequestParam("password") String password, @RequestParam ("role_id")int role_id, @RequestParam ("name")String name, @RequestParam("address") String address, @RequestParam("email") String email) throws IOException{
        password = getMD5(password);
        return iUserService.userUpdate(user_id, phone,password,role_id, name,address,email);
    }

    /**
     * Created by SunFuRong
     * 修改指定用户信息（头像）
     * 信息：img
     */

    @PutMapping("/userimg/{user_id}")//修改头像
    public MSG userImgUpdate(@PathVariable("user_id") int user_id,@RequestParam("img")String img) throws IOException{
        return iUserService.userImgUpdate(user_id,img);
    }


}
