package com.murphy.controller;

import com.murphy.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色 - Controller层
 * @author Ann
 * @create 2021-08-08 21:18
 */
@Controller
@RequestMapping("role")
@ResponseBody
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public List selectRoleName(){
        List list = roleService.selectRoleName();
        return list;
    }

}
