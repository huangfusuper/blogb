package com.blog.test;

import com.blog.annotation.LogAnnotation;
import org.springframework.stereotype.Component;

@Component
public class TestLogAop {

    @LogAnnotation
    public void test(){
        System.out.println("执行方法");
    }
}
