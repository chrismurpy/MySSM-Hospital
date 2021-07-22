package com.murphy.pojo;

public class ChargeProj {
    private Integer charP_id;

    private String charP_name;

    private Long charP_money;

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
}