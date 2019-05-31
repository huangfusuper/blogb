package com.blog.mapper;

import com.blog.entrty.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 皇甫
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
