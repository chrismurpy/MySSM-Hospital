package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.BeHospMapper;
import com.murphy.mapper.DrugMapper;
import com.murphy.mapper.DrugPeopleMapper;
import com.murphy.pojo.BeHosp;
import com.murphy.pojo.DrugPeople;
import com.murphy.vo.query.QueryDrugPeopleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 在线发药 - Service
 *
 * @author murphy
 * @since 2021/8/9 1:04 下午
 */
@Service
public class DrugPeopleService {

    @Resource
    private DrugPeopleMapper drugPeopleMapper;
    @Resource
    private DrugMapper drugMapper;
    @Resource
    private BeHospMapper beHospMapper;

    /**
     * 多条件分页查询 - 首先获取住院表中的人员
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<BeHosp> queryByPage(Integer pageNum, Integer pageSize, QueryDrugPeopleVo vo) {
        PageHelper.startPage(pageNum, pageSize);
        List<BeHosp> beHospList = beHospMapper.queryByDrugVo(vo);
        return new PageInfo<>(beHospList);
    }

    /**
     * 根据病例号分页查询
     * @param pageNum
     * @param pageSize
     * @param beH_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<DrugPeople> queryByIdAndPage(Integer pageNum, Integer pageSize, Integer beH_id) {
        PageHelper.startPage(pageNum, pageSize);
        List<DrugPeople> drugPeople = drugPeopleMapper.selectById(beH_id);
        return new PageInfo<>(drugPeople);
    }

    /**
     * 新增发药信息
     * @param drugPeople
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addDrugPeople(DrugPeople drugPeople) {
        return drugPeopleMapper.insertSelective(drugPeople);
    }

    /**
     * 查询所有药品名
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List getDrugName() {
        return drugMapper.selectAllDrugName();
    }

    /**
     * 根据 药品ID + 病例ID 修改
     * @param drugPeople
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateDrugPeople(DrugPeople drugPeople) {
        return drugPeopleMapper.updateById(drugPeople);
    }

    /**
     * 根据 药品ID + 病例ID 查找
     * @param dr_id
     * @param people_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DrugPeople queryByIds(Integer dr_id, Integer people_id) {
        return drugPeopleMapper.queryByDr_idAndP_ids(dr_id, people_id);
    }

    /**
     * 判断订单是否存在
     * @param dr_id
     * @param people_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Integer queryExist(Integer dr_id, Integer people_id) {
        return drugPeopleMapper.selectExist(dr_id, people_id);
    }
}
