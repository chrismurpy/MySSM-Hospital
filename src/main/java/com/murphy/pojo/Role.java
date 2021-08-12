package com.murphy.pojo;

import java.util.List;

public class Role {
    private Integer r_id;

    private String r_name;

    private Integer r_state;

    private List<Menu> menuList;

    @Override
    public String toString() {
        return "Role{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_state=" + r_state +
                ", menuList=" + menuList +
                '}';
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name == null ? null : r_name.trim();
    }

    public Integer getR_state() {
        return r_state;
    }

    public void setR_state(Integer r_state) {
        this.r_state = r_state;
    }
}