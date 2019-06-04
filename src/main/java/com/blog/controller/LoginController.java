package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.blog.dataobject.UserInfo;
import com.blog.enums.LoginEnum;
import com.blog.exceptions.BlogException;
import com.blog.service.UserInfoService;
import com.blog.utils.HttpUtil;
import com.blog.utils.ResponseResultVoUtil;
import com.blog.vo.ResponseResultVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Map;

/**
 * 登录入口
 * @author 皇甫
 */
@RestController
public class LoginController {
    /**
     * 密码错误次数
     */
    @Value("${user.password.error.count}")
    private Integer passwordErrorCount=3;
    @Autowired
    private UserInfoService userInfoService;
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("login.html")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request){
        LOG.info("------------IP【{}】，访问登录页主界面--------------", HttpUtil.getIpAddress(request));
        modelAndView.setViewName("/login/login");
        return modelAndView;
    }

    /**
     * 真正的登陆逻辑
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("login")
    public ResponseResultVO<UserInfo> login(String username, String password){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //封装用户对象
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        UserInfo user = userInfoService.findByUsername(username);
        //执行登陆方法
        try {
            if(user.getPasswordErrorCount()>passwordErrorCount){
                user.setState((byte) 0);
                userInfoService.updateUserInfo(user);
                throw new BlogException();
            }
            if(user.getState()==0){
                throw new BlogException();
            }
            //执行认证方法  用户登陆
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException unkAccount){
            //用户账户错误
            return ResponseResultVoUtil.failure(LoginEnum.NOSUCHUSER.getCode(), LoginEnum.NOSUCHUSER.getMsg());
        }catch (IncorrectCredentialsException incPassword){
            //密码错误
            user.setPasswordErrorCount(user.getPasswordErrorCount()+1);
            userInfoService.updateUserInfo(user);
            return ResponseResultVoUtil.failure(LoginEnum.WRONGPASSWORD.getCode(), LoginEnum.WRONGPASSWORD.getMsg()+"错误次数为："+user.getPasswordErrorCount()+"次");
        }catch (BlogException blogException){
            //用户被冻结
            return ResponseResultVoUtil.failure(LoginEnum.USERISFROZEN.getCode(),LoginEnum.USERISFROZEN.getMsg());
        }
        //密码正确 设置为0
        user.setPasswordErrorCount(0);
        userInfoService.updateUserInfo(user);
        return ResponseResultVoUtil.success();
    }
    @RequestMapping("test.html")
    public ModelAndView test(ModelAndView modelAndView){
        modelAndView.setViewName("/login/test");
        return modelAndView;
    }


    @RequiresPermissions("test:add")
    @ResponseBody
    @RequestMapping("test")
    public ResponseResultVO test(){
        LOG.info("------------------------------------------------------------------------------------------------");
        return ResponseResultVoUtil.success("人间不值得");
    }
}
