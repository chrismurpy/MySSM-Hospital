package com.murphy.vo;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 返回结果的统一封装
 *
 * @author murphy
 * @since 2021/7/27 4:45 下午
 */
public class ResultVo<T> {
    /**
     * 返回的是分页对象
     */
    private PageInfo<T> pageInfo;

    /**
     * 返回的是集合
     */
    private List<T> list;

    /**
     * 返回的是单个对象
     */
    private T obj;

    /**
     * 表示返回的状态码
     */
    private Integer code = 200;

    /**
     * 表示可以展示给用户的信息
     */
    private String msg = "OK";

    public ResultVo() {
    }

    public ResultVo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ResultVo(List<T> list) {
        this.list = list;
    }

    public ResultVo(T obj) {
        this.obj = obj;
    }

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
