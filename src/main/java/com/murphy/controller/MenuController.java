package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.Menu;
import com.murphy.pojo.User;
import com.murphy.service.MenuService;
import com.murphy.vo.ResultVo;
import com.murphy.vo.query.QueryMenuVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Ann
 * @create 2021-08-11 15:24
 */

@Controller
@ResponseBody
@RequestMapping("menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public ResultVo<Menu> queryByPage(Integer pageNum, Integer pageSize, QueryMenuVo vo){
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<Menu> menuPageInfo = menuService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(menuPageInfo);
    }

    /**
     * 主键查询
     * @param m_id
     * @return
     */
    @RequestMapping(value = "{m_id}", method = RequestMethod.GET)
    public ResultVo<Menu> queryById(@PathVariable("m_id") Integer m_id) {
        Menu menu = menuService.queryById(m_id);
        return new ResultVo<>(menu);
    }

    /**
     * 更新资源
     * @param m_id
     * @param menu
     * @return
     */
    @RequestMapping(value = "{m_id}", method = RequestMethod.PUT)
    public ResultVo<Menu> updateMenu(@PathVariable("m_id") Integer m_id,Menu menu){
        menu.setM_id(m_id);
        int i = menuService.updateMenu(menu);
        if (i == 1) {
            return new ResultVo<Menu>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }


    /**
     * 逻辑删除
     * @param m_id
     * @return
     */
    @RequestMapping(value = "{m_id}", method = RequestMethod.DELETE)
    public ResultVo<Menu> deleteUser(@PathVariable("m_id") Integer m_id) {
        int i = menuService.deleteMenu(m_id);
        if (i == 1) {
            return new ResultVo<Menu>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

/*    @RequestMapping(value = "{m_id}", method = RequestMethod.POST)
    public ResultVo<Menu> addMenu(Menu menu){


    }*/




}
