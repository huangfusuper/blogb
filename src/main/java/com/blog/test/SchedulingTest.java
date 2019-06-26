package com.blog.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时测试  Springboot web自带的定时任务
 * @author Administrator
 */
@Component
public class SchedulingTest {
    @Scheduled(cron = "0/5 * * * * *")
    public void test(){
        System.out.println("-------------------------------------------");
    }
}
