package com.blog.mapper;

import com.blog.dataobject.SysRole;

import java.util.List;

/**
 * 角色服务
 * @author huangfu
 */
public interface RoleDao {
    /**
     * 根据用户id查询用户所属权限
     * @param id
     * @return
     */
    List<SysRole> findUserInfoRole(String id);
}
