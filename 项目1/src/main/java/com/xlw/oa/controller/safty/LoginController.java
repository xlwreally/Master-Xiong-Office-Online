package com.xlw.oa.controller.safty;

import com.xlw.oa.base.CurrUser;
import com.xlw.oa.dto.Result;
import com.xlw.oa.service.safty.LoginService;
import com.xlw.oa.service.safty.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/2 20:32
 */
@RestController
@RequestMapping("safty/login")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping("/login")
    public Result exectLogin(String userId, String userPwd, HttpSession session) {
        if (loginService.check(userId, userPwd)) {
            session.setAttribute("CurrUser", new CurrUser(userId, null));
            return new Result(true, "登陆成功,欢迎使用");
        } else {
            return new Result(false, "用户名或密码错误");
        }

    }
}
