package com.murphy.mapper;

import com.murphy.pojo.Menu;
import com.murphy.pojo.Role;
import com.murphy.pojo.RoleExample;
import java.util.List;

import com.murphy.vo.query.QueryRoleVo;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer r_id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    //查询所有角色姓名
    List<String> selectRoleName();

    //通过角色名查询该角色信息
    Role selectByRoleName(String r_name);

    Role selectByPrimaryKey(Integer r_id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 动态SQL 根据角色姓名模糊查询
     * @param vo
     * @return
     */
    List<Role> queryRoleByVo(QueryRoleVo vo);







}