package com.murphy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author murphy
 */
public class BeHosp {
    private Integer beH_id;

    private String beH_nurse;

    private String beH_bedNum;

    private Long beH_antecedent;

    private Integer beH_total;

    private Integer beH_charge;

    private Integer beH_remain;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp beH_createTime;

    private Integer d_id;

    private String beH_illness;

    private Integer beH_closePrice;

    private Integer beH_state;

    private Register register;

    private Doctor doctor;

    @Override
    public String toString() {
        return "BeHosp{" +
                "beH_id=" + beH_id +
                ", beH_nurse='" + beH_nurse + '\'' +
                ", beH_bedNum='" + beH_bedNum + '\'' +
                ", beH_antecedent=" + beH_antecedent +
                ", beH_total=" + beH_total +
                ", beH_charge=" + beH_charge +
                ", beH_remain=" + beH_remain +
                ", beH_createTime=" + beH_createTime +
                ", d_id=" + d_id +
                ", beH_illness='" + beH_illness + '\'' +
                ", beH_closePrice=" + beH_closePrice +
                ", beH_state=" + beH_state +
                ", register=" + register +
                ", doctor=" + doctor +
                '}';
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getBeH_id() {
        return beH_id;
    }

    public void setBeH_id(Integer beH_id) {
        this.beH_id = beH_id;
    }

    public String getBeH_nurse() {
        return beH_nurse;
    }

    public void setBeH_nurse(String beH_nurse) {
        this.beH_nurse = beH_nurse == null ? null : beH_nurse.trim();
    }

    public String getBeH_bedNum() {
        return beH_bedNum;
    }

    public void setBeH_bedNum(String beH_bedNum) {
        this.beH_bedNum = beH_bedNum == null ? null : beH_bedNum.trim();
    }

    public Long getBeH_antecedent() {
        return beH_antecedent;
    }

    public void setBeH_antecedent(Long beH_antecedent) {
        this.beH_antecedent = beH_antecedent;
    }

    public Integer getBeH_total() {
        return beH_total;
    }

    public void setBeH_total(Integer beH_total) {
        this.beH_total = beH_total;
    }

    public Integer getBeH_charge() {
        return beH_charge;
    }

    public void setBeH_charge(Integer beH_charge) {
        this.beH_charge = beH_charge;
    }

    public Integer getBeH_remain() {
        return beH_remain;
    }

    public void setBeH_remain(Integer beH_remain) {
        this.beH_remain = beH_remain;
    }

    public Timestamp getBeH_createTime() {
        return beH_createTime;
    }

    public void setBeH_createTime(Timestamp beH_createTime) {
        this.beH_createTime = beH_createTime;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getBeH_illness() {
        return beH_illness;
    }

    public void setBeH_illness(String beH_illness) {
        this.beH_illness = beH_illness == null ? null : beH_illness.trim();
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
}