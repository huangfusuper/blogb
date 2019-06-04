package com.blog.mapper;

import com.blog.dataobject.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangfu
 * 权限菜单持久层
 */
public interface SysPermissionDao {
    /**
     * 查询角色对应的权限
     * @param id
     * @return
     */
    List<SysPermission> findAllByRoleIds(@Param("ids") List<Integer> id);
}
