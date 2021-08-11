package com.murphy.vo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * 住院结算 - 缴纳押金 - 导出Excel
 *
 * @author murphy
 * @since 2021/8/11 1:42 下午
 */
public class ExcelChargeVo {

    private Integer beH_id;
    private String re_name;
    private Integer beH_antecedent;
    private Integer beH_total;
    private Integer beH_remain;
    private Integer beH_closePrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp beH_createTime;

    public Timestamp getBeH_createTime() {
        return beH_createTime;
    }

    public void setBeH_createTime(Timestamp beH_createTime) {
        this.beH_createTime = beH_createTime;
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

    public Integer getBeH_antecedent() {
        return beH_antecedent;
    }

    public void setBeH_antecedent(Integer beH_antecedent) {
        this.beH_antecedent = beH_antecedent;
    }

    public Integer getBeH_total() {
        return beH_total;
    }

    public void setBeH_total(Integer beH_total) {
        this.beH_total = beH_total;
    }

    public Integer getBeH_remain() {
        return beH_remain;
    }

    public void setBeH_remain(Integer beH_remain) {
        this.beH_remain = beH_remain;
    }

    public Integer getBeH_closePrice() {
        return beH_closePrice;
    }

    public void setBeH_closePrice(Integer beH_closePrice) {
        this.beH_closePrice = beH_closePrice;
    }
}
