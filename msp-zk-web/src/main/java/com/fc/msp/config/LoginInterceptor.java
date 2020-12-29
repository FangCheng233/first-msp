package com.fc.msp.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/17 9:45 下午
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取http 请求路径
//        threadLocal.set("");
        if (request.getMethod().equalsIgnoreCase("GET")) {
            if (request.getRequestURI().startsWith("/api")) {
                String params = request.getQueryString();
                String env = params.substring(params.lastIndexOf("=")+1,params.length());
                threadLocal.set(env);
            }
        }
        if (request.getMethod().equalsIgnoreCase("POST")) {

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        threadLocal.remove();
    }
}
