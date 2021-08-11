package com.murphy.mapper;

import com.murphy.pojo.ChargeProj;
import com.murphy.pojo.ChargeProjExample;
import java.util.List;

import com.murphy.vo.query.QueryChargeProjVo;
import org.apache.ibatis.annotations.Param;

public interface ChargeProjMapper {
    long countByExample(ChargeProjExample example);

    int deleteByExample(ChargeProjExample example);

    int deleteByPrimaryKey(Integer charP_id);

    int insert(ChargeProj record);

    int insertSelective(ChargeProj record);

    List<ChargeProj> selectByExample(ChargeProjExample example);

    ChargeProj selectByPrimaryKey(Integer charP_id);

    int updateByExampleSelective(@Param("record") ChargeProj record, @Param("example") ChargeProjExample example);

    int updateByExample(@Param("record") ChargeProj record, @Param("example") ChargeProjExample example);

    int updateByPrimaryKeySelective(ChargeProj record);

    int updateCharge(ChargeProj proj);

    int updateByPrimaryKey(ChargeProj record);

    /**
     * 动态SQL查询
     * @param vo
     * @return
     */
    List<ChargeProj> queryByVo(QueryChargeProjVo vo);

    /**
     * 获取 收费项目名称
     * @return
     */
    List<String> queryChargeProjName();

    /**
     * 根据 收费项目名 查找
     * @param charP_name
     * @return
     */
    ChargeProj queryByName(String charP_name);
}