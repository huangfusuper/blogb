package com.blog;

import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * 项目启动类
 * @author 皇甫
 */
@SpringBootApplication
@MapperScan("com.blog.mapper")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class);
        /*String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 1024;
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
        ByteSource credentialsSalt = ByteSource.Util.bytes(uuid);
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);*/
    }
}
