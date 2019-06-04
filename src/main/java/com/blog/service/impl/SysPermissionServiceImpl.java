package com.blog.service.impl;

import com.blog.dataobject.SysPermission;
import com.blog.mapper.SysPermissionDao;
import com.blog.service.SysPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangfu
 * 权限服务
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysPermissionServiceImpl.class);
    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Override
    public List<SysPermission> findAllByRoleIds(List<Integer> ids) {
        LOGGER.info("-------------------开始查询对应角色所具有的的权限-----------------");
        List<SysPermission> allByRoleIds = sysPermissionDao.findAllByRoleIds(ids);
        LOGGER.info("-------------------结束查询对应角色所具有的的权限-----------------");
        return allByRoleIds;
    }
}
