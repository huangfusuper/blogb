package com.blog.service;

import com.blog.dataobject.SysPermission;

import java.util.List;

/**
 * @author huangfu
 * 权限服务
 */
public interface SysPermissionService  {
    /**
     * 查询角色对应的权限
     * @param ids
     * @return
     */
    List<SysPermission> findAllByRoleIds(List<Integer> ids);
}
