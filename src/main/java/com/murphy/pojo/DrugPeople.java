package com.murphy.pojo;

public class DrugPeople {
    private Integer dr_id;

    private Integer people_id;

    private Integer drp_number;

    private Integer dr_outNum;

    private BeHosp beHosp;

    private Doctor doctor;

    private Drug drug;

    private Register register;

    @Override
    public String toString() {
        return "DrugPeople{" +
                "dr_id=" + dr_id +
                ", people_id=" + people_id +
                ", drp_number=" + drp_number +
                ", dr_outNum=" + dr_outNum +
                ", beHosp=" + beHosp +
                ", doctor=" + doctor +
                ", drug=" + drug +
                ", register=" + register +
                '}';
    }

    public BeHosp getBeHosp() {
        return beHosp;
    }

    public void setBeHosp(BeHosp beHosp) {
        this.beHosp = beHosp;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Integer getDr_id() {
        return dr_id;
    }

    public void setDr_id(Integer dr_id) {
        this.dr_id = dr_id;
    }

    public Integer getPeople_id() {
        return people_id;
    }

    public void setPeople_id(Integer people_id) {
        this.people_id = people_id;
    }

    public Integer getdrp_number() {
        return drp_number;
    }

    public void setdrp_number(Integer drp_number) {
        this.drp_number = drp_number;
    }

    public Integer getDr_outNum() {
        return dr_outNum;
    }

    public void setDr_outNum(Integer dr_outNum) {
        this.dr_outNum = dr_outNum;
    }
}