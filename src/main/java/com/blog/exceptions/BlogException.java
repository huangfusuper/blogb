package com.blog.exceptions;

/**
 * @author 皇甫
 */
public class BlogException extends RuntimeException {
    private String code;
    private String msg;

    public BlogException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BlogException() {
        super();
    }
}
