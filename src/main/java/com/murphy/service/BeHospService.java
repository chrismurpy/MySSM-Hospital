package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.BeHospMapper;
import com.murphy.mapper.DoctorMapper;
import com.murphy.mapper.RegisterMapper;
import com.murphy.pojo.BeHosp;
import com.murphy.pojo.Register;
import com.murphy.vo.BeHospQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 住院办理 - Service层
 *
 * @author murphy
 * @since 2021/8/5 1:31 下午
 */
@Service
public class BeHospService {

    @Resource
    private BeHospMapper beHospMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private RegisterMapper registerMapper;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<BeHosp> queryByPage(Integer pageNum, Integer pageSize, BeHospQueryVo vo) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<BeHosp> beHospList = beHospMapper.queryByVo(vo);
        return new PageInfo<>(beHospList);
    }

    /**
     * 主键查询
     * @param beH_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public BeHosp queryById(int beH_id) {
        BeHosp beHosp = beHospMapper.selectByPrimaryKey(beH_id);
        beHosp.setDoctor(doctorMapper.selectByPrimaryKey(beHosp.getD_id()));
        beHosp.setRegister(registerMapper.selectByPrimaryKey(beH_id));
        return beHosp;
    }

    /**
     * 主键更新
     * @param beHosp
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateBeHosp(BeHosp beHosp) {
        return beHospMapper.updateByPrimaryKeySelective(beHosp);
    }

    /**
     * 添加住院
     * @param beHosp
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addBeHosp(BeHosp beHosp) {
        return beHospMapper.insertSelective(beHosp);
    }

    /**
     * 缴费实现
     * @param beHosp
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateCharge(BeHosp beHosp) {
        return beHospMapper.updateByPrimaryKeySelective(beHosp);
    }
}
