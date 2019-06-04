package com.blog.blogexceptionhandler;


import com.blog.utils.ResponseResultVoUtil;
import com.blog.utils.StringUtils;
import com.blog.vo.ResponseResultVO;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常跳转
 * @author huangfu
 */
@RestControllerAdvice
public class BlogExceptionHandler {

    /**
     * 权限不足 全局异常
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseResultVO errorHandler(UnauthorizedException e) throws Exception {
        e.printStackTrace();
        return ResponseResultVoUtil.failure("BLOG565621",StringUtils.getPermissionData(e.getMessage()));
    }
}
