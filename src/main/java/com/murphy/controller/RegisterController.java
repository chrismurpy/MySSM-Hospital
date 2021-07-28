package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.Register;
import com.murphy.service.RegisterService;
import com.murphy.vo.RegisterQueryVo;
import com.murphy.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
}
