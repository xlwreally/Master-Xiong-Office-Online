package com.xlw.oa.controller.safty;

import com.xlw.oa.base.CurrUser;
import com.xlw.oa.dto.Menu;

import com.xlw.oa.dto.Result;
import com.xlw.oa.service.safty.impl.HomeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/4 16:20
 */
@RestController
@RequestMapping("/safty/home")
public class HomeController {
    @Autowired
    private HomeServiceImpl homeService;

    @RequestMapping("/menus")
    public List<Menu> menuList(HttpSession session) {
        CurrUser m = (CurrUser) session.getAttribute("CurrUser");
        return homeService.getMenu(m.getUserId());
    }

    @RequestMapping("/curruser")
    public CurrUser currUser(HttpSession session) {
        return (CurrUser) session.getAttribute("CurrUser");
    }

    @RequestMapping("/logout")
    public Result logout(HttpSession session) {
        session.removeAttribute("CurrUser");//清除session中的用户信息
        return new Result(true, "您已退出系统！");
    }


}