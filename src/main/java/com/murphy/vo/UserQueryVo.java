package com.murphy.vo;

/**
 * 封装的查询类
 * 多条件查询  用户表信息封装的实体类
 * @author Ann
 * @create 2021-08-08 14:24
 */
public class UserQueryVo {

    private Integer u_LoginName;
    private String u_trueName;
    private Integer r_id;

    @Override
    public String toString() {
        return "UserQueryVo{" +
                "u_LoginName=" + u_LoginName +
                ", u_trueName='" + u_trueName + '\'' +
                ", r_id=" + r_id +
                '}';
    }

    public Integer getU_LoginName() {
        return u_LoginName;
    }

    public void setU_LoginName(Integer u_LoginName) {
        this.u_LoginName = u_LoginName;
    }

    public String getU_trueName() {
        return u_trueName;
    }

    public void setU_trueName(String u_trueName) {
        this.u_trueName = u_trueName;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }
}
