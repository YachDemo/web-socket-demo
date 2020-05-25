package com.mq.socket.controller;

import com.mq.socket.enums.WebSocketChannelEnum;
import com.mq.socket.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring5.context.SpringContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-08 12:24
 **/
@RestController
@RequestMapping("/wsTemplate")
@Slf4j
public class RedisMessageController {

    @Value("${spring.redis.message.topic-name}")
    private String topicName;

    @Autowired
    RedisService redisService;


    @PostMapping("/sendToUser")
    public String chat(HttpServletRequest request) {
//        //消息接收者
//        String receiver = request.getParameter("receiver");
//        //消息内容
//        String msg = request.getParameter("msg");
//        HttpSession session = SpringContextUtils.getSession();
//        User loginUser = (User) session.getAttribute(Constants.SESSION_USER);
//
//        HelloMessage resultData = new HelloMessage(MessageFormat.format("{0} say: {1}", loginUser.getUsername(), msg));
//        this.sendToUser(loginUser.getUsername(), receiver, WebSocketChannelEnum.CHAT.getSubscribeUrl(), JsonUtils.toJson(resultData));
//
//        return "ok";
        return null;
    }
}
