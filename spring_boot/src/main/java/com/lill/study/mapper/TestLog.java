package com.lill.study.mapper;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.event.EventPublisher;
import com.lill.study.target.CtrlLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guya
 * @project Study
 * @date 2018/11/18 16:14
 * @description 描述当前类的用途
 */
@CtrlLog(moduleType = ConstantEnums.ModuleType.TEST_M)
@Service
public class TestLog {
    @Autowired
    private EventPublisher eventPublisher;
    @CtrlLog(description = "全查询")
    public String findAll(){
        return "123456";
    }

    @CtrlLog(description = "查询")
    public String find(){
        eventPublisher.publihEvent("find123456");
        return "123456";
    }


}
