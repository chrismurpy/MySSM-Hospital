package com.murphy.vo.query;

/**
 * 住院结算 - Account 封装的查询类
 *
 * @author murphy
 * @since 2021/8/7 11:34 上午
 */
public class QueryAccountVo {

    private Integer beH_id;
    private String re_name;

    @Override
    public String toString() {
        return "QueryAccountVo{" +
                "beH_id=" + beH_id +
                ", re_name='" + re_name + '\'' +
                '}';
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
}
