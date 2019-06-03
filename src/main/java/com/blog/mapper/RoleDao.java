package com.blog.mapper;

import com.blog.entrty.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 角色服务
 * @author huangfu
 */
public interface RoleDao extends JpaRepository<SysRole,Integer> {
    /**
     * 根据用户id查询用户所属权限
     * @param userId
     * @return
     */
    List<SysRole> findUserInfoRole(Integer userId);
}
