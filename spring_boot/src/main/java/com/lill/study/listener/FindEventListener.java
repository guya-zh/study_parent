package com.lill.study.listener;

import com.lill.study.event.FindEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author guya
 * @project Study
 * @date 2018/11/18 16:45
 * @description 事件监听
 */
@Component
public class FindEventListener implements ApplicationListener<FindEvent> {

    @Override
    public void onApplicationEvent(FindEvent findEvent) {
        try {
            Thread.sleep(5000);
            System.out.println("监听到事件：" + findEvent.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
