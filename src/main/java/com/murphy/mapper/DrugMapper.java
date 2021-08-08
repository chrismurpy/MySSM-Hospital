package com.murphy.mapper;

import com.murphy.pojo.Drug;
import com.murphy.pojo.DrugExample;
import java.util.List;

import com.murphy.vo.query.QueryDrugVo;
import org.apache.ibatis.annotations.Param;

public interface DrugMapper {
    long countByExample(DrugExample example);

    int deleteByExample(DrugExample example);

    int deleteByPrimaryKey(Integer dr_id);

    int insert(Drug record);

    int insertSelective(Drug record);

    List<Drug> selectByExample(DrugExample example);

    Drug selectByPrimaryKey(Integer dr_id);

    int updateByExampleSelective(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByExample(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);

    /**
     * 动态SQL
     * @param vo
     * @return
     */
    List<Drug> queryByVo(QueryDrugVo vo);
}