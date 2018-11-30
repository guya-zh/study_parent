package com.lill.study.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/27 18:16
 * @description RabbitMq 配置类
 */
@Configuration
public class SimpleRabbitMqConfig {
    @Bean
    public Queue Queue() {
        Queue queue = new Queue("hello");
        return queue;
    }
}
