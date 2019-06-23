package com.blog.quarzt;

import com.blog.service.RoleService;
import com.blog.utils.RedisUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.UUID;

/**
 * @author 皇甫
 */
public class MyJob extends QuartzJobBean {
    @Autowired
    private RoleService roleService;
    @Autowired
    RedisTemplate redisTemplate;
    int i = 0;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Integer index = Integer.parseInt((String)redisTemplate.opsForValue().get("UUID"));
        String uuid = (String)redisTemplate.opsForValue().getAndSet("UUID", String.valueOf(index+1));
        System.out.println(uuid);


    }
}
