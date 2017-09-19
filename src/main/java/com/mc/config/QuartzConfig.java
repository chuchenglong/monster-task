package com.mc.config;

import org.quartz.Scheduler;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @description quartz初始化
 * @author ChenglongChu
 * @create 2017/08/01 18:05
 * @since v1.0
 */

public class QuartzConfig {

//	@Bean(name = "scheduler")
//	public Scheduler scheduler(QuartzJobFactory quartzJobFactory) throws Exception {
//
//		SchedulerFactoryBean factoryBean=new SchedulerFactoryBean();
//		factoryBean.setJobFactory(quartzJobFactory);
//
//		factoryBean.afterPropertiesSet();
//
//		Scheduler scheduler=factoryBean.getScheduler();
//
//		//SchedulerFactory sf = new StdSchedulerFactory();
//		//Scheduler scheduler = sf.getScheduler();
//		scheduler.startDelayed(60);
//		//scheduler.start();
//		return scheduler;
//	}
//
//	//解决Job中注入Spring Bean为null的问题
//	@Component("quartzJobFactory")
//	private class QuartzJobFactory extends AdaptableJobFactory {
//		@Autowired
//		private AutowireCapableBeanFactory capableBeanFactory;
//
//		protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
//			Object jobInstance = super.createJobInstance(bundle);
//			capableBeanFactory.autowireBean(jobInstance);
//			return jobInstance;
//		}
//	}
}
