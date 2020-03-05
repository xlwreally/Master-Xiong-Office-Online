package com.xlw.oa.model;


import java.io.Serializable;

public class TModule implements Serializable, Cloneable {
    /**
     *
     */

    private Integer m_id;
    /**
     *
     */
    private Integer m_pid;
    /**
     *
     */
    private String m_name;
    /**
     *
     */
    private String m_url;

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public Integer getM_pid() {
        return m_pid;
    }

    public void setM_pid(Integer m_pid) {
        this.m_pid = m_pid;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_url() {
        return m_url;
    }

    public void setM_url(String m_url) {
        this.m_url = m_url;
    }
}