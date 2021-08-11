package com.murphy.mapper;

import com.murphy.pojo.Menu;
import com.murphy.pojo.MenuExample;
import java.util.List;

import com.murphy.vo.UserQueryVo;
import com.murphy.vo.query.QueryMenuVo;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer m_id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer m_id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 动态SQL 根据资源名称模糊查询
     * @param vo
     * @return
     */
    List<Menu> queryMenuByVo(QueryMenuVo vo);

}