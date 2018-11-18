package com.lill.study.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author guya
 * @project Study
 * @date 2018/11/18 16:48
 * @description 事件发布
 */
@Component
public class EventPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publihEvent(String msg) {
        applicationContext.publishEvent(new FindEvent(msg));
    }
}
