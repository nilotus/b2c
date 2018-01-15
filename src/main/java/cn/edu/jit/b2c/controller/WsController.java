package cn.edu.jit.b2c.controller;

import cn.edu.jit.b2c.pojo.WiselyMessage;
import cn.edu.jit.b2c.pojo.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by ChenQF on 2018/1/12.
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("欢迎使用WebSocket:"+message.getName());
    }

}
