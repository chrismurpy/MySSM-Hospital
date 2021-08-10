package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DrugMapper;
import com.murphy.mapper.DrugPeopleMapper;
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
    @Resource
    private DrugPeopleMapper drugPeopleMapper;

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
        Integer people_id = drugPeople.getPeople_id();

        drugPeople.setDr_id(dr_id);
        drugPeople.setDr_outNum(0);

        Integer flag = drugPeopleService.queryExist(dr_id, people_id);
        if (flag == 0) {
            int i = drugPeopleService.addDrugPeople(drugPeople);
            if (i == 1) {
                return new ResultVo<>();
            }
        } else if (flag == 1) {
            return new ResultVo<>(500,"订单已存在，无法新增信息！");
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 批量新增发药信息 - 最大处理量：5
     * @param drp_number
     * @param dr_name
     * @return
     */
    @RequestMapping(value = "adds/{people_id}", method = RequestMethod.POST)
    public ResultVo<DrugPeople> addDrugPeoples(@PathVariable("people_id") Integer people_id, Integer drp_number,
                                               @RequestParam("dr_name") String dr_name) {
        DrugPeople drugPeople = new DrugPeople();
        Drug drug = drugMapper.selectByName(dr_name);
        Integer dr_id = drug.getDr_id();
        drugPeople.setPeople_id(people_id);
        drugPeople.setdrp_number(drp_number);
        drugPeople.setDr_id(dr_id);
        drugPeople.setDr_outNum(0);

        Integer flag = drugPeopleService.queryExist(dr_id, people_id);
        if (flag == 0) {
            int i = drugPeopleService.addDrugPeople(drugPeople);
            if (i == 1) {
                return new ResultVo<>();
            }
        } else if (flag == 1) {
            return new ResultVo<>(500,"订单已存在，无法新增信息！");
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 新增发药量
     * @param dr_id
     * @param people_id
     * @return
     */
    @RequestMapping(value = "addNum/{dr_id}/{people_id}", method = RequestMethod.POST)
    public ResultVo<DrugPeople> addDrugNum(@PathVariable("dr_id") Integer dr_id,
                                           @PathVariable("people_id") Integer people_id, Integer addNum) {
        DrugPeople drugPeople = drugPeopleMapper.queryByDr_idAndP_id(dr_id, people_id);
        Integer drp_number = drugPeople.getdrp_number();
        if (addNum >= 0) {
            drp_number += addNum;
            drugPeople.setdrp_number(drp_number);
        } else {
            return new ResultVo<>(500,"数量输入有误！");
        }
        int i = drugPeopleService.updateDrugPeople(drugPeople);
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

    /**
     * 发药操作
     * @param dr_id
     * @param people_id
     * @param drp_remain
     * @return
     */
    @RequestMapping(value = "send/{dr_id}/{people_id}", method = RequestMethod.POST)
    public ResultVo<DrugPeople> updateDrugPeople(@PathVariable("dr_id") Integer dr_id,
                                                 @PathVariable("people_id") Integer people_id, Integer drp_remain) {
        DrugPeople drugPeople = drugPeopleMapper.queryByDr_idAndP_id(dr_id, people_id);

        Integer send = drugPeople.getDr_outNum() + drp_remain;
        drugPeople.setDr_outNum(send);

        Integer drp_number = drugPeople.getdrp_number();
        Integer dr_outNum = drugPeople.getDr_outNum();
        Integer remain = drp_number - dr_outNum;

        Integer drId = drugPeople.getDr_id();
        Drug drug = drugMapper.selectByPrimaryKey(drId);

        Integer dr_number = drug.getDr_number();
        dr_number = dr_number - drp_remain;

        if (dr_number < 0) {
            return new ResultVo<>(500,"库存不足，无法发药！");
        } else if (drp_remain > remain) {
            return new ResultVo<>(500,"发放量大于需求量！");
        }
        drug.setDr_number(dr_number);
        drugMapper.updateByPrimaryKeySelective(drug);

        int i = drugPeopleService.updateDrugPeople(drugPeople);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 根据 药品ID + 病例ID 查找
     * @param dr_id
     * @param people_id
     * @return
     */
    @RequestMapping(value = "query/{dr_id}/{people_id}", method = RequestMethod.GET)
    public ResultVo<DrugPeople> queryByIds(@PathVariable("dr_id") Integer dr_id,
                                           @PathVariable("people_id") Integer people_id) {
        DrugPeople drugPeople = drugPeopleService.queryByIds(dr_id, people_id);
        return new ResultVo<>(drugPeople);
    }
}
