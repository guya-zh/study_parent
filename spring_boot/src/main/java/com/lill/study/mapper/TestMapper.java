package com.lill.study.mapper;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.target.CtrlLog;
import org.springframework.stereotype.Repository;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/9/11 19:23
 * @description 描述当前类的用途
 */
@CtrlLog(moduleType = ConstantEnums.ModuleType.TEST_M)
@Repository
public interface TestMapper {
    @CtrlLog(description = "全查询")
    public String findAll();
}
