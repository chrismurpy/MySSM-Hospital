package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DoctorMapper;
import com.murphy.pojo.BeHosp;
import com.murphy.pojo.Doctor;
import com.murphy.pojo.Register;
import com.murphy.service.BeHospService;
import com.murphy.service.RegisterService;
import com.murphy.vo.query.QueryBeHospVo;
import com.murphy.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;

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

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<BeHosp> queryByPage(Integer pageNum, Integer pageSize, QueryBeHospVo vo) {
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
     * 更新住院信息
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
    public ResultVo<BeHosp> updateCharge(@PathVariable("beH_id") Integer beH_id, Integer money, Integer remain) {
        BeHosp beHosp = beHospService.queryById(beH_id);
        Long beH_antecedent = beHosp.getBeH_antecedent();
        Integer total = beHosp.getBeH_total();
        Integer beH_remain = beHosp.getBeH_remain();
        if (remain == null) {
            remain = 0;
        }
        int beH_total = total + money;
        int remain_new = beH_remain + remain + money;
        if (beH_total <= beH_antecedent && money >= 0 && remain >= 0) {
            beHosp.setBeH_remain(remain_new);
            beHosp.setBeH_total(beH_total);
            if (beH_antecedent == beH_total) {
                beHosp.setBeH_closePrice(1);
            }
            int i = beHospService.updateBeHosp(beHosp);
            if (i == 1) {
                return new ResultVo<>();
            }
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 添加住院信息
     * @param beH_id
     * @param beH_nurse
     * @param beH_bedNum
     * @param beH_antecedent
     * @param beH_illness
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVo<BeHosp> addHosp(Integer beH_id, String beH_nurse, String beH_bedNum,
                                    Long beH_antecedent, String beH_illness, Integer beH_total, Integer beH_remain) {
        Register register = registerService.queryById(beH_id);
        if (register.getRe_state() == 0 && register.getRe_id() != null) {
            register.setRe_state(1);
            registerService.updateRegister(register);

            BeHosp beHosp = new BeHosp();
            beHosp.setBeH_id(beH_id);
            beHosp.setBeH_nurse(beH_nurse);
            beHosp.setBeH_bedNum(beH_bedNum);
            beHosp.setBeH_antecedent(beH_antecedent);
            beHosp.setBeH_illness(beH_illness);
            beHosp.setBeH_state(0);
            beHosp.setBeH_createTime(new Timestamp(System.currentTimeMillis()));
            beHosp.setBeH_total(beH_total);
            beHosp.setBeH_charge(0);
            beHosp.setBeH_closePrice(0);
            beHosp.setBeH_remain(beH_total + beH_remain);
            beHosp.setD_id(register.getD_id());
            beHosp.setDoctor(register.getDoctor());
            beHosp.setRegister(register);

            int i = beHospService.addBeHosp(beHosp);
            if (i == 1) {
                return new ResultVo<>();
            }
        } else if (register.getRe_state() == 1) {
            return new ResultVo<>(500,"此病人已住院！");
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 住院办理 - 退院
     * @param beH_id
     * @return
     */
    @RequestMapping(value = "quitHosp/{beH_id}", method = RequestMethod.PUT)
    public ResultVo<BeHosp> quitHosp(@PathVariable("beH_id") Integer beH_id) {
        BeHosp beHosp = beHospService.queryById(beH_id);
        if (beHosp.getBeH_closePrice() == 1) {
            beHosp.setBeH_state(1);

            Register register = registerService.queryById(beH_id);
            register.setRe_state(2);

            int i = registerService.updateRegister(register);
            int j = beHospService.updateBeHosp(beHosp);
            if (i == 1 && j == 1) {
                return new ResultVo<>();
            }
        } else if (beHosp.getBeH_closePrice() == 0) {
            return new ResultVo<>(500,"未完成缴费，无法进行退院操作！");
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }

    /**
     * 住院办理 - 出院
     * @param beH_id
     * @return
     */
    @RequestMapping(value = "exitHosp/{beH_id}", method = RequestMethod.PUT)
    public ResultVo<BeHosp> exitHosp(@PathVariable("beH_id") Integer beH_id) {
        BeHosp beHosp = beHospService.queryById(beH_id);
        if (beHosp.getBeH_closePrice() == 1) {
            beHosp.setBeH_state(2);

            Register register = registerService.queryById(beH_id);
            register.setRe_state(2);

            int i = registerService.updateRegister(register);
            int j = beHospService.updateBeHosp(beHosp);
            if (i == 1 && j == 1) {
                return new ResultVo<>();
            }
        } else if (beHosp.getBeH_closePrice() == 0) {
            return new ResultVo<>(500,"未完成缴费，无法进行出院操作！");
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }
}
