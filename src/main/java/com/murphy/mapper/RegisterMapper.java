package com.murphy.mapper;

import com.murphy.pojo.Register;
import com.murphy.pojo.RegisterExample;
import java.util.List;

import com.murphy.vo.query.QueryRegisterVo;
import org.apache.ibatis.annotations.Param;

public interface RegisterMapper {
    long countByExample(RegisterExample example);

    int deleteByExample(RegisterExample example);

    int deleteByPrimaryKey(Integer re_id);

    int insert(Register record);

    int insertSelective(Register record);

    List<Register> selectByExample(RegisterExample example);

    Register selectByPrimaryKey(Integer re_id);

    int updateByExampleSelective(@Param("record") Register record, @Param("example") RegisterExample example);

    int updateByExample(@Param("record") Register record, @Param("example") RegisterExample example);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);

    /**
     * 动态SQL
     * @param vo
     * @return
     */
    List<Register> queryByVo(QueryRegisterVo vo);

    /**
     * 根据 名称 - 查询
     * @param re_name
     * @return
     */
    Register queryByName(String re_name);
}