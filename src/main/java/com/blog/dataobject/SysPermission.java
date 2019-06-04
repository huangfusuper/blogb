package com.blog.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author 皇甫
 */
@Data
public class SysPermission {
    /**
     * 主键.
     */
    private Integer id;
    /**
     * 名称.
     */
    private String name;
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
     * 是否可用
     */
    private Integer available;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改人
     */
    private String updateBy;

    public SysPermission() {
    }

    public SysPermission(String name, String resourceType, String url, String permission, Long parentId, Integer available, Date createTime, Date updateTime, String createBy, String updateBy) {
        this.name = name;
        this.resourceType = resourceType;
        this.url = url;
        this.permission = permission;
        this.parentId = parentId;
        this.available = available;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }
}
