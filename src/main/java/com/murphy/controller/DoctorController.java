package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.Doctor;
import com.murphy.service.DoctorService;
import com.murphy.vo.query.QueryDoctorVo;
import com.murphy.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

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

    /**
     * 主键查询
     * @param d_id
     * @return
     */
    @RequestMapping(value = "{d_id}", method = RequestMethod.GET)
    public ResultVo<Doctor> queryById(@PathVariable("d_id") Integer d_id) {
        Doctor doctor = doctorService.queryById(d_id);
        return new ResultVo<>(doctor);
    }

    /**
     * 新增医生信息
     * @param doctor
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultVo<Doctor> addDoc(Doctor doctor) {
        doctor.setD_inTime(new Date());
        doctor.setD_state(0);
        int i = doctorService.addDoc(doctor);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 逻辑删除 - state -> 1 (离职)
     * @param d_id
     * @return
     */
    @RequestMapping(value = "delete/{d_id}", method = RequestMethod.DELETE)
    public ResultVo<Doctor> deleteDoc(@PathVariable("d_id") Integer d_id) {
        int i = doctorService.deleteDoc(d_id);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 更新学生信息
     * @param d_id
     * @param doctor
     * @return
     */
    @RequestMapping(value = "update/{d_id}", method = RequestMethod.PUT)
    public ResultVo<Doctor> updateDoc(@PathVariable("d_id") Integer d_id, Doctor doctor) {
        doctor.setD_id(d_id);

        int i = doctorService.updateDoc(doctor);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }
}
