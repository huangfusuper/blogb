package com.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 模拟切面
 * @author 皇甫
 */
@Aspect
public class LoggerAop {

    @Around("@annotation(com.blog.annotation.LogAnnotation)")
    public Object printLogger(ProceedingJoinPoint point){
        System.out.println(point.getTarget().getClass());
        return null;
    }
}
