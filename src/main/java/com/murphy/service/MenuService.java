package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.MenuMapper;
import com.murphy.pojo.Menu;
import com.murphy.pojo.Role;
import com.murphy.pojo.User;
import com.murphy.vo.UserQueryVo;
import com.murphy.vo.query.QueryMenuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ann
 * @create 2021-08-11 15:08
 */
@Service
public class MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 自写Mapper - 多条件分页查询(应用)
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Menu> queryByPage(Integer pageNum, Integer pageSize, QueryMenuVo vo){
        PageHelper.startPage(pageNum, pageSize);
        List<Menu> menuList = menuMapper.queryMenuByVo(vo);
        return new PageInfo<>(menuList);
    }

    /**
     * 根据主键查询菜单资源
     * @param m_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Menu queryById(int m_id) {
        Menu menu = menuMapper.selectByPrimaryKey(m_id);
        return menu;
    }

    /**
     * 根据主键更新菜单资源
     * @param menu
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateMenu(Menu menu){
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     * 根据主键删除菜单资源
     * 逻辑删除   m_state 变更为 1
     * @param m_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int deleteMenu(Integer m_id){
        Menu menu = menuMapper.selectByPrimaryKey(m_id);
        menu.setM_state(1);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     * 新增资源
     * @param menu
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addMenu(Menu menu){
        return menuMapper.insertSelective(menu);
    }


}
