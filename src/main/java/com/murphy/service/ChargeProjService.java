package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.ChargeProjMapper;
import com.murphy.pojo.ChargeProj;
import com.murphy.pojo.Register;
import com.murphy.vo.query.QueryChargeProjVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收费项目管理 - Service层
 *
 * @author murphy
 * @since 2021/8/7 2:29 下午
 */
@Service
public class ChargeProjService {

    @Resource
    private ChargeProjMapper chargeProjMapper;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<ChargeProj> queryByPage(Integer pageNum, Integer pageSize, QueryChargeProjVo vo) {
        PageHelper.startPage(pageNum, pageSize);
        List<ChargeProj> chargeProjs = chargeProjMapper.queryByVo(vo);
        return new PageInfo<>(chargeProjs);
    }

    /**
     * 主键查询
     * @param charP_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public ChargeProj queryById(int charP_id) {
        return chargeProjMapper.selectByPrimaryKey(charP_id);
    }

    /**
     * 根据主键修改
     * @param proj
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateCharProj(ChargeProj proj) {
        return chargeProjMapper.updateByPrimaryKeySelective(proj);
    }

    /**
     * 根据主键删除 - 逻辑删除
     * @param charP_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int deleteCharProj(int charP_id) {
        ChargeProj chargeProj = chargeProjMapper.selectByPrimaryKey(charP_id);
        chargeProj.setCharP_state(1);
        return chargeProjMapper.updateByPrimaryKeySelective(chargeProj);
    }

    /**
     * 添加收费项目
     * @param chargeProj
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addCharProj(ChargeProj chargeProj) {
        return chargeProjMapper.insertSelective(chargeProj);
    }

    /**
     * 获取 收费项目名称
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List queryChargeProjName() {
        return chargeProjMapper.queryChargeProjName();
    }

    /**
     * 根据 收费项目名称 - 查询
     * @param charP_name
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public ChargeProj queryByName(String charP_name) {
        return chargeProjMapper.queryByName(charP_name);
    }
}
