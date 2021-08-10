package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.mapper.RoleMapper;
import com.murphy.pojo.Role;
import com.murphy.pojo.User;
import com.murphy.service.RoleService;
import com.murphy.service.UserService;
import com.murphy.util.RandomLoginName;
import com.murphy.util.RandomValidateCode;
import com.murphy.vo.ResultVo;
import com.murphy.vo.UserQueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户 - 登录 / 注销 功能实现
 *
 * @author murphy
 * @since 2021/7/23 2:19 下午
 */
@Controller
@ResponseBody
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RoleMapper roleMapper;

    /**
     * 登录功能实现
     *
     * @param session
     * @param mv
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpSession session, ModelAndView mv, User user, String verify) {
        System.out.println("Login：" + user.getU_LoginName());
        User result = userService.queryUser(user);
        String code = (String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
        if (user.getU_LoginName() != null && user.getU_password() != null && user.getU_password() != "") {
            if (userService.login(user) && verify.equalsIgnoreCase(code)) {
                session.setAttribute("username", result.getU_trueName());
                session.setAttribute("loginPassword", result.getU_password());
                mv.setViewName("index");
            } else if (verify == null || verify == "") {
                mv.addObject("msg", "验证码不能为空！");
                mv.setViewName("login");
            } else if (!verify.equalsIgnoreCase(code)) {
                mv.addObject("msg", "验证码输入错误！");
                mv.setViewName("login");
            } else {
                mv.addObject("msg", "用户名或者密码有误！");
                mv.setViewName("login");
            }
        } else {
            mv.addObject("msg", "用户名或者密码不能为空！");
            mv.setViewName("login");
        }
        return mv;
    }

    /**
     * 注销功能实现
     *
     * @param session
     * @param mv
     * @return
     */
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session, ModelAndView mv) {
        System.out.println("Logout -");
        session.invalidate();
        mv.setViewName("login");
        return mv;
    }

    /**
     * 获取生成验证码显示到 UI 界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");

        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            //输出图片方法
            randomValidateCode.getRandcode(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 多条件分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    @RequestMapping(value = "/User/index", method = RequestMethod.GET)
    public ResultVo<User> queryByPage(Integer pageNum, Integer pageSize, UserQueryVo vo) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        PageInfo<User> userPageInfo = userService.queryByPage(pageNum, pageSize, vo);
        return new ResultVo<>(userPageInfo);
    }

    /**
     * 主键查询用户信息
     *
     * @param u_id
     * @return
     */
    @RequestMapping(value = "/User/{u_id}", method = RequestMethod.GET)
    public ResultVo<User> queryById(@PathVariable("u_id") Integer u_id) {
        User user = userService.queryById(u_id);
        return new ResultVo<>(user);
    }

    /**
     * 根据主键更新用户
     *
     * @param u_id
     * @param user
     * @return
     */
    @RequestMapping(value = "/User/{u_id}", method = RequestMethod.PUT)
    public ResultVo<User> updateTeam(@PathVariable("u_id") Integer u_id, User user,
                                     @RequestParam("r_name") String r_name) {
        user.setU_LoginName(u_id);
        System.out.println(r_name);
        Role role = roleMapper.selectByRoleName(r_name);
        Integer r_id = role.getR_id();
        user.setR_id(r_id);
        user.setRole(role);

        int i = userService.updateUser(user);
        System.out.println(i);
        if (i == 1) {
            return new ResultVo<User>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 根据主键删除用户
     * 逻辑删除   u_state 变更为 1
     *
     * @param u_id
     * @return
     */
    @RequestMapping(value = "/User/{u_id}", method = RequestMethod.DELETE)
    public ResultVo<User> deleteUser(@PathVariable("u_id") Integer u_id) {
        int i = userService.deleteUser(u_id);
        if (i == 1) {
            return new ResultVo<User>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }

    /**
     * 新增用户
     *
     * @param r_name - 角色名
     * @return
     */
    @RequestMapping(value = "/User", method = RequestMethod.POST)
    public ResultVo<User> addUser(User user, @RequestParam("r_name") String r_name) {
        Role role = roleMapper.selectByRoleName(r_name);
        Integer r_id = role.getR_id();

        Integer loginName = RandomLoginName.getRandomLoginName();

        user.setU_LoginName(loginName);
        user.setR_id(r_id);
        user.setU_state(0);
        int i = userService.addUser(user);
        if (i == 1) {
            return new ResultVo<User>();
        }
        return new ResultVo<>(500, "服务器内部异常，请稍后再试！");
    }
}
