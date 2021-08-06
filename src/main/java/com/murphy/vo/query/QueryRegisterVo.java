package com.murphy.vo.query;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 封装的查询类
 * 多条件查询 挂号信息封装的实体类
 *
 * @author murphy
 * @since 2021/7/26 1:16 下午
 */
public class QueryRegisterVo {
    private Integer re_id;
    private String d_name;
    private String d_keshi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @Override
    public String toString() {
        return "RegisterQueryVo{" +
                "re_id=" + re_id +
                ", d_name='" + d_name + '\'' +
                ", d_keshi='" + d_keshi + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }

    public Integer getRe_id() {
        return re_id;
    }

    public void setRe_id(Integer re_id) {
        this.re_id = re_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(String d_keshi) {
        this.d_keshi = d_keshi;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
