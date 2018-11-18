package com.lill.study.contrl;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.constant.ConstantEnumsBak;
import com.lill.study.mapper.TestLog;
import com.lill.study.mapper.TestMapper;
import com.lill.study.target.CtrlLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限o公司
 * @date 2018/9/11 18:53
 * @description 测试类
 */
@CtrlLog(moduleType = ConstantEnums.ModuleType.TEST_M)
@RestController
public class TestController {
    @Autowired
    private TestLog testLog;

    @CtrlLog(description = "index方法")
    @RequestMapping("/index")
//    @ResponseBody
    public String index() {
        return testLog.find();
    }
}
