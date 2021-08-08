package com.murphy.mapper;

import com.murphy.vo.excel.ExcelBeHospVo;
import com.murphy.vo.excel.ExcelDoctorVo;
import com.murphy.vo.excel.ExcelRegisterVo;

import java.util.List;

/**
 * 导出Excel - Mapper
 *
 * @author murphy
 * @since 2021/8/4 11:02 下午
 */
public interface ExcelMapper {

    List<ExcelRegisterVo> queryExcelInfo();

    List<ExcelBeHospVo> queryBeHospInfo();

    List<ExcelDoctorVo> queryDoctorInfo();
}
