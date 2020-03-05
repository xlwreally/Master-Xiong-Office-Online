package com.xlw.oa.service.safty;

import com.xlw.oa.dto.Menu;

import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/4 16:04
 */
public interface HomeService {

    public List<Menu> getMenu(String name);
}
