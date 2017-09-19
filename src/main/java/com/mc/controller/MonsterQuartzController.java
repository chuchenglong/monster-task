package com.mc.controller;

import com.mc.system.servlet.MonsterServletUtils;
import com.mc.vo.MonsterQuartzVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/23 9:40
 * @since v1.0
 */

@RestController
@RequestMapping("/job")
public class MonsterQuartzController extends MonsterBaseController {

    @RequestMapping(value="/getAllJobs.do", method = { RequestMethod.POST})
    public void getAllJobs(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<MonsterQuartzVo> list =  quartzService.getAllJobs();
        MonsterServletUtils.output(response, list);
    }

    @RequestMapping(value="/addJob.do", method = { RequestMethod.POST})
    public void addJob(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MonsterQuartzVo mqv = MonsterServletUtils.input(request, MonsterQuartzVo.class);
        quartzService.addJob(mqv);
        MonsterServletUtils.output(response, mqv);
    }

    @RequestMapping(value="/editJob.do", method = { RequestMethod.POST})
    public void editJob(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MonsterQuartzVo mqv = MonsterServletUtils.input(request, MonsterQuartzVo.class);
        quartzService.editJob(mqv);
        MonsterServletUtils.output(response, mqv);
    }

    @RequestMapping(value="/deleteJob.do", method = { RequestMethod.POST})
    public void deleteJob(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MonsterQuartzVo mqv = MonsterServletUtils.input(request, MonsterQuartzVo.class);
        quartzService.deleteJob(mqv);
        MonsterServletUtils.output(response, mqv);
    }

    @RequestMapping(value="/excuteJob.do", method = { RequestMethod.POST})
    public void excuteJob(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MonsterQuartzVo mqv = MonsterServletUtils.input(request, MonsterQuartzVo.class);
        quartzService.excuteJob(mqv);
        MonsterServletUtils.output(response, mqv);
    }

    @RequestMapping(value="/stopJob.do", method = { RequestMethod.POST})
    public void stopJob(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MonsterQuartzVo mqv = MonsterServletUtils.input(request, MonsterQuartzVo.class);
        quartzService.stopJob(mqv);
        MonsterServletUtils.output(response, mqv);
    }


    @RequestMapping(value="/resumeJob.do", method = { RequestMethod.POST})
    public void resumeJob(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MonsterQuartzVo mqv = MonsterServletUtils.input(request, MonsterQuartzVo.class);
        quartzService.resumeJob(mqv);
        MonsterServletUtils.output(response, mqv);
    }


    @RequestMapping(value="/restartJob.do", method = { RequestMethod.POST})
    public void restartJob(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MonsterQuartzVo mqv = MonsterServletUtils.input(request, MonsterQuartzVo.class);
        quartzService.restartJob(mqv);
        MonsterServletUtils.output(response, mqv);
    }
}
