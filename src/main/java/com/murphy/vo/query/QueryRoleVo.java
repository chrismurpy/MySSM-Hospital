package com.murphy.vo.query;

/**
 * 封装角色查询实体类
 * @author Ann
 * @create 2021-08-09 20:11
 */
public class QueryRoleVo {
    private Integer r_id;
    private String r_name;
    private Integer r_state;

    @Override
    public String toString() {
        return "QueryRoleVo{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_state=" + r_state +
                '}';
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
        this.r_name = r_name;
    }

    public Integer getR_state() {
        return r_state;
    }

    public void setR_state(Integer r_state) {
        this.r_state = r_state;
    }
}
