package com.blog.shiro.realm;

import com.blog.entrty.UserInfo;
import com.blog.enums.LoginEnum;
import com.blog.exceptions.BlogException;
import com.blog.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author 皇甫
 */
public class UserInfoRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoRealm.class);

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("----------------开始执行认证逻辑，认证用户【{}】--------------------------", ((UsernamePasswordToken)authenticationToken).getUsername());
        //编写shiro判断逻辑
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        UserInfo user = userInfoService.findByUsername(token.getUsername());
        //如果用户为null证明用户不存在
        if(user == null){
            LOGGER.info("-------------------用户名【{}】不存在--------------------",token.getUsername());
            return null;
        }
        LOGGER.info("----------------认证成功--------------------------");
        List<Object> list = Arrays.asList(user.getUsername(),user);
        return new SimpleAuthenticationInfo(list, user.getPassword()
                , ByteSource.Util.bytes(user.getSalt()), getName());
    }
}
