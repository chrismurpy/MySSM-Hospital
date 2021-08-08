package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.Drug;
import com.murphy.service.DrugService;
import com.murphy.vo.ResultVo;
import com.murphy.vo.query.QueryDrugVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 药品管理 - Controller层
 *
 * @author murphy
 * @since 2021/8/8 2:21 下午
 */
@Controller
@RequestMapping("drug")
@ResponseBody
public class DrugController {

    @Resource
    private DrugService drugService;

    /**
     * 多条件分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<Drug> queryByPage(Integer pageNum, Integer pageSize, QueryDrugVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<Drug> drugPageInfo = drugService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(drugPageInfo);
    }

    /**
     * 主键查询
     *
     * @param dr_id
     * @return
     */
    @RequestMapping(value = "{dr_id}", method = RequestMethod.GET)
    public ResultVo<Drug> queryById(@PathVariable("dr_id") Integer dr_id) {
        Drug drug = drugService.queryById(dr_id);
        return new ResultVo<>(drug);
    }

    /**
     * 添加药品信息
     *
     * @param drug
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVo<Drug> addDrug(Drug drug) {
        drug.setDr_state(0);
        int i = drugService.addDrug(drug);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 下架药品
     *
     * @param dr_id
     * @return
     */
    @RequestMapping(value = "delete/{dr_id}", method = RequestMethod.DELETE)
    public ResultVo<Drug> delDrug(@PathVariable("dr_id") int dr_id) {
        int i = drugService.delDrug(dr_id);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 重新上架药品
     *
     * @param dr_id
     * @return
     */
    @RequestMapping(value = "reAdd/{dr_id}", method = RequestMethod.PUT)
    public ResultVo<Drug> reAddDrug(@PathVariable("dr_id") int dr_id) {
        int i = drugService.reAddDrug(dr_id);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 更改药品信息
     *
     * @param dr_id
     * @param drug
     * @return
     */
    @RequestMapping(value = "update/{dr_id}", method = RequestMethod.PUT)
    public ResultVo<Drug> updateDrug(@PathVariable("dr_id") Integer dr_id, Drug drug) {
        drug.setDr_id(dr_id);
        int i = drugService.updateDrug(drug);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 添加库存
     * @param dr_id
     * @param dr_addNum
     * @return
     */
    @RequestMapping(value = "addNum/{dr_id}", method = RequestMethod.POST)
    public ResultVo<Drug> addDrugNum(@PathVariable("dr_id") Integer dr_id, Integer dr_addNum) {
        Drug drug = drugService.queryById(dr_id);
        Integer dr_number = drug.getDr_number();
        if (dr_addNum >= 0) {
            Integer newNum = dr_number + dr_addNum;
            drug.setDr_number(newNum);
            int i = drugService.updateDrug(drug);
            if (i == 1) {
                return new ResultVo<>();
            }
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }
}
