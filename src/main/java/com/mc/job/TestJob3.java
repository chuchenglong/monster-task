package com.mc.job;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author ChenglongChu
 * @description
 * @create 2017/09/18 10:38
 * @since v1.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class TestJob3 extends QuartzJobBean {


    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("hello, chuxiaoran !");
    }
}
