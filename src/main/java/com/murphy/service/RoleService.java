package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.MenuMapper;
import com.murphy.mapper.RoleMapper;
import com.murphy.pojo.Keshi;
import com.murphy.pojo.Menu;
import com.murphy.pojo.Role;
import com.murphy.pojo.User;
import com.murphy.vo.UserQueryVo;
import com.murphy.vo.query.QueryRoleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色
 * 级联用户操作
 * @author Ann
 * @create 2021-08-08 21:18
 */
@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private MenuMapper menuMapper;

    /**
     * 查询所有角色姓名
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List selectRoleName() {
        return roleMapper.selectRoleName();
    }

    /**
     * 根据主键查询角色信息
     * @param r_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Role queryById(Integer r_id) {
       return roleMapper.selectByPrimaryKey(r_id);
    }

    /**
     * 自写Mapper - 多条件分页查询(应用)
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Role> queryByPage(Integer pageNum, Integer pageSize, QueryRoleVo vo){
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleList = roleMapper.queryRoleByVo(vo);
        return new PageInfo<>(roleList);
    }

    /**
     * 根据主键删除用户
     * 逻辑删除   r_state 变更为 1
     * @param r_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int deleteRole(Integer r_id){
        Role role = roleMapper.selectByPrimaryKey(r_id);
        role.setR_state(1);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 根据角色ID查询角色信息（包含角色所对应的菜单资源信息）
     * @param r_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Role queryByRoleId(Integer r_id) {
        Role role = roleMapper.selectByPrimaryKey(r_id);
        List<Menu> menuList = menuMapper.queryMenuByRoleId(r_id);
        role.setMenuList(menuList);
        return role;
    }

    /**
     * 新增角色
     * @param role
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addRole(Role role) {
        return roleMapper.insertSelective(role);
    }

}
