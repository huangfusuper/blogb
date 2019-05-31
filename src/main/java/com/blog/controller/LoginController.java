package com.blog.controller;

import com.blog.utils.HttpUtil;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录入口
 * @author 皇甫
 */
@RestController
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("login.html")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request){
        LOG.info("------------IP【{}】，访问登录页主界面--------------", HttpUtil.getIpAddress(request));
        modelAndView.setViewName("/login/login");
        return modelAndView;
    }
}
