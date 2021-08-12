package com.murphy.pojo;

import java.util.List;

public class Menu {
    private Integer m_id;

    private String m_name;

    private String m_url;

    private Integer m_state;

    private List<Role> roleList;

    @Override
    public String toString() {
        return "Menu{" +
                "m_id=" + m_id +
                ", m_name='" + m_name + '\'' +
                ", m_url='" + m_url + '\'' +
                ", m_state=" + m_state +
                ", roleList=" + roleList +
                '}';
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getM_url() {
        return m_url;
    }

    public void setM_url(String m_url) {
        this.m_url = m_url;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name == null ? null : m_name.trim();
    }

    public Integer getM_state() {
        return m_state;
    }

    public void setM_state(Integer m_state) {
        this.m_state = m_state;
    }
}