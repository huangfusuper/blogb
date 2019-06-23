package com.blog.service.impl;

import com.blog.dataobject.SysRole;
import com.blog.mapper.RoleDao;
import com.blog.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangfu
 */
@Service
public class RoleServiceImpl implements RoleService {
    private static final  Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<SysRole> findUserInfoRole(String userId) {
        LOGGER.info("-----------------开始查询用户id为【{}】,对应角色--------------------",userId);
        List<SysRole> userInfoRole = roleDao.findUserInfoRole(userId);
        LOGGER.info("-----------------查询成功，该用户对应角色数量为【{}】--------------------",userInfoRole.size());
        return userInfoRole;
    }

    @Override
    public void printTest(String name) {
        LOGGER.info("----------------开始执行定时任务【{}】---------------------",name);
    }
}
