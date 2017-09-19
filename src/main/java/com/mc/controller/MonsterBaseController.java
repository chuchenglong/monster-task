package com.mc.controller;

import com.mc.service.LoginService;
import com.mc.service.MonsterQuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/01 17:36
 * @since v1.0
 */
@Controller
public class MonsterBaseController {
    @Autowired
    protected LoginService loginService;
    @Autowired
    protected MonsterQuartzService quartzService;


}
