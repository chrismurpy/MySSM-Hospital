package com.murphy.service;

import com.murphy.mapper.RoleMenuMapper;
import com.murphy.pojo.RoleMenu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色 - 资源 访问权限 - Service
 *
 * @author murphy
 * @since 2021/8/12 12:05 下午
 */
@Service
public class RoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    /**
     * 新增资源权限信息
     * @param roleMenu
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addRoleMenu(RoleMenu roleMenu) {
        return roleMenuMapper.insertSelective(roleMenu);
    }

    /**
     * 根据 r_id 查找
     * @param r_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<RoleMenu> queryById(Integer r_id) {
        return roleMenuMapper.queryByR_id(r_id);
    }

    /**
     * 根据 r_id 删除
     * @param r_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int deleteByR_id(Integer r_id) {
        return roleMenuMapper.deleteByR_id(r_id);
    }
}
