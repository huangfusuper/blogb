package com.blog.entrty;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 皇甫
 */
@Data
@Entity
public class SysPermission {
    @Id
    @GeneratedValue
    /**
     * 主键.
     */
    private Integer id;
    /**
     * 名称.
     */
    private String name;
    @Column(columnDefinition="enum('menu','button')")
    /**
     * 资源类型，[menu|button]
     */
    private String resourceType;
    /**
     * 资源路径.
     */
    private String url;
    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;
    /**
     * 父编号
     */
    private Long parentId;
    /**
     * 父编号列表
     */
    private String parentIds;
    private Boolean available = Boolean.FALSE;
    /**
     * 自动生成表数据 驼峰命名法
     */
    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;

    public SysPermission() {
    }

    public SysPermission(String name, String resourceType, String url, String permission, Long parentId, String parentIds, Boolean available, List<SysRole> roles) {
        this.name = name;
        this.resourceType = resourceType;
        this.url = url;
        this.permission = permission;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.available = available;
        this.roles = roles;
    }
}
