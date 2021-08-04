package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DoctorMapper;
import com.murphy.mapper.RegisterMapper;
import com.murphy.pojo.Doctor;
import com.murphy.pojo.DoctorExample;
import com.murphy.pojo.Register;
import com.murphy.pojo.RegisterExample;
import com.murphy.vo.RegisterQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 挂号信息管理 - Service
 *
 * @author murphy
 * @since 2021/7/26 1:10 下午
 */
@Service
public class RegisterService {

    @Resource
    private RegisterMapper registerMapper;

    @Resource
    private DoctorMapper doctorMapper;

    /**
     * 多条件分页查询 - 未应用
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Register> queryByPage1(Integer pageNum, Integer pageSize, RegisterQueryVo vo){
        RegisterExample example = new RegisterExample();
        // 创建条件的容器
        RegisterExample.Criteria criteria = example.createCriteria();
        if (vo != null) {
            if (vo.getRe_id() != null && !"".equals(vo.getRe_id())){
                criteria.andRe_idEqualTo(vo.getRe_id());
            }
            if (vo.getBeginTime() != null) {
                criteria.andRe_createTimeGreaterThanOrEqualTo(vo.getBeginTime());
            }
            if (vo.getEndTime() != null) {
                criteria.andRe_createTimeLessThanOrEqualTo(vo.getEndTime());
            }
        }
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<Register> registers = registerMapper.selectByExample(example);

        for (Register register : registers) {
            DoctorExample example1 = new DoctorExample();
            DoctorExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andD_idEqualTo(register.getD_id());
            if (vo != null) {
                if (vo.getD_name() != null && !"".equals(vo.getD_name())) {
                    criteria1.andD_nameLike(vo.getD_name());
                }
                if (vo.getD_keshi() != null && !"".equals(vo.getD_keshi())) {
                    criteria1.andD_keshiLike(vo.getD_keshi());
                }
            }
            List<Doctor> doctors = doctorMapper.selectByExample(example1);
            register.setDoctors(doctors);
        }

        return new PageInfo<>(registers);
    }

    /**
     * 自写Mapper - 多条件分页查询(应用)
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Register> queryByPage(Integer pageNum, Integer pageSize, RegisterQueryVo vo){
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<Register> registers = registerMapper.queryByVo(vo);
        return new PageInfo<>(registers);
    }

    /**
     * 新增挂号信息
     * @param register
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addRegister(Register register) {
        return registerMapper.insertSelective(register);
    }

    /**
     * 主键查询
     * @param re_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Register queryById(int re_id) {
        Register register = registerMapper.selectByPrimaryKey(re_id);
        Doctor doctor = doctorMapper.selectByPrimaryKey(register.getD_id());
        register.setDoctor(doctor);
        return register;
    }

    /**
     * 根据主键修改
     * @param register
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateRegister(Register register) {
        return registerMapper.updateByPrimaryKeySelective(register);
    }
}
