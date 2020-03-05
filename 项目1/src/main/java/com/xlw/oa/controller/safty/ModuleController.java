package com.xlw.oa.controller.safty;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/5 20:01
 */

import java.util.List;

import com.xlw.oa.dto.Menu;
import com.xlw.oa.dto.Result;
import com.xlw.oa.model.TModule;
import com.xlw.oa.model.User;
import com.xlw.oa.service.safty.impl.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/safty/module")
public class ModuleController {

    @Autowired
    private ModuleServiceImpl moduleService;

    @RequestMapping("/users")
    public List<User> users() {
        return moduleService.getUserList();
    }

    //获得所有权限菜单
    @RequestMapping("/all")
    public List<Menu> allMenus() {
        return moduleService.getAllMenuList();
    }

    //获得用户的权限编号
    @RequestMapping("/userModIds")
    public List<Integer> userModIds(String u_id) {
        return moduleService.getUserModIds(u_id);
    }


    //确认修改新权限
    @RequestMapping("/confirm")
    public Result confirmUserModule(String u_id, Integer[] modIds) {
        moduleService.confirmUserModule(u_id, modIds);
        return new Result(true, "权限已成功变更！");
    }

}

