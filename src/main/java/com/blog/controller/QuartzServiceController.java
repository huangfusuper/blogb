package com.blog.controller;

import com.blog.TestQuartz;
import com.blog.dataobject.ScheduleJob;
import com.blog.service.QuartzService;
import com.blog.utils.QuartzJobFactory;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huangfu
 */
@Controller
public class QuartzServiceController {
    @Autowired
    private QuartzService quartzService;
    @RequestMapping("testQuartz")
    @ResponseBody
    public void testQuartz() throws SchedulerException {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setBeanClass("com.blog.TestQuartz");
        scheduleJob.setMethodName("run");
        scheduleJob.setJobName("test");
        scheduleJob.setJobGroup("test");
        scheduleJob.setCronExpression("0/2 * * * * ?");
        quartzService.addJob(scheduleJob);
    }

}
