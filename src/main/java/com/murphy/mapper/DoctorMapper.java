package com.murphy.mapper;

import com.murphy.pojo.Doctor;
import com.murphy.pojo.DoctorExample;
import java.util.List;

import com.murphy.vo.query.QueryDoctorVo;
import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    long countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Integer d_id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(Integer d_id);

    List<String> selectByKeshi(String d_keshi);

    Doctor selectByName(String d_name);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

    /**
     * 动态SQL
     * @param vo
     * @return
     */
    List<Doctor> queryByVo(QueryDoctorVo vo);
}