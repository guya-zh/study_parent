package com.lill.study.event;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationEvent;

/**
 * @author guya
 * @project Study
 * @date 2018/11/18 16:46
 * @description 事件
 */

public class FindEvent extends ApplicationEvent {
    private String msg;

    public FindEvent(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
