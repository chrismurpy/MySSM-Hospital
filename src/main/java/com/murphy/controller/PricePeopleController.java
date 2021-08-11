package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.BeHosp;
import com.murphy.pojo.ChargeProj;
import com.murphy.pojo.PricePeople;
import com.murphy.pojo.Register;
import com.murphy.service.BeHospService;
import com.murphy.service.ChargeProjService;
import com.murphy.service.PricePeopleService;
import com.murphy.service.RegisterService;
import com.murphy.vo.ResultVo;
import com.murphy.vo.query.QueryPricePeopleVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * 收费项目结算 - 病人 - Controller
 *
 * @author murphy
 * @since 2021/8/10 7:17 下午
 */
@Controller
@RequestMapping("price")
@ResponseBody
public class PricePeopleController {

    @Resource
    private PricePeopleService pricePeopleService;
    @Resource
    private ChargeProjService chargeProjService;
    @Resource
    private RegisterService registerService;
    @Resource
    private BeHospService beHospService;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<PricePeople> queryByPage(Integer pageNum, Integer pageSize, QueryPricePeopleVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<PricePeople> pricePeoplePageInfo = pricePeopleService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(pricePeoplePageInfo);
    }

    /**
     * 根据 病人ID 分页查询
     * @param pageNum
     * @param pageSize
     * @param beH_id
     * @return
     */
    @RequestMapping(value = "{beH_id}", method = RequestMethod.GET)
    public ResultVo<PricePeople> queryByIdAndPage(Integer pageNum, Integer pageSize,
                                                  @PathVariable("beH_id") Integer beH_id){
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<PricePeople> pageInfo = pricePeopleService.queryByIdAndPage(pageNum, pageSize, beH_id);
        return new ResultVo<>(pageInfo);
    }

    /**
     * 病人 - 添加收费项目
     * @param beH_id
     * @param charP_name
     * @param charP_money
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVo<PricePeople> addPriceProj(Integer beH_id, String charP_name, Integer charP_money) {
        PricePeople pricePeople = new PricePeople();
        pricePeople.setBeH_id(beH_id);

        ChargeProj chargeProj = chargeProjService.queryByName(charP_name);
        Integer charP_id = chargeProj.getCharP_id();
        pricePeople.setCharP_id(charP_id);

        pricePeople.setCheckTime(new Timestamp(System.currentTimeMillis()));

        BeHosp beHosp = beHospService.queryById(beH_id);
        Integer allCharge = beHosp.getBeH_charge() + charP_money;
        Integer remainMoney = beHosp.getBeH_remain() - charP_money;
        if (remainMoney >= 0) {
            beHosp.setBeH_charge(allCharge);
            beHosp.setBeH_remain(remainMoney);
            beHospService.updateBeHosp(beHosp);
        } else {
            return new ResultVo<>(500,"余额不足，请充值！");
        }

        int i = pricePeopleService.addPriceProj(pricePeople);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }
}
