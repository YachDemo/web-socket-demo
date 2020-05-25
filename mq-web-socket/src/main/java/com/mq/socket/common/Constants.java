package com.mq.socket.common;

/**
 * 公共常量类
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-25 10:40
 **/
public class Constants {

    /**
     * 用户在session中存储的变量名
     */
    public static final String SESSION_USER = "SESSION_USER";

    /**
     * 登录页面的回调地址在session中存储的变量名
     */
    public static final String SESSION_LOGIN_REDIRECT_URL = "LOGIN_REDIRECT_URL";

    /**
     * 用户未读的WebSocket消息在redis中存储的变量名前缀
     */
    public static final String REDIS_UNREAD_MSG_PREFIX = "mq-websocket:unread_msg:";

    /**
     * 已经建立连接的WebSocket用户在Redis中存储的SET的KEY值
     */
    public static final String REDIS_WEBSOCKET_USER_SET = "mq-websocket:websocket_user_set";
}
