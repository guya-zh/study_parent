package com.lill.study.mapper;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.event.EventPublisher;
import com.lill.study.filter.LogFilter;
import com.lill.study.target.CtrlLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author guya
 * @project Study
 * @date 2018/11/18 16:14
 * @description 描述当前类的用途
 */
@CtrlLog(moduleType = ConstantEnums.ModuleType.TEST_M)
@Service
public class TestLog {
    final static Logger logger = LogManager.getLogger(TestLog.class);
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private EventPublisher eventPublisher;
    @CtrlLog(description = "全查询")
    public String findAll(){
        return "123456";
    }

    @CtrlLog(description = "查询")
    public String find(){
        eventPublisher.publihEvent("find123456");
        ValueOperations<String, String> operations=redisTemplate.opsForValue();
        logger.info(operations.get("test"));
        operations.set("test", "test");
        return "123456";
    }


}
