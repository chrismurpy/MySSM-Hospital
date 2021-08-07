package com.murphy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class ChargeProj {
    private Integer charP_id;

    private String charP_name;

    private Long charP_money;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp charP_createTime;

    private Integer charP_state;

    @Override
    public String toString() {
        return "ChargeProj{" +
                "charP_id=" + charP_id +
                ", charP_name='" + charP_name + '\'' +
                ", charP_money=" + charP_money +
                ", charP_createTime=" + charP_createTime +
                ", charP_state=" + charP_state +
                '}';
    }

    public Integer getCharP_id() {
        return charP_id;
    }

    public void setCharP_id(Integer charP_id) {
        this.charP_id = charP_id;
    }

    public String getCharP_name() {
        return charP_name;
    }

    public void setCharP_name(String charP_name) {
        this.charP_name = charP_name == null ? null : charP_name.trim();
    }

    public Long getCharP_money() {
        return charP_money;
    }

    public void setCharP_money(Long charP_money) {
        this.charP_money = charP_money;
    }

    public Timestamp getCharP_createTime() {
        return charP_createTime;
    }

    public void setCharP_createTime(Timestamp charP_createTime) {
        this.charP_createTime = charP_createTime;
    }

    public Integer getCharP_state() {
        return charP_state;
    }

    public void setCharP_state(Integer charP_state) {
        this.charP_state = charP_state;
    }
}