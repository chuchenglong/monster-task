package com.mc.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/01 14:42
 * @since v1.0
 */
public class TestJob2 extends QuartzJobBean {
    private static int counter = 1;
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("you intrude into my daughter space (" + counter++ + ") times !---------------------------------");
    }
}
