package com.blog.conf;

import com.blog.dataobject.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huangfu
 */
@Configuration
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    /**
     * 前置拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        if(userInfo != null){
            return true;
        }
        //没有登陆跳转登录页
        String url = "/login.html";
        response.sendRedirect(url);
        return false;
    }
}
