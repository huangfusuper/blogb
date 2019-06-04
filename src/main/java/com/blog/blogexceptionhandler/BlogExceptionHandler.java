package com.blog.blogexceptionhandler;


import com.alibaba.fastjson.JSON;
import com.blog.utils.ResponseResultVoUtil;
import com.blog.utils.ServletUtils;
import com.blog.utils.StringUtils;
import com.blog.vo.ResponseResultVO;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常跳转
 * @author huangfu
 */
@RestControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseResultVO errorHandler(HttpServletRequest reqest,
                                         HttpServletResponse response, UnauthorizedException e) throws Exception {

        e.printStackTrace();

        if(ServletUtils.isAjaxRequest(reqest)){
            ResponseResultVoUtil.failure("BLOG565621",StringUtils.getPermissionData(e.getMessage()));
        }
        return ResponseResultVoUtil.failure("BLOG565622",StringUtils.getPermissionData("未知错误！"+e.getMessage()));
    }
}
