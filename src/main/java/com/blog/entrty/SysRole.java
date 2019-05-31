package com.blog.entrty;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 皇甫
 */
@Data
@Entity
public class SysRole {
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
    private String role;
    /**
     * 角色描述,UI界面显示使用
     */
    private String description;
    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Integer available = 0;

    /**
     * 角色 -- 权限关系：多对多关系;
     */
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;

    /**
     * 用户 - 角色关系定义;
     */
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    /**
     * 一个角色对应多个用户
     */
    private List<UserInfo> userInfos;

    public SysRole(String role, String description, Integer available, List<SysPermission> permissions, List<UserInfo> userInfos) {
        this.role = role;
        this.description = description;
        this.available = available;
        this.permissions = permissions;
        this.userInfos = userInfos;
    }

    public SysRole() {
    }
}
