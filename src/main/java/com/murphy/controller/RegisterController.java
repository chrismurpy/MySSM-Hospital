package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DoctorMapper;
import com.murphy.pojo.Doctor;
import com.murphy.pojo.Keshi;
import com.murphy.pojo.Register;
import com.murphy.service.DoctorService;
import com.murphy.service.KeshiService;
import com.murphy.service.RegisterService;
import com.murphy.vo.RegisterQueryVo;
import com.murphy.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 挂号信息管理 - 控制器层
 *
 * @author murphy
 * @since 2021/7/27 11:55 上午
 */
@Controller
@RequestMapping("register")
@ResponseBody
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @Resource
    private DoctorMapper doctorMapper;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<Register> queryByPage(Integer pageNum, Integer pageSize, RegisterQueryVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<Register> registerPageInfo = registerService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(registerPageInfo);
    }

    /**
     * 添加挂号信息
     * @param register
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultVo<Register> addRegister(Register register,@RequestParam("d_name") String d_name){
        Doctor doctor = doctorMapper.selectByName(d_name);
        Integer d_id = doctor.getD_id();

        register.setD_id(d_id);
        register.setRe_createTime(new Timestamp(System.currentTimeMillis()));
        register.setRe_state(0);

        System.out.println(register);
        int i = registerService.addRegister(register);
        if (i == 1) {
            return new ResultVo<Register>();
        }
        return new ResultVo<>(500,"服务器内部异常，请稍后再试！");
    }
}