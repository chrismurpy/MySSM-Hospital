package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.Doctor;
import com.murphy.service.DoctorService;
import com.murphy.vo.query.QueryDoctorVo;
import com.murphy.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 医生表 - 控制器层
 *
 * @author murphy
 * @since 2021/8/3 4:26 下午
 */
@Controller
@RequestMapping("doctor")
@ResponseBody
public class DoctorController {

    @Resource
    private DoctorService doctorService;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<Doctor> queryByPage(Integer pageNum, Integer pageSize, QueryDoctorVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<Doctor> doctorPageInfo = doctorService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(doctorPageInfo);
    }
}
