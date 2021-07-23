package com.murphy.interceptor;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 性能监控 - 记录拦截器 通过ThreadLocal实现
 *
 * @author murphy
 * @since 2021/7/23 2:02 下午
 */
public class PerformanceMonitorInterceptor extends HandlerInterceptorAdapter {

    private NamedThreadLocal<Long> threadLocal = new NamedThreadLocal<>("PerformanceMonitor");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 请求开始时间
        long startTime = System.currentTimeMillis();
        // 线程绑定变量 - 该数据只有当前的线程可见
        threadLocal.set(startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求结束时间
        long endTime = System.currentTimeMillis();
        // 获取线程绑定的局部变量
        long startTime = threadLocal.get();
        long elapse = endTime - startTime;
        //为了测试只要大于0就记录，一般设置为一个比较大的数，比如300，代表300毫秒
        if(elapse > 0){
            System.out.println(String.format("%s elapse %d 毫秒", request.getRequestURI(), elapse));
        }
    }
}
