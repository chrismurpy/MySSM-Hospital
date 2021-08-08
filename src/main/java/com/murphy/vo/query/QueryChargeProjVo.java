package com.murphy.vo.query;

/**
 * 收费项目管理 - 封装的查询类
 *
 * @author murphy
 * @since 2021/8/7 2:30 下午
 */
public class QueryChargeProjVo {

    private Integer charP_id;
    private String charP_name;

    @Override
    public String toString() {
        return "QueryChargeProjVo{" +
                "charP_id=" + charP_id +
                ", charP_name='" + charP_name + '\'' +
                '}';
    }

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
        this.charP_name = charP_name;
    }
}
