package com.lill.study.contrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/9/11 18:53
 * @description 测试类
 */
@RestController
public class TestController {
    @RequestMapping("/index")
//    @ResponseBody
    public String index() {
        return "test";
    }
}
