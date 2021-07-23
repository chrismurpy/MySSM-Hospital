package com.murphy.controller;

import com.murphy.pojo.User;
import com.murphy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    /**
     * 登录功能实现
     * @param session
     * @param mv
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpSession session, ModelAndView mv, User user){
        System.out.println("Login：" + user.getU_trueName());
        session.setAttribute("username", user.getU_trueName());
        if (userService.login(user)){
            mv.setViewName("index");
        } else {
            mv.addObject("msg","用户名或者密码有误！");
            mv.setViewName("login");
        }
        return mv;
    }

    /**
     * 注销功能实现
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
}
