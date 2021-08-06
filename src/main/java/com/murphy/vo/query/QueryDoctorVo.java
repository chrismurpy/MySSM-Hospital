package com.murphy.vo.query;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 封装的查询类
 * 多条件查询 医生表信息封装的实体类
 *
 * @author murphy
 * @since 2021/7/26 1:16 下午
 */
public class QueryDoctorVo {
    private Integer d_id;
    private String d_name;
    private String d_keshi;

    @Override
    public String toString() {
        return "RegisterDoctorVo{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_keshi='" + d_keshi + '\'' +
                '}';
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(String d_keshi) {
        this.d_keshi = d_keshi;
    }
}
