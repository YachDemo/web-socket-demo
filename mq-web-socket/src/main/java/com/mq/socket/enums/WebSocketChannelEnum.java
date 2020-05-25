package com.mq.socket.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-08 11:28
 **/
public enum WebSocketChannelEnum {
    // 测试使用点对点聊天
    CHAT("CHAT", "测试使用的简易点对点聊天", "/topic/reply");

    /**
     * code
     */
    private String code;

    /**
     * 说明
     */
    private String desc;

    /**
     * 客户端订阅的url
     */
    private String subscribeUrl;

    WebSocketChannelEnum(String code, String desc, String subscribeUrl) {
        this.code = code;
        this.desc = desc;
        this.subscribeUrl = subscribeUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSubscribeUrl() {
        return subscribeUrl;
    }

    public void setSubscribeUrl(String subscribeUrl) {
        this.subscribeUrl = subscribeUrl;
    }

    public static WebSocketChannelEnum fromCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            for (WebSocketChannelEnum channelEnum : values()) {
                if (channelEnum.code.equals(code)) {
                    return channelEnum;
                }
            }
        }
        return null;
    }
}
