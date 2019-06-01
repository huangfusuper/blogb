package com.blog.enums;

import lombok.Data;

/**
 * @author 皇甫
 */

public enum LoginEnum {
    /**
     * 没有此用户
     */
    NOSUCHUSER("101","用户账户错误"),
    WRONGPASSWORD("102","用户密码错误"),
    USERISFROZEN("103","用户被冻结，请联系管理员！")
    ;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String msg;

    LoginEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
