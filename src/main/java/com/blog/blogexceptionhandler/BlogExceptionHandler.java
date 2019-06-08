package com.blog.blogexceptionhandler;


import com.blog.enums.superenum.IEnum;
import com.blog.exceptions.BlogException;
import com.blog.exceptions.superexception.IException;
import com.blog.utils.HttpUtil;
import com.blog.utils.ResponseResultVoUtil;
import com.blog.utils.StringUtils;
import com.blog.vo.ResponseResultVO;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常跳转
 * @author huangfu
 */
@ControllerAdvice
public class BlogExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogExceptionHandler.class);
    /**
     * 权限不足 全局异常
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object errorHandler( HttpServletRequest request, Exception e) throws Exception {
        ResponseResultVO<Object> responseResult = new ResponseResultVO<Object>();
        if(e instanceof UnauthenticatedException){
            return ResponseResultVoUtil.failure("BLOG565620","权限认证失败");
        }else if(e instanceof UnauthorizedException){
            return ResponseResultVoUtil.failure("BLOG565621",StringUtils.getPermissionData(e.getMessage()));
        }else if(e instanceof BlogException){
            responseMessage(responseResult,e);
            return responseResult;
        }
        return null;
    }
    private void responseMessage(ResponseResultVO<Object> responseResult,Exception ex) {
         IException iException= (IException)ex;
        IEnum iEnumClass = iException.getIEnumClass();
        responseResult.setCode(iEnumClass.getCode());
        responseResult.setMsg(iEnumClass.getMsg());
    }
}
