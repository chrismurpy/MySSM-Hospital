package com.murphy.mapper;

import com.murphy.pojo.DrugPeople;
import com.murphy.pojo.DrugPeopleExample;
import java.util.List;

import com.murphy.vo.query.QueryDrugPeopleVo;
import org.apache.ibatis.annotations.Param;

public interface DrugPeopleMapper {
    long countByExample(DrugPeopleExample example);

    int deleteByExample(DrugPeopleExample example);

    int insert(DrugPeople record);

    int insertSelective(DrugPeople record);

    List<DrugPeople> selectByExample(DrugPeopleExample example);

    int updateByExampleSelective(@Param("record") DrugPeople record, @Param("example") DrugPeopleExample example);

    int updateByExample(@Param("record") DrugPeople record, @Param("example") DrugPeopleExample example);

    /**
     * 根据病例号查找
     * @param beH_id
     * @return
     */
    List<DrugPeople> selectById(Integer beH_id);
}