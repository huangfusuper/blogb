package com.blog.enums.superenum;

/**
 * 枚举父类
 */
public interface IEnum {
    /**
     * 返回错误码
     * @return
     */
    String getCode();

    /**
     * 返回错误信息
     * @return
     */
    String getMsg();
}
