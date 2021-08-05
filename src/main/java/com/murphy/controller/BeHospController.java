package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.BeHosp;
import com.murphy.service.BeHospService;
import com.murphy.vo.BeHospQueryVo;
import com.murphy.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 住院办理 - Controller层
 *
 * @author murphy
 * @since 2021/8/5 2:14 下午
 */
@Controller
@RequestMapping("hosp")
@ResponseBody
public class BeHospController {

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
    public ResultVo<BeHosp> queryByPage(Integer pageNum, Integer pageSize, BeHospQueryVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<BeHosp> beHospPageInfo = beHospService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(beHospPageInfo);
    }

    /**
     * 主键查询
     * @param beH_id
     * @return
     */
    @RequestMapping(value = "{beH_id}", method = RequestMethod.GET)
    public ResultVo<BeHosp> queryById(@PathVariable("beH_id") Integer beH_id) {
        BeHosp beHosp = beHospService.queryById(beH_id);
        return new ResultVo<>(beHosp);
    }
}
