package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.AccountMapper;
import com.murphy.pojo.BeHosp;
import com.murphy.vo.query.QueryAccountVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 住院结算 - Service
 *
 * @author murphy
 * @since 2021/8/7 11:41 上午
 */
@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 多条件分页查询 - 住院结算
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<BeHosp> queryByPage(Integer pageNum, Integer pageSize, QueryAccountVo vo) {
        PageHelper.startPage(pageNum, pageSize);
        List<BeHosp> beHospList = accountMapper.queryByVo(vo);
        return new PageInfo<>(beHospList);
    }
}
