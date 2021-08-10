package com.murphy.mapper;

import com.murphy.pojo.User;
import com.murphy.pojo.UserExample;
import java.util.List;

import com.murphy.vo.UserQueryVo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer u_LoginName);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer u_LoginName);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 动态SQL 根据用户账户模糊查询
     * @param vo
     * @return
     */
    List<User> queryUserByVo(UserQueryVo vo);

}