package com.mq.socket.mq.config;

import com.mq.socket.interceptor.websocket.AuthHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * 
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-25 10:50
 **/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig {
    @Autowired
    AuthHandshakeInterceptor authHandshakeInterceptor;
}
