package com.blog.conf;

import com.blog.quarzt.MyJob;
import org.quartz.*;
import org.quartz.spi.MutableTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 皇甫
 */
@Configuration
public class QuartzConfiguration {
    /**
     * 任务详情描述
     * @return
     */
    @Bean
    public JobDetail myJobDetail(){
        JobDetail build = JobBuilder.newJob(MyJob.class)
                .withIdentity("springboot_quartz1", "springboot")
                .storeDurably(true)
                .build();
        return build;
    }

    @Bean
    public Trigger myTrigger(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        CronTrigger build = TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myTrigger", "myTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
        return build;

    }
}
