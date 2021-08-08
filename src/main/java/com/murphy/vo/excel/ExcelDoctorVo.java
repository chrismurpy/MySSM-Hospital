package com.murphy.vo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 导出Excel封装的结果类 - 门诊医生管理
 *
 * @author murphy
 * @since 2021/8/4 10:57 下午
 */
public class ExcelDoctorVo {
    private Integer d_id;
    private String d_name;
    private Integer d_sex;
    private String d_phone;
    private String d_telPhone;
    private String d_email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date d_inTime;
    private String d_keshi;
    private String d_edu;
    private Integer d_state;

    @Override
    public String toString() {
        return "ExcelDoctorVo{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_sex=" + d_sex +
                ", d_phone='" + d_phone + '\'' +
                ", d_telPhone='" + d_telPhone + '\'' +
                ", d_email='" + d_email + '\'' +
                ", d_inTime=" + d_inTime +
                ", d_keshi='" + d_keshi + '\'' +
                ", d_edu='" + d_edu + '\'' +
                ", d_state=" + d_state +
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

    public Integer getD_sex() {
        return d_sex;
    }

    public void setD_sex(Integer d_sex) {
        this.d_sex = d_sex;
    }

    public String getD_phone() {
        return d_phone;
    }

    public void setD_phone(String d_phone) {
        this.d_phone = d_phone;
    }

    public String getD_telPhone() {
        return d_telPhone;
    }

    public void setD_telPhone(String d_telPhone) {
        this.d_telPhone = d_telPhone;
    }

    public String getD_email() {
        return d_email;
    }

    public void setD_email(String d_email) {
        this.d_email = d_email;
    }

    public Date getD_inTime() {
        return d_inTime;
    }

    public void setD_inTime(Date d_inTime) {
        this.d_inTime = d_inTime;
    }

    public String getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(String d_keshi) {
        this.d_keshi = d_keshi;
    }

    public String getD_edu() {
        return d_edu;
    }

    public void setD_edu(String d_edu) {
        this.d_edu = d_edu;
    }

    public Integer getD_state() {
        return d_state;
    }

    public void setD_state(Integer d_state) {
        this.d_state = d_state;
    }
}
