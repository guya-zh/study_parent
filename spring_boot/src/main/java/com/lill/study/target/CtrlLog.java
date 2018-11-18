package com.lill.study.target;

/**
 * @author guya
 * @project Study
 * @date 2018/9/22 18:01
 * @description 控制器日志注解
 */

import com.lill.study.constant.ConstantEnums;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CtrlLog {
    /**
     * 操作描述
     */
    String description() default "";

    /**
     * 模块类型
     */
    ConstantEnums.ModuleType moduleType() default ConstantEnums.ModuleType.TEST_M;
}
