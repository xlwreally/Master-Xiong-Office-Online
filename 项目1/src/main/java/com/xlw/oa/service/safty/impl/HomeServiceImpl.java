package com.xlw.oa.service.safty.impl;

import com.xlw.oa.dao.safty.HomeDao;
import com.xlw.oa.dto.Menu;
import com.xlw.oa.model.TModule;
import com.xlw.oa.service.safty.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/4 16:07
 */
@Service
@Transactional
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homedao;

    public List<Menu> getMenu(String name) {
        List<Menu> menus = new ArrayList<>();
        List<Menu> tmp = null;
        List<TModule> modules = homedao.findMenuList(name);
        for (TModule module : modules
        ) {
            Menu cur = new Menu();
            cur.setId(module.getM_id());
            cur.setName(module.getM_name());
            cur.setUrl(module.getM_url());
            if (null == module.getM_pid()) {
                menus.add(cur);
                cur.setSubList(new ArrayList<>());
            } else {
                while (menus.size() != 0 && !module.getM_pid().equals(menus.get(menus.size() - 1).getId())) {
                    menus.remove(menus.size() - 1);
                }
                menus.get(menus.size() - 1).getSubList().add(cur);
            }
        }
        while (menus.size() != 0 && menus.get(menus.size() - 1).getSubList().size() == 0) {
            menus.remove(menus.size() - 1);
        }
        return menus;
    }


}
