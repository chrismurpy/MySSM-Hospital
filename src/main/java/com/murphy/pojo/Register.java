package com.murphy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Register {
    private Integer re_id;

    private String re_idCard;

    private String re_medical;

    private Long re_price;

    private String re_phone;

    private Integer re_selfPrice;

    private Integer re_sex;

    private Integer re_age;

    private String re_job;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp re_createTime;

    private Integer re_lookDoc;

    private Integer d_id;
    private List<Doctor> doctors;
    private Doctor doctor;

    private String re_remark;

    private Integer re_state;

    @Override
    public String toString() {
        return "Register{" +
                "re_id=" + re_id +
                ", re_idCard='" + re_idCard + '\'' +
                ", re_medical='" + re_medical + '\'' +
                ", re_price=" + re_price +
                ", re_phone='" + re_phone + '\'' +
                ", re_selfPrice=" + re_selfPrice +
                ", re_sex=" + re_sex +
                ", re_age=" + re_age +
                ", re_job='" + re_job + '\'' +
                ", re_createTime=" + re_createTime +
                ", re_lookDoc=" + re_lookDoc +
                ", d_id=" + d_id +
                ", doctors=" + doctors +
                ", doctor=" + doctor +
                ", re_remark='" + re_remark + '\'' +
                ", re_state=" + re_state +
                '}';
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Integer getRe_id() {
        return re_id;
    }

    public void setRe_id(Integer re_id) {
        this.re_id = re_id;
    }

    public String getRe_idCard() {
        return re_idCard;
    }

    public void setRe_idCard(String re_idCard) {
        this.re_idCard = re_idCard == null ? null : re_idCard.trim();
    }

    public String getRe_medical() {
        return re_medical;
    }

    public void setRe_medical(String re_medical) {
        this.re_medical = re_medical == null ? null : re_medical.trim();
    }

    public Long getRe_price() {
        return re_price;
    }

    public void setRe_price(Long re_price) {
        this.re_price = re_price;
    }

    public String getRe_phone() {
        return re_phone;
    }

    public void setRe_phone(String re_phone) {
        this.re_phone = re_phone == null ? null : re_phone.trim();
    }

    public Integer getRe_selfPrice() {
        return re_selfPrice;
    }

    public void setRe_selfPrice(Integer re_selfPrice) {
        this.re_selfPrice = re_selfPrice;
    }

    public Integer getRe_sex() {
        return re_sex;
    }

    public void setRe_sex(Integer re_sex) {
        this.re_sex = re_sex;
    }

    public Integer getRe_age() {
        return re_age;
    }

    public void setRe_age(Integer re_age) {
        this.re_age = re_age;
    }

    public String getRe_job() {
        return re_job;
    }

    public void setRe_job(String re_job) {
        this.re_job = re_job == null ? null : re_job.trim();
    }

    public Timestamp getRe_createTime() {
        return re_createTime;
    }

    public void setRe_createTime(Timestamp re_createTime) {
        this.re_createTime = re_createTime;
    }

    public Integer getRe_lookDoc() {
        return re_lookDoc;
    }

    public void setRe_lookDoc(Integer re_lookDoc) {
        this.re_lookDoc = re_lookDoc;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getRe_remark() {
        return re_remark;
    }

    public void setRe_remark(String re_remark) {
        this.re_remark = re_remark == null ? null : re_remark.trim();
    }

    public Integer getRe_state() {
        return re_state;
    }

    public void setRe_state(Integer re_state) {
        this.re_state = re_state;
    }
}