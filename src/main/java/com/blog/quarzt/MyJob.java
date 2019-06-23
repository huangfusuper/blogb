package com.blog.quarzt;

import com.blog.service.RoleService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author 皇甫
 */
public class MyJob extends QuartzJobBean {
    @Autowired
    private RoleService roleService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        roleService.printTest("我爱昝鹏鹏");
    }
}
