package com.blog.vo;

import lombok.Data;

/**
 * @author 皇甫
 */
@Data
public class ResponseResultVO<T> {
    private String code;
    private String msg;
    private T t;

    public ResponseResultVO() {
    }

    public ResponseResultVO(String code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }
}
