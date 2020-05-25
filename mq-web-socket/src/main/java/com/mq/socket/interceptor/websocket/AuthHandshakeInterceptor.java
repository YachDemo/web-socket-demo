package com.mq.socket.interceptor.websocket;

import com.mq.socket.common.Constants;
import com.mq.socket.common.SpringContextUtils;
import com.mq.socket.model.User;
import com.mq.socket.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.Map;

/**
 * 自定义{@link org.springframework.web.socket.server.HandshakeInterceptor}，实现“需要登录才允许连接WebSocket”
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-25 10:55
 **/
@Component
@Slf4j
public class AuthHandshakeInterceptor implements HandshakeInterceptor {
    @Resource(name = "redisServiceImpl")
    RedisService redisService;

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        HttpSession session = SpringContextUtils.getSession();
        User loginUser = (User) session.getAttribute(Constants.SESSION_USER);
        if (loginUser == null || StringUtils.isBlank(loginUser.getUsername())) {
            log.error("未登录系统，禁止连接WebSocket");
            return false;
        } else if (redisService.isSetMember(Constants.REDIS_WEBSOCKET_USER_SET, loginUser.getUsername())) {
            log.error("同一个用户不准建立多个连接WebSocket");
            return false;
        }else {
            log.debug(MessageFormat.format("用户{0}请求建立WebSocket连接", loginUser.getUsername()));
            return true;
        }
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
