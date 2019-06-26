package com.blog.test;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * 任务1
 */

@Component
@EnableScheduling
public class FirstJob {
    public void task(){
        System.out.println("任务1执行....");
    }
}
