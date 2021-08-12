package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.mapper.RoleMapper;
import com.murphy.pojo.Menu;
import com.murphy.pojo.Role;
import com.murphy.pojo.RoleMenu;
import com.murphy.pojo.User;
import com.murphy.service.RoleMenuService;
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
 *
 * @author Ann
 * @create 2021-08-08 21:18
 */
@Controller
@RequestMapping("role")
@ResponseBody
public class RoleController {

    @Resource
    private RoleService roleService;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 展示所有角色名
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public List selectRoleName() {
        List list = roleService.selectRoleName();
        return list;
    }

    /**
     * 多条件分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
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

    /**
     * 逻辑删除
     *
     * @param r_id
     * @return
     */
    @RequestMapping(value = "{r_id}", method = RequestMethod.DELETE)
    public ResultVo<User> deleteUser(@PathVariable("r_id") Integer r_id) {
        int i = roleService.deleteRole(r_id);
        if (i == 1) {
            return new ResultVo<User>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVo<Role> addRole(Role role) {
        int i = roleService.addRole(role);

        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 新增角色资源信息
     *
     * @return
     */
    @RequestMapping(value = "addMenu/{r_name}/{m_id}", method = RequestMethod.POST)
    public ResultVo<RoleMenu> addRoleMenu(@PathVariable("r_name") String r_name,
                                          @PathVariable("m_id") Integer m_id) {
        Role role = roleMapper.selectByRoleName(r_name);
        System.out.println(role);
        Integer r_id = role.getR_id();
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setR_id(r_id);
        roleMenu.setM_id(m_id);

        int i = roleMenuService.addRoleMenu(roleMenu);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 根据 r_id 查询
     *
     * @param r_id
     * @return
     */
    @RequestMapping(value = "query/{r_id}", method = RequestMethod.GET)
    public ResultVo<RoleMenu> queryByR_id(@PathVariable("r_id") Integer r_id) {
        List<RoleMenu> roleMenus = roleMenuService.queryById(r_id);
        return new ResultVo<>(roleMenus);
    }

    /**
     * 根据 r_id 查角色
     * @param r_id
     * @return
     */
    @RequestMapping(value = "queryRole/{r_id}", method = RequestMethod.GET)
    public ResultVo<Role> queryR_id(@PathVariable("r_id") Integer r_id) {
        Role role = roleMapper.queryByR_id(r_id);
        return new ResultVo<>(role);
    }

    /**
     * 根据 r_id 删除
     *
     * @param r_id
     * @return
     */
    @RequestMapping(value = "delete/{r_id}")
    public ResultVo<RoleMenu> deleteByR_id(@PathVariable("r_id") Integer r_id) {
        int i = roleMenuService.deleteByR_id(r_id);
        if (i == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 根据 r_id 更新
     *
     * @return
     */
    @RequestMapping(value = "update/{r_id}", method = RequestMethod.PUT)
    public ResultVo<RoleMenu> updateByR_id(@PathVariable("r_id")Integer r_id, Role role) {
        role.setR_id(r_id);

        int update = roleMapper.updateByPrimaryKeySelective(role);
        if (update == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }
}
