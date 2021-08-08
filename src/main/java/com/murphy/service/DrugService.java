package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DrugMapper;
import com.murphy.pojo.Drug;
import com.murphy.vo.query.QueryDrugVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 药品管理 - Service层
 *
 * @author murphy
 * @since 2021/8/8 2:20 下午
 */
@Service
public class DrugService {

    @Resource
    private DrugMapper drugMapper;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Drug> queryByPage(Integer pageNum, Integer pageSize, QueryDrugVo vo) {
        PageHelper.startPage(pageNum, pageSize);
        List<Drug> drugs = drugMapper.queryByVo(vo);
        return new PageInfo<>(drugs);
    }

    /**
     * 主键查询
     * @param dr_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Drug queryById(int dr_id) {
        return drugMapper.selectByPrimaryKey(dr_id);
    }

    /**
     * 根据主键修改 - 药品信息
     * @param drug
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateDrug(Drug drug) {
        return drugMapper.updateByPrimaryKeySelective(drug);
    }

    /**
     * 根据主键删除 - state -> 1
     * @param dr_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int delDrug(int dr_id) {
        Drug drug = drugMapper.selectByPrimaryKey(dr_id);
        drug.setDr_state(1);
        return drugMapper.updateByPrimaryKeySelective(drug);
    }

    /**
     * 根据主键修改 - state -> 0
     * @param dr_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int reAddDrug(int dr_id) {
        Drug drug = drugMapper.selectByPrimaryKey(dr_id);
        drug.setDr_state(0);
        return drugMapper.updateByPrimaryKeySelective(drug);
    }

    /**
     * 添加药品信息
     * @param drug
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addDrug(Drug drug) {
        return drugMapper.insertSelective(drug);
    }
}
