package com.murphy.service;

import com.murphy.mapper.UserMapper;
import com.murphy.pojo.User;
import com.murphy.pojo.UserExample;
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

}
