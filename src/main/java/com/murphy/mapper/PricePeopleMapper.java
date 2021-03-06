package com.murphy.mapper;

import com.murphy.pojo.PricePeople;
import com.murphy.pojo.PricePeopleExample;
import java.util.List;

import com.murphy.vo.query.QueryPricePeopleVo;
import org.apache.ibatis.annotations.Param;

public interface PricePeopleMapper {
    long countByExample(PricePeopleExample example);

    int deleteByExample(PricePeopleExample example);

    int insert(PricePeople record);

    int insertSelective(PricePeople record);

    List<PricePeople> selectByExample(PricePeopleExample example);

    int updateByExampleSelective(@Param("record") PricePeople record, @Param("example") PricePeopleExample example);

    int updateByExample(@Param("record") PricePeople record, @Param("example") PricePeopleExample example);

    /**
     * 动态SQL
     * @param vo
     * @return
     */
    List<PricePeople> queryByVo(QueryPricePeopleVo vo);

    /**
     * 根据 病人ID 查询
     * @param beH_id
     * @return
     */
    List<PricePeople> selectByBeH_id(Integer beH_id);
}