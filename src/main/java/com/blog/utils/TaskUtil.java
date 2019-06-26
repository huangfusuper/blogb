package com.blog.utils;

import com.blog.dataobject.ScheduleJob;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 任务工具
 * @author huangfu
 */
public class TaskUtil {
    public static void invoker(ScheduleJob scheduleJob) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String beanClass = scheduleJob.getBeanClass();
        Class<?> aClass = Class.forName(beanClass);
        Object o = aClass.newInstance();

        Method declaredMethod = aClass.getDeclaredMethod(scheduleJob.getMethodName());
        declaredMethod.invoke(o);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setMethodName("test");
        scheduleJob.setBeanClass("com.blog.utils.TaskUtil");
        invoker(scheduleJob);
    }

    public void test(){
        System.out.println("----------------------");
    }
}
