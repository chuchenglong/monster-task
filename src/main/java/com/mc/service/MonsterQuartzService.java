package com.mc.service;


import com.mc.vo.MonsterQuartzVo;
import org.quartz.*;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/23 9:42
 * @since v1.0
 */
@Service
public class MonsterQuartzService extends MonsterBaseService {

    public List<MonsterQuartzVo> getAllJobs() throws Exception {
        return this.getJobsByGroupOrName(null);
    }

    public List<MonsterQuartzVo> getJobsByGroupOrName(MonsterQuartzVo mqv) throws Exception {
        return monsterQuartzMapper.selectJobs(mqv);
    }

    public void addJob(MonsterQuartzVo mqv) throws Exception{
        //获取job class
        Class jobClass = Class.forName(mqv.getJobClassName());
        //job信息
        JobKey jobKey = JobKey.jobKey(mqv.getJobName(), mqv.getJobGroup());
        //trigger信息
        TriggerKey triggerKey = TriggerKey.triggerKey(mqv.getTriggerName(), mqv.getTriggerGroup());
        //job detail
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).build();
        //trigger cron
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(CronScheduleBuilder.cronSchedule(mqv.getCronExpression())).build();

        quartzScheduler.scheduleJob(jobDetail, trigger);
    }

    public void editJob(MonsterQuartzVo mqv) throws Exception{
        //获取job class
        Class jobClass = Class.forName(mqv.getJobClassName());
        //job信息
        JobKey jobKey = JobKey.jobKey(mqv.getJobName(), mqv.getJobGroup());
        //trigger信息
        TriggerKey triggerKey = TriggerKey.triggerKey(mqv.getTriggerName(), mqv.getTriggerGroup());
        //job detail
        JobDetail jobDetail = JobBuilder.newJob(jobClass).storeDurably().withIdentity(jobKey).build();
        //trigger cron
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(CronScheduleBuilder.cronSchedule(mqv.getCronExpression())).build();

        quartzScheduler.addJob(jobDetail, true);
        quartzScheduler.rescheduleJob(triggerKey, trigger);
    }

    public void deleteJob(MonsterQuartzVo mqv) throws Exception{
        JobKey jobKey = JobKey.jobKey(mqv.getJobName(), mqv.getJobGroup());
        quartzScheduler.deleteJob(jobKey);
    }

    public void excuteJob(MonsterQuartzVo mqv) throws Exception{
        JobKey jobKey = JobKey.jobKey(mqv.getJobName(), mqv.getJobGroup());
        quartzScheduler.triggerJob(jobKey);
    }

    public void stopJob(MonsterQuartzVo mqv) throws Exception{
        JobKey jobKey = JobKey.jobKey(mqv.getJobName(), mqv.getJobGroup());
        if (!quartzScheduler.checkExists(jobKey)) {
            throw new Exception("none job");
        }
        quartzScheduler.pauseJob(jobKey);
    }

    public void resumeJob(MonsterQuartzVo mqv) throws Exception{
        JobKey jobKey = JobKey.jobKey(mqv.getJobName(), mqv.getJobGroup());
        quartzScheduler.resumeJob(jobKey);
    }

    public void restartJob(MonsterQuartzVo mqv) throws Exception{
        JobKey jobKey = JobKey.jobKey(mqv.getJobName(), mqv.getJobGroup());
        TriggerKey triggerKey = TriggerKey.triggerKey(mqv.getTriggerName(), mqv.getTriggerGroup());
        Class jobClass = Class.forName(mqv.getJobClassName());
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).storeDurably().build();
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(mqv.getCronExpression())).withIdentity(triggerKey).build();
        quartzScheduler.scheduleJob(jobDetail, trigger);
    }
}
