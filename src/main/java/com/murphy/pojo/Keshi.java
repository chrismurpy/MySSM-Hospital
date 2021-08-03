package com.murphy.pojo;

public class Keshi {
    private Integer k_id;

    private String d_keshi;

    public Integer getK_id() {
        return k_id;
    }

    public void setK_id(Integer k_id) {
        this.k_id = k_id;
    }

    public String getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(String d_keshi) {
        this.d_keshi = d_keshi == null ? null : d_keshi.trim();
    }
}