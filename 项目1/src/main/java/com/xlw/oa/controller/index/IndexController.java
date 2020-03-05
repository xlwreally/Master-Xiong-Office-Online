package com.xlw.oa.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/4 16:26
 */

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "forward:safty/login/index.html";
    }
}

