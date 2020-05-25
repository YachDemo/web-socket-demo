package com.mq.socket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mq.socket"})
@MapperScan(basePackages = {"com.mq.socket.mapper"})
public class MqWebSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqWebSocketApplication.class, args);
    }

}
