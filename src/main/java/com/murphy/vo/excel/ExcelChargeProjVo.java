package com.murphy.vo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * 收费项目明细 - 导出Excel
 *
 * @author murphy
 * @since 2021/8/11 11:53 上午
 */
public class ExcelChargeProjVo {

    private Integer beH_id;
    private String re_name;
    private String charP_name;
    private Integer charP_money;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp checkTime;

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

    public String getCharP_name() {
        return charP_name;
    }

    public void setCharP_name(String charP_name) {
        this.charP_name = charP_name;
    }

    public Integer getCharP_money() {
        return charP_money;
    }

    public void setCharP_money(Integer charP_money) {
        this.charP_money = charP_money;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }
}
