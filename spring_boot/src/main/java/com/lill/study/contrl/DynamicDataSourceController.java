package com.lill.study.contrl;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.domain.po.TestPo;
import com.lill.study.mapper.read.TestRMapper;
import com.lill.study.mapper.write.TestWMapper;
import com.lill.study.target.CtrlLog;
import com.lill.study.target.ReadDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限o公司
 * @date 2018/9/11 18:53
 * @description 测试类
 */
@CtrlLog(moduleType = ConstantEnums.ModuleType.TEST_M)
@RestController
@RequestMapping("/d")
public class DynamicDataSourceController {
    @Autowired
    private TestWMapper testWMapper;


    @CtrlLog(description = "写入方法")
    @RequestMapping("/w")
//    @ResponseBody
    public List<TestPo> w() {
        return testWMapper.find();
    }

    @ReadDataSource
    @CtrlLog(description = "读取方法")
    @RequestMapping("/r")
//    @ResponseBody
    public List<TestPo> r() {
        return testWMapper.findAll();
    }

}
