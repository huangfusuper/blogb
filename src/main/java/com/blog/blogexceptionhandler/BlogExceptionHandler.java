package com.blog.blogexceptionhandler;


import com.blog.utils.HttpUtil;
import com.blog.utils.ResponseResultVoUtil;
import com.blog.utils.StringUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常跳转
 * @author huangfu
 */
@RestControllerAdvice
public class BlogExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogExceptionHandler.class);
    /**
     * 权限不足 全局异常
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public Object errorHandler( HttpServletRequest request, AuthorizationException e) throws Exception {
        LOGGER.info("---------------出现异常，异常信息为【{}】------------",e.getMessage());
        //如果是Ajax请求就返回一个json字符串，否则就跳转页面
        if(HttpUtil.isAjaxRequest(request)){
            LOGGER.info("---------------------是ajax,返回json字符串--------------------");
            return ResponseResultVoUtil.failure("BLOG565621",StringUtils.getPermissionData(e.getMessage()));
        }else{
            ModelAndView modelAndView = new ModelAndView();
            LOGGER.info("---------------------不是ajax,开始跳转界面--------------------");
            modelAndView.setViewName("/login/login");
            return modelAndView;
        }
    }
}
