package com.blog.exceptions.superexception;

import com.blog.enums.superenum.IEnum;

/**
 * @author 皇甫
 */
public interface IException {
    /**
     * 获取传入的枚举
     * @return
     */
    abstract IEnum getIEnumClass();
}
