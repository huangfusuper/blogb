package com.blog.exceptions;

import com.blog.enums.superenum.IEnum;
import com.blog.exceptions.superexception.IException;

/**
 * @author 皇甫
 */
public class BlogException extends RuntimeException implements IException {
    private IEnum iEnum;

    public <E extends IEnum> BlogException(E e){
        super(e.getMsg());
        this.iEnum = e;
    }

    public BlogException(String msg,Throwable cause) {
        super(msg,cause);
    }
    public BlogException(Throwable cause) {
        super(cause);
    }
    public BlogException(String msg) {
        super(msg);
    }

    @Override
    public IEnum getIEnumClass() {
        return iEnum;
    }

    public BlogException() {
    }

}
