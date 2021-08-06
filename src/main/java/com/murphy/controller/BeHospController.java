package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DoctorMapper;
import com.murphy.pojo.BeHosp;
import com.murphy.pojo.Doctor;
import com.murphy.pojo.Register;
import com.murphy.service.BeHospService;
import com.murphy.service.RegisterService;
import com.murphy.vo.BeHospQueryVo;
import com.murphy.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private RegisterService registerService;
    @Resource
    private RegisterController registerController;

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

    /**
     * 更新
     * @param beH_id
     * @param beHosp
     * @param d_name
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResultVo<Register> updateBeHosp(@PathVariable("id") Integer beH_id, BeHosp beHosp,
                                           @RequestParam("d_name") String d_name) {
        beHosp.setBeH_id(beH_id);
        Doctor doctor = doctorMapper.selectByName(d_name);
        Integer d_id = doctor.getD_id();
        beHosp.setD_id(d_id);
        beHosp.setDoctor(doctor);
        beHosp.setRegister(registerService.queryById(beH_id));

        int i = beHospService.updateBeHosp(beHosp);
        if (i == 1) {
            return new ResultVo<Register>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 缴费
     * @param beH_id
     * @param money
     * @return
     */
    @RequestMapping(value = "addMoney/{beH_id}")
    public ResultVo<BeHosp> updateCharge(@PathVariable("beH_id") Integer beH_id, Integer money) {
        BeHosp beHosp = beHospService.queryById(beH_id);
        Long beH_antecedent = beHosp.getBeH_antecedent();
        Integer remain = beHosp.getBeH_remain();
        Integer total = beHosp.getBeH_total();
        int beH_total = total + money;
        int beH_remain = remain - money;
        if (beH_total <= beH_antecedent && beH_remain >= 0 && money >= 0) {
            beHosp.setBeH_total(beH_total);
            beHosp.setBeH_remain(beH_remain);
            int i = beHospService.updateBeHosp(beHosp);
            if (i == 1) {
                return new ResultVo<>();
            }
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }
}
