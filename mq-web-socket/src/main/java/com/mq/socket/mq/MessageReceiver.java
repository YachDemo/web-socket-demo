package com.mq.socket.mq;

import com.mq.socket.enums.WebSocketChannelEnum;
import com.mq.socket.model.RedisWebsocketMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Redis中的WebSocket消息处理者
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-08 12:02
 **/
@Component
@Slf4j
public class MessageReceiver {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    SimpUserRegistry simpUserRegistry;

    public void receiveMessage(RedisWebsocketMsg redisWebsocketMsg) {
        log.info(MessageFormat.format("Received Message: {0}", redisWebsocketMsg));
        // 1.取出用户名并判断是否连接当前应用节点的websocket
        SimpUser simpUser = simpUserRegistry.getUser(redisWebsocketMsg.getReceiver());

        if (simpUser != null && StringUtils.isNoneBlank(simpUser.getName())) {
            // 获取websocket客户端订阅地址
            WebSocketChannelEnum channelEnum = WebSocketChannelEnum.fromCode(redisWebsocketMsg.getChannelCode());

            if (channelEnum != null) {
                simpMessagingTemplate.convertAndSendToUser(redisWebsocketMsg.getReceiver(), channelEnum.getSubscribeUrl(), redisWebsocketMsg.getContent());
            }
        }
    }
}
