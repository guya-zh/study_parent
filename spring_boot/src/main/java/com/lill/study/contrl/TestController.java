package com.lill.study.contrl;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.domain.po.TestPo;
import com.lill.study.domain.vo.TestVo;
import com.lill.study.mapper.TestLog;
import com.lill.study.srv.TestSrv;
import com.lill.study.target.CtrlLog;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestController {
    @Autowired
    private TestLog testLog;
    @Autowired
    private TestSrv testSrv;

    @CtrlLog(description = "index方法")
    @RequestMapping("/index")
//    @ResponseBody
    public String index() {
        return testLog.find();
    }

    @RequestMapping("/json")
//    @ResponseBody
    public TestVo json() {
        TestVo testVo = new TestVo();
        testVo.setContent("123456789");
        testVo.setId("test");
        return testVo;
    }


    @RequestMapping("/jpa")
//    @ResponseBody
    public List<TestPo> api() {
        return testSrv.findAll();
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
