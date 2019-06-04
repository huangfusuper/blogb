package com.blog.service.impl;

import com.blog.dataobject.UserInfo;
import com.blog.mapper.UserInfoDao;
import com.blog.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        logger.info("--------------------开始查询用户【{}】----------------------",username);
        return userInfoDao.findByUsername(username);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        logger.info("--------------开始修改用户------------------------");
        userInfoDao.save(userInfo);
    }
}
