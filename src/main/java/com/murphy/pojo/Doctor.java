package com.murphy.pojo;

import java.util.Date;

public class Doctor {
    private Integer d_id;

    private String d_idCard;

    private Integer d_phone;

    private String d_telPhone;

    private Integer d_sex;

    private Date d_birthday;

    private Integer d_age;

    private String d_email;

    private String d_keshi;

    private String d_edu;

    private String d_desc;

    private Date d_inTime;

    private Integer d_state;

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_idCard() {
        return d_idCard;
    }

    public void setD_idCard(String d_idCard) {
        this.d_idCard = d_idCard == null ? null : d_idCard.trim();
    }

    public Integer getD_phone() {
        return d_phone;
    }

    public void setD_phone(Integer d_phone) {
        this.d_phone = d_phone;
    }

    public String getD_telPhone() {
        return d_telPhone;
    }

    public void setD_telPhone(String d_telPhone) {
        this.d_telPhone = d_telPhone == null ? null : d_telPhone.trim();
    }

    public Integer getD_sex() {
        return d_sex;
    }

    public void setD_sex(Integer d_sex) {
        this.d_sex = d_sex;
    }

    public Date getD_birthday() {
        return d_birthday;
    }

    public void setD_birthday(Date d_birthday) {
        this.d_birthday = d_birthday;
    }

    public Integer getD_age() {
        return d_age;
    }

    public void setD_age(Integer d_age) {
        this.d_age = d_age;
    }

    public String getD_email() {
        return d_email;
    }

    public void setD_email(String d_email) {
        this.d_email = d_email == null ? null : d_email.trim();
    }

    public String getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(String d_keshi) {
        this.d_keshi = d_keshi == null ? null : d_keshi.trim();
    }

    public String getD_edu() {
        return d_edu;
    }

    public void setD_edu(String d_edu) {
        this.d_edu = d_edu == null ? null : d_edu.trim();
    }

    public String getD_desc() {
        return d_desc;
    }

    public void setD_desc(String d_desc) {
        this.d_desc = d_desc == null ? null : d_desc.trim();
    }

    public Date getD_inTime() {
        return d_inTime;
    }

    public void setD_inTime(Date d_inTime) {
        this.d_inTime = d_inTime;
    }

    public Integer getD_state() {
        return d_state;
    }

    public void setD_state(Integer d_state) {
        this.d_state = d_state;
    }
}