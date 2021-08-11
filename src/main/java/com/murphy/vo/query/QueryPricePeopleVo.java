package com.murphy.vo.query;

/**
 * 封装的查询类
 * 收费项目登记 - 病人 / 记账
 * @author murphy
 * @since 2021/8/10 7:22 下午
 */
public class QueryPricePeopleVo {

    private Integer beH_id;
    private String re_name;

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
}
