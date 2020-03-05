package com.xlw.oa.dto;

import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/4 16:05
 */
public class Menu {


    private Integer id;
    private String name;
    private String url;

    private List<Menu> subList;//子菜单集合

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getSubList() {
        return subList;
    }

    public void setSubList(List<Menu> subList) {
        this.subList = subList;
    }


}
