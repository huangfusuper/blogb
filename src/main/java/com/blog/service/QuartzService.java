package com.blog.service;

import com.blog.dataobject.ScheduleJob;
import org.quartz.SchedulerException;

/**
 * @author huangfu
 */

public interface QuartzService {
    /**
     * 模拟  启动一个任务
     * @param scheduleJob
     */
    void addJob(ScheduleJob scheduleJob) throws SchedulerException;
}
