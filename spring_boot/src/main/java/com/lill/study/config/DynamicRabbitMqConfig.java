package com.lill.study.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/27 18:16
 * @description RabbitMq 配置类
 */
@Configuration
public class DynamicRabbitMqConfig {

    @Bean(name = "firstConnectionFactory")
    @Primary
    public ConnectionFactory firstConnectionFactory(@Value("${spring.rabbitmq.host}") String host,
                                                    @Value("${spring.rabbitmq.port}") int port,
                                                    @Value("${spring.rabbitmq.username}") String username,
                                                    @Value("${spring.rabbitmq.password}") String password,
                                                    @Value("${spring.rabbitmq.virtual-host}") String virtualHost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    @Bean(name = "secondConnectionFactory")
    public ConnectionFactory secondConnectionFactory(@Value("${spring.rabbitmq.host}") String host,
                                                     @Value("${spring.rabbitmq.port}") int port,
                                                     @Value("${spring.rabbitmq.username}") String username,
                                                     @Value("${spring.rabbitmq.password}") String password,
                                                     @Value("${spring.rabbitmq.virtual-host}") String virtualHost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    @Bean(name = "firstRabbitTemplate")
    @Primary
    public RabbitTemplate firstRabbitTemplate(
            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
    ) {
        RabbitTemplate firstRabbitTemplate = new RabbitTemplate(connectionFactory);
        return firstRabbitTemplate;
    }

    @Bean(name = "secondRabbitTemplate")
    public RabbitTemplate secondRabbitTemplate(
            @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory
    ) {
        RabbitTemplate secondRabbitTemplate = new RabbitTemplate(connectionFactory);
        return secondRabbitTemplate;
    }

    @Bean(name = "secondRabbitAdmin")
    public RabbitAdmin secondRabbitAdmin(
            @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory
    ) {
        return new RabbitAdmin(connectionFactory);
    }


    @Bean(name = "firstFactory")
    public SimpleRabbitListenerContainerFactory firstFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean(name = "secondFactory")
    public SimpleRabbitListenerContainerFactory secondFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        /*1 公平调度（谁空闲调谁），0 轮循调度*/
        factory.setPrefetchCount(1);
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean(name = "secondMessageListener")
    public SimpleMessageListenerContainer container(@Qualifier("secondConnectionFactory")ConnectionFactory connectionFactory){
        return new SimpleMessageListenerContainer(connectionFactory);
    }

}
