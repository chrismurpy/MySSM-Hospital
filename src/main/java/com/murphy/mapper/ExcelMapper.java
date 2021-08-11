package com.murphy.mapper;

import com.murphy.vo.excel.*;

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

    List<ExcelDrugVo> queryDrugInfo();

    List<ExcelChargeProjVo> queryChargeInfo(Integer beH_id);
}
