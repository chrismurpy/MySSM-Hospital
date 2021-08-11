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

    /**
     * 根据 药品ID + 病人ID 修改
     * @param drugPeople
     * @return
     */
    int updateById(DrugPeople drugPeople);

    /**
     * 根据 药品ID + 病人ID 查找
     * @param dr_id
     * @param people_id
     * @return
     */
    DrugPeople queryByDr_idAndP_id(@Param("dr_id") Integer dr_id, @Param("people_id") Integer people_id);

    /**
     * 根据 药品ID + 病人ID 查找
     * @param dr_id
     * @param people_id
     * @return
     */
    DrugPeople queryByDr_idAndP_ids(@Param("dr_id") Integer dr_id, @Param("people_id") Integer people_id);

    /**
     * 判断 药品是否发放
     * @param dr_id
     * @param people_id
     * @return
     */
    Integer selectExist(@Param("dr_id") Integer dr_id, @Param("people_id") Integer people_id);
}