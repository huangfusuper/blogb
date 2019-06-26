package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 项目启动类
 * @author 皇甫
 */
@SpringBootApplication
@MapperScan("com.blog.mapper")
@EnableAspectJAutoProxy
@EnableScheduling
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
