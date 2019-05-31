package com.blog.entrty;

import lombok.Data;

/**
 * 测试页面类
 * @author 皇甫
 */
@Data
public class User {
    private String id;
    private String name;
    private String password;

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User() {
    }
}
