package com.murphy.vo.query;

/**
 * 病例查询 - 在院发药
 *
 * @author murphy
 * @since 2021/8/9 12:36 下午
 */
public class QueryDrugPeopleVo {
    private Integer beH_id;
    private String re_name;
    private String d_name;

    @Override
    public String toString() {
        return "QueryDrugPeopleVo{" +
                "beH_id=" + beH_id +
                ", re_name='" + re_name + '\'' +
                ", d_name='" + d_name + '\'' +
                '}';
    }

    public Integer getbeH_id() {
        return beH_id;
    }

    public void setbeH_id(Integer beH_id) {
        this.beH_id = beH_id;
    }

    public String getRe_name() {
        return re_name;
    }

    public void setRe_name(String re_name) {
        this.re_name = re_name;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }
}
