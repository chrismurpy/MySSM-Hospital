package com.murphy.vo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 导出Excel封装的结果类 - 药品管理
 *
 * @author murphy
 * @since 2021/8/4 10:57 下午
 */
public class ExcelDrugVo {
    private Integer dr_id;
    private String dr_name;
    private String dr_type;
    private String dr_simpleDesc;
    private String dr_expiration;
    private String dr_factory;
    private String dr_direction;
    private Integer dr_number;
    private Integer dr_state;

    public Integer getDr_id() {
        return dr_id;
    }

    public void setDr_id(Integer dr_id) {
        this.dr_id = dr_id;
    }

    public String getDr_name() {
        return dr_name;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getDr_type() {
        return dr_type;
    }

    public void setDr_type(String dr_type) {
        this.dr_type = dr_type;
    }

    public String getDr_simpleDesc() {
        return dr_simpleDesc;
    }

    public void setDr_simpleDesc(String dr_simpleDesc) {
        this.dr_simpleDesc = dr_simpleDesc;
    }

    public String getDr_expiration() {
        return dr_expiration;
    }

    public void setDr_expiration(String dr_expiration) {
        this.dr_expiration = dr_expiration;
    }

    public String getDr_factory() {
        return dr_factory;
    }

    public void setDr_factory(String dr_factory) {
        this.dr_factory = dr_factory;
    }

    public String getDr_direction() {
        return dr_direction;
    }

    public void setDr_direction(String dr_direction) {
        this.dr_direction = dr_direction;
    }

    public Integer getDr_number() {
        return dr_number;
    }

    public void setDr_number(Integer dr_number) {
        this.dr_number = dr_number;
    }

    public Integer getDr_state() {
        return dr_state;
    }

    public void setDr_state(Integer dr_state) {
        this.dr_state = dr_state;
    }
}
