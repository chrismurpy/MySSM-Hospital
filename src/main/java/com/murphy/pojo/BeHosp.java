package com.murphy.pojo;

public class BeHosp {
    private Integer beH_id;

    private String beH_nurse;

    private String beH_bedNum;

    private Long beH_antecedent;

    private String beH_illness;

    private Integer beH_closePrice;

    private Integer beH_state;

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