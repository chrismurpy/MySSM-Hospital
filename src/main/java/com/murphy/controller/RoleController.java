package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.pojo.Role;
import com.murphy.pojo.User;
import com.murphy.service.RoleService;
import com.murphy.vo.ResultVo;
import com.murphy.vo.UserQueryVo;
import com.murphy.vo.query.QueryRoleVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 展示所有角色名
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public List selectRoleName(){
        List list = roleService.selectRoleName();
        return list;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVo<Role> queryByPage(Integer pageNum, Integer pageSize, QueryRoleVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<Role> rolePageInfo = roleService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(rolePageInfo);
    }

    @RequestMapping(value = "{r_id}", method = RequestMethod.DELETE)
    public ResultVo<User> deleteUser(@PathVariable("r_id") Integer r_id) {
        int i = roleService.deleteRole(r_id);
        if (i == 1) {
            return new ResultVo<User>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

}
