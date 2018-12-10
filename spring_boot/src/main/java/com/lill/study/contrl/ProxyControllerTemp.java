package com.lill.study.contrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/12/5 11:13
 * @description 描述当前类的用途
 */
@Controller
public class ProxyControllerTemp {
    @RequestMapping("/proxy")
    public String demo(HttpServletRequest httpRequest) {
        Map<String, String[]> map = httpRequest.getParameterMap();
        return "123456";
    }
}
