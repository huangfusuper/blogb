package com.blog.mapper;

import com.blog.BlogApplication;
import com.blog.dataobject.SysPermission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
public class SysPermissionDaoTest {
    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        List<SysPermission> allByRoleIds = sysPermissionDao.findAllByRoleIds(Arrays.asList(1));
        Assert.assertNotNull(allByRoleIds);
    }

    /**
     * redisTemplate.opsForValue();//操作字符串
     *
     * redisTemplate.opsForHash();//操作hash
     *
     * redisTemplate.opsForList();//操作list
     *
     * redisTemplate.opsForSet();//操作set
     *
     * redisTemplate.opsForZSet();//操作有序set
     */
    @Test
    public void test1(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        redisTemplate.delete("123");
        System.out.println(redisTemplate.opsForValue().get("123"));
    }
}