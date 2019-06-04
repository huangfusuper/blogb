package com.blog.dataobject;

import lombok.Data;

/**
 * @author 皇甫
 */
@Data
public class SysRole {
    /**
     * 编号
     */
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

    public SysRole(String role, String description, Integer available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public SysRole() {
    }
}
