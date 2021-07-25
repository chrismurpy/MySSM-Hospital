package com.murphy.controller;

import com.murphy.pojo.User;
import com.murphy.service.UserService;
import com.murphy.util.RandomValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        if (user.getU_LoginName() != null && user.getU_password() != null && user.getU_password() != ""){
            if (userService.login(user) && verify.equalsIgnoreCase(code)) {
                session.setAttribute("username", result.getU_trueName());
                mv.setViewName("index");
            } else if(verify == null || verify == "") {
                mv.addObject("msg","验证码不能为空！");
                mv.setViewName("login");
            } else if (!verify.equalsIgnoreCase(code)) {
                mv.addObject("msg","验证码输入错误！");
                mv.setViewName("login");
            } else {
                mv.addObject("msg", "用户名或者密码有误！");
                mv.setViewName("login");
            }
        } else {
            mv.addObject("msg","用户名或者密码不能为空！");
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
}
