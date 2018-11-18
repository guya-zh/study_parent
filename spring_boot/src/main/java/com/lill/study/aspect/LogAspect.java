package com.lill.study.aspect;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lill.study.target.CtrlLog;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author guya
 * @project Study
 * @date 2018/9/22 17:44
 * @description 日志切面
 */
@Aspect
@Component
public class LogAspect {
    /*注解式拦截*/
    @Pointcut("execution(public * com.lill.study.*.*.*(..)) && @annotation(com.lill.study.target.CtrlLog)")
    public void logPointCut() {
    }

    /*注解式拦截*/
    @Before("logPointCut()")
    public void logPrint(JoinPoint joinpoint) {
        Method method = ((MethodSignature) joinpoint.getSignature()).getMethod();
        CtrlLog methodlLog = method.getAnnotation(CtrlLog.class);
        System.out.println(methodlLog.moduleType().getName() + methodlLog.description() + new JSONArray(joinpoint.getArgs()).toString());
    }

    /*方法规则拦截*/
    @Before("execution(public * com.lill.study.*.*.*(..))")
    public void testPrint(JoinPoint joinpoint) {
        Method method = ((MethodSignature) joinpoint.getSignature()).getMethod();
        System.out.println(method.getName());
    }
}
