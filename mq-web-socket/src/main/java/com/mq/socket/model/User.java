package com.mq.socket.model;

import lombok.Data;

import java.util.Date;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-05-25 10:59
 **/
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Integer status;
}
