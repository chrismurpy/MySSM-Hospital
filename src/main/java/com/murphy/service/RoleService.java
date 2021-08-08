package com.murphy.service;

import com.murphy.mapper.RoleMapper;
import com.murphy.pojo.Keshi;
import com.murphy.pojo.Role;
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


}
