package com.baker.learning.learnwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.time.LocalDateTime;

/**
 * @description
 * @date 2020/1/5 15:18
 */

@Controller
@EnableScheduling
public class TestController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 方式一、前端发消息过来，经过处理，再回过去
     *
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
//    “/topic/greetings”会被UserDestinationMessageHandler转化成”/user/role1/topic/greetings”,role1是用户的登录帐号，
//    这样子就把消息唯一的推送到请求者的订阅路径中去，这时候，如果一个帐号打开了多个浏览器窗口，也就是打开了多个websocket session通道，这时，
//    spring webscoket默认会把消息推送到同一个帐号不同的session，你可以利用broadcast = false把避免推送到所有的session中
//    @SendToUser(value = "/topic/greetings",broadcast = false)
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("controller：" + message);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    /**
     * 方式二、后端主动推消息给前端
     *
     * @return
     */
    @Scheduled(fixedRate = 3000)
    public void send() {
        LocalDateTime localDateTime = LocalDateTime.now();
        messagingTemplate.convertAndSend("/topic/greetings", new Greeting(localDateTime.toString()));
    }

    /**
     * 方式三、后端主动推送消息给前端--推送到指定用户
     */
    @Scheduled(fixedRate = 3000)
    public void sendForUser() {
        LocalDateTime localDateTime = LocalDateTime.now();
        //这里虽然没有指定发送前缀为/userTest，但是在WebsocketConfig.java中设置了config.setUserDestinationPrefix("/userTest")，
        //否则默认为/user
        messagingTemplate.convertAndSendToUser("baker", "/test", new Greeting(localDateTime.toString()));
    }
}
