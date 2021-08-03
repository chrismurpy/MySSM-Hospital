package com.murphy.service;

import com.murphy.mapper.KeshiMapper;
import com.murphy.pojo.Keshi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科室 - Service层 - 用于级联医生操作
 *
 * @author murphy
 * @since 2021/8/3 5:15 下午
 */
@Service
public class KeshiService {

    @Resource
    private KeshiMapper keshiMapper;

    /**
     * 查询所有科室
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List selectKeshi() {
        return keshiMapper.selectKeshi();
    }

    /**
     * 主键查询
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Keshi queryById(Integer id) {
        return keshiMapper.selectByPrimaryKey(id);
    }
}
