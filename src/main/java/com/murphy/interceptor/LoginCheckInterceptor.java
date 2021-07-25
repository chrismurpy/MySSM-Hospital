package com.murphy.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检测 - 访问控制
 *
 * @author murphy
 * @since 2021/7/23 1:54 下午
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 登录界面 - 放行
        if (request.getRequestURI().contains("log")) {
            return true;
        }
        // 2. 如果用户已登陆 - 放行
        if (request.getSession().getAttribute("username") != null) {
            return true;
        } else {
            // 3. 非法请求 - 即该请求必须登录后才能访问，重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
    }
}
