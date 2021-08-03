package com.murphy.controller;

import com.murphy.mapper.DoctorMapper;
import com.murphy.pojo.Keshi;
import com.murphy.service.DoctorService;
import com.murphy.service.KeshiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科室 - Controller层
 *
 * @author murphy
 * @since 2021/8/3 5:24 下午
 */
@Controller
@RequestMapping("keshi")
@ResponseBody
public class KeshiController {
    @Resource
    private KeshiService keshiService;

    @Resource
    private DoctorMapper doctorMapper;

    /**
     * 获取全部科室
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List selectKeshi(){
        List list = keshiService.selectKeshi();
        return list;
    }

    /**
     * 科室级联医生
     * @param k_id
     * @return
     */
    @RequestMapping(value = "{k_id}", method = RequestMethod.GET)
    public List selectDoctor(@PathVariable("k_id") Integer k_id){
        k_id += 1;

        Keshi keshi = keshiService.queryById(k_id);
        String d_keshi = keshi.getD_keshi();

        List keshiList = doctorMapper.selectByKeshi(d_keshi);
        return keshiList;
    }
}
