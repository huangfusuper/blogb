package com.blog.service;

import com.blog.dataobject.SysRole;

import java.util.List;

/**
 * @author huangfu
 * 角色服务
 */
public interface RoleService {
    /**
     * 根据用户id查询用户所属权限
     * @param userId
     * @return
     */
    List<SysRole> findUserInfoRole(String userId);
}
