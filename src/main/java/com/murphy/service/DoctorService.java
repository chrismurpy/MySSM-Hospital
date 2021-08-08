package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DoctorMapper;
import com.murphy.pojo.Doctor;
import com.murphy.pojo.DoctorExample;
import com.murphy.vo.query.QueryDoctorVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 医生表 - Service类
 *
 * @author murphy
 * @since 2021/8/3 4:25 下午
 */
@Service
public class DoctorService {

    @Resource
    private DoctorMapper doctorMapper;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Doctor> queryByPage(Integer pageNum, Integer pageSize, QueryDoctorVo vo) {
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> doctorList = doctorMapper.queryByVo(vo);
        return new PageInfo<>(doctorList);
    }

    /**
     * 根据主键查询
     * @param d_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Doctor queryById(int d_id) {
        return doctorMapper.selectByPrimaryKey(d_id);
    }

    /**
     * 修改医生信息
     * @param doctor
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateDoc(Doctor doctor) {
        return doctorMapper.updateByPrimaryKeySelective(doctor);
    }

    /**
     * 根据主键删除 - 逻辑删除 - 修改d_state值为1
     * @param d_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int deleteDoc(int d_id) {
        Doctor doctor = doctorMapper.selectByPrimaryKey(d_id);
        doctor.setD_state(1);
        return doctorMapper.updateByPrimaryKeySelective(doctor);
    }

    /**
     * 新增医生信息
     * @param doctor
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addDoc(Doctor doctor) {
        return doctorMapper.insertSelective(doctor);
    }
}
