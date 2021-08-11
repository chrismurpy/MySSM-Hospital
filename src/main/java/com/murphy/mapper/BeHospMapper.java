package com.murphy.mapper;

import com.murphy.pojo.BeHosp;
import com.murphy.pojo.BeHospExample;
import java.util.List;

import com.murphy.vo.query.QueryBeHospVo;
import com.murphy.vo.query.QueryDrugPeopleVo;
import org.apache.ibatis.annotations.Param;

public interface BeHospMapper {
    long countByExample(BeHospExample example);

    int deleteByExample(BeHospExample example);

    int deleteByPrimaryKey(Integer beH_id);

    int insert(BeHosp record);

    int insertSelective(BeHosp record);

    List<BeHosp> selectByExample(BeHospExample example);

    BeHosp selectByPrimaryKey(Integer beH_id);

    int updateByExampleSelective(@Param("record") BeHosp record, @Param("example") BeHospExample example);

    int updateByExample(@Param("record") BeHosp record, @Param("example") BeHospExample example);

    int updateByPrimaryKeySelective(BeHosp record);

    int updateByPrimaryKey(BeHosp record);

    /**
     * 动态SQL
     * @param vo
     * @return
     */
    List<BeHosp> queryByVo(QueryBeHospVo vo);

    /**
     * 动态SQL
     * @param vo
     * @return
     */
    List<BeHosp> queryByDrugVo(QueryDrugPeopleVo vo);
}