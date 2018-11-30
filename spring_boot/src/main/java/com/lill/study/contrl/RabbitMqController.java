package com.lill.study.contrl;

import com.lill.study.constant.ConstantEnums;
import com.lill.study.mq.ReceiveMessage;
import com.lill.study.mq.SendMessage;
import com.lill.study.target.CtrlLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/27 18:21
 * @description rabbitMq 测试类
 */

@CtrlLog(moduleType = ConstantEnums.ModuleType.TEST_M)
@RestController
public class RabbitMqController {
    @Autowired
    private SendMessage sendMessage;
    @Autowired
    private ReceiveMessage receiveMessage;

    @CtrlLog(description = "rabbit")
    @RequestMapping("/rabbit")
//    @ResponseBody
    public String index() {
        sendMessage.send();
        return "tyuio";
    }

    @CtrlLog(description = "rabbit-auto")
    @RequestMapping("/auto_send")
    public String auto() {
        sendMessage.send("auto", "123456789");
        return "123456789";
    }

    @CtrlLog(description = "rabbit-auto")
    @RequestMapping("/exchange_queue")
    public String auto(String exchange, String name) {
        sendMessage.sendExchange(exchange, name, "123456789");
        return "123456789";
    }

    @CtrlLog(description = "rabbit-auto")
    @RequestMapping("/exchange_fanout")
    public String autoFanout(String exchange, String name) {
        sendMessage.sendFanoutExchange(exchange, name, "123456789");
        return "123456789";
    }

    @CtrlLog(description = "rabbit-auto")
    @RequestMapping("/exchange")
    public String autoExchange(String exchange) {
        sendMessage.sendExchange(exchange, "qwertyuiop");
        return "123456789";
    }


    @CtrlLog(description = "rabbit-auto-recevice")
    @RequestMapping("/auto_recevice")
    public String recevice(String name) {
        receiveMessage.receive(name);
        return "123456789";
    }
    @CtrlLog(description = "rabbit-auto")
    @RequestMapping("/sendByName")
    public String sendByName() {
        sendMessage.sendByName("auto", "123456789");
        return "123456789";
    }

}
