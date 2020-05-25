package com.mq.socket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-08 12:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisWebsocketMsg<T> {
    /**
     * 消息接收者的username
     */
    private String receiver;
    /**
     * 消息对应的订阅频道的CODE，参考{@link com.mq.socket.enums.WebSocketChannelEnum}的code字段
     */
    private String channelCode;
    /**
     * 消息正文
     */
    private T content;
}
