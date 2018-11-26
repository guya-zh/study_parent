package com.lill.study.aspect;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.datasourceswitch.DynamicDataSourceHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author guya
 * @project Study
 * @date 2018/9/22 17:44
 * @description 数据源切面
 */
@Aspect
@Component
public class DatasourceAspect {
    final static Logger logger = LogManager.getLogger(DatasourceAspect.class);

    /*注解式拦截*/
    @Pointcut("execution(public * com.lill.study.*.*.*(..)) && @annotation(com.lill.study.target.ReadDataSource)")
    public void dataSoucePointCut() {
    }

    /*注解式拦截*/
    @Around("dataSoucePointCut()")
    public Object dataSoucePrint(ProceedingJoinPoint joinpoint) {
        logger.info("只读");
        try {
            DynamicDataSourceHolder.putDataSource(ConstantEnums.DataSourceType.READ);
            return joinpoint.proceed();
        } catch (Throwable e) {
            logger.error(e.getStackTrace(), e);
        } finally {
            DynamicDataSourceHolder.remove();
        }
        return null;
    }
}
