package com.blog.test;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class SecondJob {
    public void task(){
        System.out.println("任务2执行....");
    }
}
