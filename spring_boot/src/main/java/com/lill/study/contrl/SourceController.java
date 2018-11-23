package com.lill.study.contrl;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.domain.po.TestPo;
import com.lill.study.domain.vo.TestVo;
import com.lill.study.mapper.TestLog;
import com.lill.study.mapper.read.TestRMapper;
import com.lill.study.mapper.write.TestWMapper;
import com.lill.study.srv.TestSrv;
import com.lill.study.target.CtrlLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限o公司
 * @date 2018/9/11 18:53
 * @description 测试类
 */
@CtrlLog(moduleType = ConstantEnums.ModuleType.TEST_M)
@RestController
@RequestMapping("/s")
public class SourceController {
    @Autowired
    private TestWMapper testWMapper;
    @Autowired
    private TestRMapper testRMapper;


    @CtrlLog(description = "写入方法")
    @RequestMapping("/w")
//    @ResponseBody
    public List<TestPo> w() {
        return testWMapper.findAll();
    }

    @CtrlLog(description = "读取方法")
    @RequestMapping("/r")
//    @ResponseBody
    public List<TestPo> r() {
        return testRMapper.findAll();
    }

}
