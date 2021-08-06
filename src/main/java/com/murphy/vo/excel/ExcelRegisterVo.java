package com.murphy.vo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 导出Excel封装的结果类 - 挂号信息
 *
 * @author murphy
 * @since 2021/8/4 10:57 下午
 */
public class ExcelRegisterVo {

    private Integer re_id;
    private String re_name;
    private String d_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp re_createTime;
    private String d_keshi;
    private Integer re_state;

    public Integer getRe_id() {
        return re_id;
    }

    public void setRe_id(Integer re_id) {
        this.re_id = re_id;
    }

    public String getRe_name() {
        return re_name;
    }

    public void setRe_name(String re_name) {
        this.re_name = re_name;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public Timestamp getRe_createTime() {
        return re_createTime;
    }

    public void setRe_createTime(Timestamp re_createTime) {
        this.re_createTime = re_createTime;
    }

    public String getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(String d_keshi) {
        this.d_keshi = d_keshi;
    }

    public Integer getRe_state() {
        return re_state;
    }

    public void setRe_state(Integer re_state) {
        this.re_state = re_state;
    }

    @Override
    public String toString() {
        return "RegisterExcelVo{" +
                "re_id=" + re_id +
                ", re_name='" + re_name + '\'' +
                ", d_name='" + d_name + '\'' +
                ", re_createTime=" + re_createTime +
                ", d_keshi='" + d_keshi + '\'' +
                ", re_state=" + re_state +
                '}';
    }
}
