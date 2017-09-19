package com.mc.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/24 13:57
 * @since v1.0
 */
public class TestJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("today is a beautiful day!!------------------------------------");
    }
}
