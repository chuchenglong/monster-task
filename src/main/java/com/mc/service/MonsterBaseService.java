package com.mc.service;

import com.mc.mapper.MonsterQuartzMapper;
import com.mc.mapper.TUserInfoMapper;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ChenglongChu
 * @description 基础service注册
 * @create 2017/09/19 16:37
 * @since v1.0
 */
public class MonsterBaseService {
    @Autowired
    protected TUserInfoMapper tUserInfoMapper;
    @Autowired
    protected MonsterQuartzMapper monsterQuartzMapper;
    @Autowired
    protected Scheduler quartzScheduler;
}
