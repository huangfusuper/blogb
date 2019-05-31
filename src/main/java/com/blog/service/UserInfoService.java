package com.blog.service;

import com.blog.entrty.UserInfo;

/**
 * 用户服务
 * @author 皇甫
 */
public interface UserInfoService {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
