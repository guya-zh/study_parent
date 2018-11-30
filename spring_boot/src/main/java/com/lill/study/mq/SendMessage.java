package com.lill.study.mq;

import com.lill.study.mapper.TestLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/27 18:17
 * @description 发送消息  一个消息队列可以
 */
@Component
public class SendMessage {
    final static Logger logger = LogManager.getLogger(TestLog.class);
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    @Qualifier("secondRabbitTemplate")
    private RabbitTemplate secondRabbitTemplate;
    @Autowired
    @Qualifier("secondRabbitAdmin")
    private RabbitAdmin secondRabbitAdmin;


    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    /*自动创建队列*/
    public void send(String name, String message) {
        createQueue(name);
        rabbitTemplate.convertAndSend(name, message);
    }

    /*自动创建队列*/
    public void sendByName(String name, String message) {
        rabbitTemplate.convertAndSend(name, message);
    }

    /*发送带交换机队列*/
    public void sendExchange(String exchangeName, String queueName, String message) {
        TopicExchange topicExchange = createExchange(exchangeName);
        createQueue(queueName);
        secondRabbitTemplate.setExchange(topicExchange.getName());
        secondRabbitTemplate.setRoutingKey(queueName);
        rabbitTemplate.convertAndSend(queueName, message);

    }

    /*发送带交换机队列*/
    public void sendFanoutExchange(String exchangeName, String queueName, String message) {
        FanoutExchange topicExchange = createFanoutExchange(exchangeName);
        Queue queue = createQueue(queueName);
        secondRabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(topicExchange));
        secondRabbitTemplate.setExchange(topicExchange.getName());
        secondRabbitTemplate.setRoutingKey(queueName);
        rabbitTemplate.convertAndSend(queueName, message);

    }

    /*发送交换机*/
    public void sendExchange(String exchangeName, String message) {
//        FanoutExchange topicExchange = createFanoutExchange(exchangeName);
//        secondRabbitTemplate.setExchange(topicExchange.getName());
        rabbitTemplate.convertAndSend(exchangeName, "", message);

    }

    /*删除队列*/
    public void delete(String name) {
        secondRabbitAdmin.deleteQueue(name);
    }

    /*删除队列*/
    public void deleteExchange(String name) {
        secondRabbitAdmin.deleteExchange(name);
    }

    /*动态创建交换机*/
    public TopicExchange createExchange(String name) {
        TopicExchange dataExchange = new TopicExchange(name, true, false);
        secondRabbitAdmin.declareExchange(dataExchange);
        return dataExchange;
    }


    /*动态创建交换机*/
    public FanoutExchange createFanoutExchange(String name) {
        FanoutExchange dataExchange = new FanoutExchange(name, true, false);
        secondRabbitAdmin.declareExchange(dataExchange);
        return dataExchange;
    }

    /*动态创建队列*/
    public Queue createQueue(String name) {
        Queue queue = new Queue(name, true, false, false);
        secondRabbitAdmin.declareQueue(queue);
        return queue;
    }
}
