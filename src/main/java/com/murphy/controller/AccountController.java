package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.BeHosp;
import com.murphy.service.AccountService;
import com.murphy.service.BeHospService;
import com.murphy.vo.ResultVo;
import com.murphy.vo.query.QueryAccountVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 住院结算 - Controller - 缴费情况
 *
 * @author murphy
 * @since 2021/8/7 11:40 上午
 */
@Controller
@RequestMapping("account")
@ResponseBody
public class AccountController {

    @Resource
    private AccountService accountService;
    @Resource
    private BeHospService beHospService;

    /**
     * 住院结算情况 - 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<BeHosp> queryByPage(Integer pageNum, Integer pageSize, QueryAccountVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }

        PageInfo<BeHosp> beHospPageInfo = accountService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(beHospPageInfo);
    }

    /**
     * 押金 - 结算
     * @param beH_id
     * @return
     */
    @RequestMapping(value = "change", method = RequestMethod.POST)
    public ResultVo<BeHosp> updateCharge(Integer beH_id, Integer remain) {
        BeHosp beHosp = beHospService.queryById(beH_id);

        beHosp.setBeH_total(beHosp.getBeH_total() + remain);
        beHosp.setBeH_remain(beHosp.getBeH_remain() + remain);
        Integer beH_antecedent = Math.toIntExact(beHosp.getBeH_antecedent());
        Integer beH_total = beHosp.getBeH_total();
        if (beH_total.equals(beH_antecedent)) {
            beHosp.setBeH_closePrice(1);
            int i = beHospService.updateBeHosp(beHosp);
            if (i == 1) {
                return new ResultVo<>();
            }
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }
}
