package com.lill.study.config;

import io.lettuce.core.dynamic.annotation.Value;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/20 14:46
 * @description 描述当前类的用途
 */
@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)/*默认1800s */
@EnableRedisHttpSession
public class SessionConfig {
    /*session 过期时间动态设置*/
//    @Value("${server.session.timeout}")
//    private int sessionTimeout = 1800;

}
