package com.mq.socket.enums;

import java.util.concurrent.TimeUnit;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-08 12:27
 **/
public enum ExpireEnum {
    //未读消息的有效期为30天
    UNREAD_MSG(30L, TimeUnit.DAYS)
    ;

    /**
     * 过期时间
     */
    private Long time;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

    ExpireEnum(Long time, TimeUnit timeUnit) {
        this.time = time;
        this.timeUnit = timeUnit;
    }

    public Long getTime() {
        return time;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
