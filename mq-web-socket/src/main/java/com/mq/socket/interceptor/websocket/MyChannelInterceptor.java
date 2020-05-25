package com.mq.socket.interceptor.websocket;

import com.mq.socket.common.Constants;
import com.mq.socket.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * 自定义{@link org.springframework.messaging.support.ChannelInterceptor}，实现断开连接的处理
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-25 11:04
 **/
@Component
@Slf4j
public class MyChannelInterceptor implements ChannelInterceptor {
    @Resource(name = "redisServiceImpl")
    RedisService redisService;

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        StompCommand command = accessor.getCommand();

        if (StompCommand.DISCONNECT.equals(command)) {
            String user;
            Principal principal = accessor.getUser();
            if (principal != null && StringUtils.isNoneBlank(principal.getName())) {
                user = principal.getName();

                // 从redis中移出用户
                redisService.removeFromSet(Constants.REDIS_WEBSOCKET_USER_SET, user);
            }else {
                user = accessor.getSessionId();
            }
            log.debug("用户{}的WebSocket连接已经断开", user);
        }

    }
}
