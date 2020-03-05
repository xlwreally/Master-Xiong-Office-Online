package com.xlw.oa.service.safty.impl;

import com.xlw.oa.dao.safty.ModuleDao;
import com.xlw.oa.dto.Menu;
import com.xlw.oa.model.TModule;
import com.xlw.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/5 20:05
 */
@Service
@Transactional
public class ModuleServiceImpl {
    @Autowired
    private ModuleDao moduleDao;

    public List<User> getUserList() {
        return moduleDao.findAlluser();
    }

    public List<Menu> getAllMenuList() {
        return null;
    }

    public List<Integer> getUserModIds(String u_id) {
        return null;
    }

    public void confirmUserModule(String u_id, Integer[] modIds) {
    }
}
