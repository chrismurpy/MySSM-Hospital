package com.murphy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class PricePeople {
    private Integer charP_id;

    private Integer beH_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp checkTime;

    private ChargeProj chargeProj;

    private BeHosp beHosp;

    private Register register;

    @Override
    public String toString() {
        return "PricePeople{" +
                "charP_id=" + charP_id +
                ", beH_id=" + beH_id +
                ", checkTime=" + checkTime +
                ", chargeProj=" + chargeProj +
                ", beHosp=" + beHosp +
                ", register=" + register +
                '}';
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public ChargeProj getChargeProj() {
        return chargeProj;
    }

    public void setChargeProj(ChargeProj chargeProj) {
        this.chargeProj = chargeProj;
    }

    public BeHosp getBeHosp() {
        return beHosp;
    }

    public void setBeHosp(BeHosp beHosp) {
        this.beHosp = beHosp;
    }

    public Integer getCharP_id() {
        return charP_id;
    }

    public void setCharP_id(Integer charP_id) {
        this.charP_id = charP_id;
    }

    public Integer getBeH_id() {
        return beH_id;
    }

    public void setBeH_id(Integer beH_id) {
        this.beH_id = beH_id;
    }
}