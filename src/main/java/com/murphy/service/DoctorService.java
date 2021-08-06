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

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Doctor> queryByPage(Integer pageNum, Integer pageSize, QueryDoctorVo vo) {
        DoctorExample example = new DoctorExample();
        DoctorExample.Criteria criteria = example.createCriteria();
        if (vo != null){
            if (vo.getD_id() != null && !"".equals(vo.getD_id())) {
                criteria.andD_idEqualTo(vo.getD_id());
            }
            if (vo.getD_name() != null && !"".equals(vo.getD_name().trim())) {
                criteria.andD_nameLike("%" + vo.getD_name().trim() + "%");
            }
            if (vo.getD_keshi() != null && !"".equals(vo.getD_keshi().trim())) {
                criteria.andD_keshiLike("%" + vo.getD_keshi().trim() + "%");
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> doctorList = doctorMapper.selectByExample(example);
        return new PageInfo<>(doctorList);
    }
}
