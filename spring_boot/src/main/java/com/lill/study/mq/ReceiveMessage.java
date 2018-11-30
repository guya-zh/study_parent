package com.lill.study.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/27 18:17
 * @description 接收消息 消费消息
 */
@Component
public class ReceiveMessage {
    @Autowired
    @Qualifier("secondMessageListener")
    private SimpleMessageListenerContainer secondMessageListener;
    @Autowired
    @Qualifier("secondRabbitTemplate")
    private RabbitTemplate secondRabbitTemplate;

    @Component
    @RabbitListener(queues = "hello")
    public class HelloReceiver {
        @RabbitHandler
        public void process(String hello) {
            System.out.println("Receiver  : " + hello);
        }
    }

    /*动态创建消息监听*/
    public void receive(String name) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new ReceiveMessage());
        messageListenerAdapter.addQueueOrTagToMethodName(name, "process");
        secondMessageListener.addQueueNames(name);
        secondMessageListener.setMessageListener(messageListenerAdapter);
    }


}
