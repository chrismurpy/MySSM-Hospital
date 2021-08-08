package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.RoleMapper;
import com.murphy.mapper.UserMapper;
import com.murphy.pojo.Role;
import com.murphy.pojo.User;
import com.murphy.pojo.UserExample;
import com.murphy.vo.UserQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 - 登录 / 注销
 *
 * @author murphy
 * @since 2021/7/23 2:14 下午
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    /**
     * 登录功能
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public boolean login(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andU_LoginNameEqualTo(user.getU_LoginName()).andU_passwordEqualTo(user.getU_password());
        List<User> result = userMapper.selectByExample(example);
        return result.size() > 0;
    }

    /**
     * 根据账号密码查询
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User queryUser(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andU_LoginNameEqualTo(user.getU_LoginName()).andU_passwordEqualTo(user.getU_password());
        User result = userMapper.selectByPrimaryKey(user.getU_LoginName());
        return result;
    }

    /**
     * 多条件分页查询用户信息(已弃用)
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<User> queryByPage1(Integer pageNum, Integer pageSize, UserQueryVo vo){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (vo != null){
            if (vo.getU_LoginName() != null) {
                criteria.andU_LoginNameEqualTo(vo.getU_LoginName());
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectByExample(example);
        return new PageInfo<>(userList);
    }

    /**
     * 自写Mapper - 多条件分页查询(应用)
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<User> queryByPage(Integer pageNum, Integer pageSize, UserQueryVo vo){
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.queryUserByVo(vo);
        return new PageInfo<>(userList);
    }

    /**
     * 根据主键查询用户信息
     * @param u_id user表的主键   即 u_LoginName
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User queryById(int u_id) {
        User user = userMapper.selectByPrimaryKey(u_id);
        Role role = roleMapper.selectByPrimaryKey(user.getR_id());
        user.setRole(role);
        return user;
    }

    /**
     * 主键查询
     * @param u_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User queryUser(int u_id) {
        User user = userMapper.selectByPrimaryKey(u_id);
        return user;
    }

    /**
     * 根据主键修改用户信息
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 根据主键删除用户
     * 逻辑删除   u_state 变更为 1
     * @param u_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int deleteUser(Integer u_id){
        User user = userMapper.selectByPrimaryKey(u_id);
        user.setU_state(1);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }
}
