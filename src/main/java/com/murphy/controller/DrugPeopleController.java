package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DrugMapper;
import com.murphy.pojo.BeHosp;
import com.murphy.pojo.Drug;
import com.murphy.pojo.DrugPeople;
import com.murphy.service.DrugPeopleService;
import com.murphy.vo.ResultVo;
import com.murphy.vo.query.QueryDrugPeopleVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 在线发药 - Controller
 *
 * @author murphy
 * @since 2021/8/9 1:06 下午
 */
@Controller
@RequestMapping("drugPeople")
@ResponseBody
public class DrugPeopleController {

    @Resource
    private DrugPeopleService drugPeopleService;
    @Resource
    private DrugMapper drugMapper;

    /**
     * 多条件分页查询 - 通过住院表获取住院人员信息
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<BeHosp> queryByPage(Integer pageNum, Integer pageSize, QueryDrugPeopleVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<BeHosp> beHospPageInfo = drugPeopleService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(beHospPageInfo);
    }

    /**
     * 根据主键分页查询
     * @param pageNum
     * @param pageSize
     * @param beH_id
     * @return
     */
    @RequestMapping(value = "find/{beH_id}", method = RequestMethod.GET)
    public ResultVo<DrugPeople> queryByIdAndPage(Integer pageNum, Integer pageSize,
                                                 @PathVariable("beH_id") Integer beH_id) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<DrugPeople> peoplePageInfo = drugPeopleService.queryByIdAndPage(pageNum, pageSize, beH_id);
        return new ResultVo<>(peoplePageInfo);
    }

    /**
     * 新增发药信息
     * @param drugPeople
     * @param dr_name
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVo<DrugPeople> addDrugPeople(DrugPeople drugPeople, @RequestParam("dr_name") String dr_name) {
        Drug drug = drugMapper.selectByName(dr_name);
        Integer dr_id = drug.getDr_id();
        drugPeople.setDr_id(dr_id);
        drugPeople.setDr_outNum(0);

        int i = drugPeopleService.addDrugPeople(drugPeople);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 获取所有药品名
     * @return
     */
    @RequestMapping(value = "drug", method = RequestMethod.GET)
    public List selectDrugName() {
        List drugName = drugPeopleService.getDrugName();
        return drugName;
    }
}
