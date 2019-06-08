package com.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author 皇甫
 */
@Data
public class UserInfo {
    private String uid;
    /**
     * 帐号
     */
    private String username;
    /**
     * 密码;
     */
    private String password;
    /**
     * 真实名称（昵称或者真实姓名，不同系统不同定义）
     */
    private String name;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户手机
     */
    private String mobile;
    /**
     * 用户身份证号码
     */
    private String idCard;
    /**
     * 加密密码的盐
     */
    private String salt;
    /**
     * 用户注册时间
     */
    private Date registrationTime;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 最后一次登录时间
     */
    private Date landingTime;
    /**
     * 用户输入密码错误次数
     */
    private Integer passwordErrorCount;
    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private Byte state;
    /**
     * 立即从数据库中进行加载数据;
     * 一个用户具有多个角色
     */

    /**
     * 设置最后登录时间
     */
    public void setCurrentLoginTime(){
        this.landingTime = new Date();
    }

    /**
     * 设置最后修改时间
     */
    private void setUpdateDate(){
        this.updateDate = new Date();
    }

    /**
     * 设置注册时间
     */
    private void setRegistrationTime(){
        this.registrationTime = new Date();
    }

    public UserInfo() {
    }

    public UserInfo(String username, String password, String name, String email, String phone, String mobile, String idCard, String salt, Integer passwordErrorCount, Byte state) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.idCard = idCard;
        this.salt = salt;
        this.passwordErrorCount = passwordErrorCount;
        this.state = state;
    }

}
