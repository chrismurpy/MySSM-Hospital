package com.murphy.vo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * 导出Excel封装的结果类 - 住院办理
 *
 * @author murphy
 * @since 2021/8/4 10:57 下午
 */
public class ExcelBeHospVo {
    private Integer beH_id;
    private String re_name;
    private String beH_bedNum;
    private String re_phone;
    private Integer beH_total;
    private Integer beH_antecedent;
    private String d_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp beH_createTime;
    private String d_keshi;
    private Integer beH_closePrice;
    private Integer beH_state;
    private Integer re_state;

    @Override
    public String toString() {
        return "ExcelBeHospVo{" +
                "beH_id=" + beH_id +
                ", re_name='" + re_name + '\'' +
                ", beH_bedNum='" + beH_bedNum + '\'' +
                ", re_phone='" + re_phone + '\'' +
                ", beH_total=" + beH_total +
                ", beH_antecedent=" + beH_antecedent +
                ", d_name='" + d_name + '\'' +
                ", beH_createTime=" + beH_createTime +
                ", d_keshi='" + d_keshi + '\'' +
                ", beH_closePrice=" + beH_closePrice +
                ", beH_state=" + beH_state +
                ", re_state=" + re_state +
                '}';
    }

    public Integer getBeH_id() {
        return beH_id;
    }

    public void setBeH_id(Integer beH_id) {
        this.beH_id = beH_id;
    }

    public String getRe_name() {
        return re_name;
    }

    public void setRe_name(String re_name) {
        this.re_name = re_name;
    }

    public String getBeH_bedNum() {
        return beH_bedNum;
    }

    public void setBeH_bedNum(String beH_bedNum) {
        this.beH_bedNum = beH_bedNum;
    }

    public String getRe_phone() {
        return re_phone;
    }

    public void setRe_phone(String re_phone) {
        this.re_phone = re_phone;
    }

    public Integer getBeH_total() {
        return beH_total;
    }

    public void setBeH_total(Integer beH_total) {
        this.beH_total = beH_total;
    }

    public Integer getBeH_antecedent() {
        return beH_antecedent;
    }

    public void setBeH_antecedent(Integer beH_antecedent) {
        this.beH_antecedent = beH_antecedent;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public Timestamp getBeH_createTime() {
        return beH_createTime;
    }

    public void setBeH_createTime(Timestamp beH_createTime) {
        this.beH_createTime = beH_createTime;
    }

    public String getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(String d_keshi) {
        this.d_keshi = d_keshi;
    }

    public Integer getBeH_closePrice() {
        return beH_closePrice;
    }

    public void setBeH_closePrice(Integer beH_closePrice) {
        this.beH_closePrice = beH_closePrice;
    }

    public Integer getBeH_state() {
        return beH_state;
    }

    public void setBeH_state(Integer beH_state) {
        this.beH_state = beH_state;
    }

    public Integer getRe_state() {
        return re_state;
    }

    public void setRe_state(Integer re_state) {
        this.re_state = re_state;
    }
}
