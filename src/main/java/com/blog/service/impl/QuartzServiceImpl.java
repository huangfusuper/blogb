package com.blog.service.impl;

import com.blog.dataobject.ScheduleJob;
import com.blog.service.QuartzService;
import com.blog.utils.QuartzJobFactory;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

/**
 * @author huangfu
 */
@Service
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Override
    public void addJob(ScheduleJob scheduleJob) throws SchedulerException {
        //判断任务对象是否为null
        if(scheduleJob == null){
            return;
        }
        Scheduler scheduler = schedulerFactoryBean.getObject();

        TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        CronTrigger cronTrigger = (CronTrigger)scheduler.getTrigger(triggerKey);
        //判断是否已经存在该任务的触发器  不存在 创建一个
        if(null == cronTrigger){
            JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                    .withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup())
                    .build();
            jobDetail.getJobDataMap().put("scheduleJob",scheduleJob);
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
            cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup())
                    .withSchedule(cronScheduleBuilder)
                    .build();
            scheduler.scheduleJob(jobDetail,cronTrigger);
        }else{
            //存在就改变任务定时
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
            cronTrigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(triggerKey)
                    .withSchedule(cronScheduleBuilder)
                    .build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey,cronTrigger);

        }

    }
}
