package com.murphy.service;

import com.murphy.mapper.ExcelMapper;
import com.murphy.vo.excel.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 导出 Excel - Service
 *
 * @author murphy
 * @since 2021/8/4 11:06 下午
 */
@Service
public class ExcelService {
    @Resource
    private ExcelMapper excelMapper;

    /**
     * 挂号信息 - 相关信息查询
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ExcelRegisterVo> queryExcelInfo() {
        return excelMapper.queryExcelInfo();
    }

    /**
     * 住院办理 - 导出Excel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ExcelBeHospVo> queryBeHospInfo() {
        return excelMapper.queryBeHospInfo();
    }

    /**
     * 医生信息 - 导出Excel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ExcelDoctorVo> queryDoctorInfo() {
        return excelMapper.queryDoctorInfo();
    }

    /**
     * 药品管理 - 导出Excel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ExcelDrugVo> queryDrugInfo() {
        return excelMapper.queryDrugInfo();
    }

    /**
     * 收费项目管理 - 导出Excel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ExcelChargeProjVo> queryChargeInfo(Integer beH_id) {
        return excelMapper.queryChargeInfo(beH_id);
    }

    /**
     * 住院结算 - 导出Excel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ExcelChargeVo> queryAddChargeInfo() {
        return excelMapper.queryAddChargeInfo();
    }
}
