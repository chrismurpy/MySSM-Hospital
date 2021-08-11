package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.mapper.PricePeopleMapper;
import com.murphy.pojo.PricePeople;
import com.murphy.vo.query.QueryPricePeopleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收费项目结算 - 病人 - Service
 *
 * @author murphy
 * @since 2021/8/10 7:15 下午
 */
@Service
public class PricePeopleService {

    @Resource
    private PricePeopleMapper pricePeopleMapper;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<PricePeople> queryByPage(Integer pageNum, Integer pageSize, QueryPricePeopleVo vo) {
        PageHelper.startPage(pageNum, pageSize);
        List<PricePeople> pricePeople = pricePeopleMapper.queryByVo(vo);
        return new PageInfo<>(pricePeople);
    }

    /**
     * 根据 病人ID 分页查询
     * @param pageNum
     * @param pageSize
     * @param beH_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<PricePeople> queryByIdAndPage(Integer pageNum, Integer pageSize, Integer beH_id) {
        PageHelper.startPage(pageNum, pageSize);
        List<PricePeople> pricePeople = pricePeopleMapper.selectByBeH_id(beH_id);
        return new PageInfo<>(pricePeople);
    }

    /**
     * 添加 病人 - 收费项目
     * @param pricePeople
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int addPriceProj(PricePeople pricePeople) {
        return pricePeopleMapper.insertSelective(pricePeople);
    }
}
