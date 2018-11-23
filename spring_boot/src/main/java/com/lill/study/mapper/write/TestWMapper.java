package com.lill.study.mapper.write;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.domain.po.TestPo;
import com.lill.study.target.CtrlLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/9/11 19:23
 * @description 描述当前类的用途
 */
@CtrlLog(moduleType = ConstantEnums.ModuleType.TEST_M)
@Repository("writeTestRMapper")
public interface TestWMapper {
    @CtrlLog(description = "全查询")
    public List<TestPo> findAll();
}
