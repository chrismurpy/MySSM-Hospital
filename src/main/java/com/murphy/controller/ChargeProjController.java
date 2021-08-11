package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.ChargeProj;
import com.murphy.pojo.PricePeople;
import com.murphy.service.ChargeProjService;
import com.murphy.vo.ResultVo;
import com.murphy.vo.query.QueryChargeProjVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * 收费项目管理 - Controller层
 *
 * @author murphy
 * @since 2021/8/7 2:39 下午
 */
@Controller
@RequestMapping("charP")
@ResponseBody
public class ChargeProjController {

    @Resource
    private ChargeProjService chargeProjService;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<ChargeProj> queryByPage(Integer pageNum, Integer pageSize, QueryChargeProjVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<ChargeProj> chargeProjPageInfo = chargeProjService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(chargeProjPageInfo);
    }

    /**
     * 主键查询
     * @param charP_id
     * @return
     */
    @RequestMapping(value = "{charP_id}", method = RequestMethod.GET)
    public ResultVo<ChargeProj> queryById(@PathVariable("charP_id") Integer charP_id) {
        ChargeProj chargeProj = chargeProjService.queryById(charP_id);
        return new ResultVo<>(chargeProj);
    }

    /**
     * 收费项目 - 更新
     * @param charP_id
     * @return
     */
    @RequestMapping(value = "update/{charP_id}", method = RequestMethod.PUT)
    public ResultVo<ChargeProj> updateCharProj(@PathVariable("charP_id") Integer charP_id, ChargeProj proj) {
        proj.setCharP_id(charP_id);

        int i = chargeProjService.updateCharProj(proj);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 删除
     * @param charP_id
     * @return
     */
    @RequestMapping(value = "delete/{charP_id}", method = RequestMethod.DELETE)
    public ResultVo<ChargeProj> deleteCharProj(@PathVariable("charP_id") Integer charP_id) {
        int i = chargeProjService.deleteCharProj(charP_id);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 新增收费项目
     * @param proj
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVo<ChargeProj> addCharProj(ChargeProj proj) {
        proj.setCharP_createTime(new Timestamp(System.currentTimeMillis()));
        proj.setCharP_state(0);
        int i = chargeProjService.addCharProj(proj);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 获取 收费项目名
     * @return
     */
    @RequestMapping(value = "queryName", method = RequestMethod.GET)
    public List<ChargeProj> queryChargeProjName() {
        List list = chargeProjService.queryChargeProjName();
        return list;
    }

    /**
     * 根据 收费项目名 - 查询
     * @param charP_name
     * @return
     */
    @RequestMapping(value = "query/{charP_name}")
    public ResultVo<ChargeProj> queryByName(@PathVariable("charP_name") String charP_name) {
        ChargeProj chargeProj = chargeProjService.queryByName(charP_name);
        return new ResultVo<>(chargeProj);
    }
}
