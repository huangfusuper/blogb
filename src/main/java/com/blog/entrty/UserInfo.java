package com.blog.entrty;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 皇甫
 */
@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer uid;
    @Column(unique =true)
    /**
     * 帐号
     */
    private String username;
    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    private String name;
    /**
     * 密码;
     */
    private String password;
    /**
     * 加密密码的盐
     */
    private String salt;
    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private byte state;
    /**
     * 立即从数据库中进行加载数据;
     * 一个用户具有多个角色
     */
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;

    public UserInfo() {
        super();
    }

    public UserInfo(String username, String name, String password, String salt, byte state, List<SysRole> roleList) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.state = state;
        this.roleList = roleList;
    }
}
