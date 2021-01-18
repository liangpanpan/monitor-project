package com.qs.monitor.interceptor;

import com.qs.monitor.common.annotation.Authorization;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/17       create this file
 * </pre>
 */
public class AuthInterceptor implements HandlerInterceptor {
    /**
     * 处理之前调用的方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拦截处理代码
        HandlerMethod method = (HandlerMethod) handler;
        Authorization authorization = method.getMethodAnnotation(Authorization.class);
        if (null != authorization) {
            //这个是需要拦截的方法

        } else {
            //这个是不需要拦截的方法

        }
        //返回true通过，返回false拦截
        return true;
    }
}
