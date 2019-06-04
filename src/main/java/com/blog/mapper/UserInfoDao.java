package com.blog.mapper;


import com.blog.dataobject.UserInfo;
import org.apache.catalina.User;

/**
 * @author 皇甫
 */
public interface UserInfoDao {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);

    void save(UserInfo user);

    /**
     * 保存
     * @param userInfo
     */
    void insertUserInfo(UserInfo userInfo);
}
