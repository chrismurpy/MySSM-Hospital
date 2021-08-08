package com.murphy.vo.query;

/**
 * 封装的查询类 - 药品管理
 *
 * @author murphy
 * @since 2021/8/8 2:19 下午
 */
public class QueryDrugVo {
    private Integer dr_id;
    private String dr_name;
    private String dr_type;

    public Integer getDr_id() {
        return dr_id;
    }

    public void setDr_id(Integer dr_id) {
        this.dr_id = dr_id;
    }

    public String getDr_name() {
        return dr_name;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getDr_type() {
        return dr_type;
    }

    public void setDr_type(String dr_type) {
        this.dr_type = dr_type;
    }
}
