package com.mc.system.interceptor;


import com.mc.system.servlet.MonsterResultManager;
import com.mc.system.servlet.MonsterServletUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/03 11:30
 * @since v1.0
 */
@Aspect
@Component
public class MonsterAspectController {

    @Pointcut("execution(* com.mc.controller.*Controller*.*(..))")
    public void controllerAspect() {
    }

    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest)args[0];
        HttpServletResponse response = (HttpServletResponse)args[1];
    }

    @Around("controllerAspect()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            pjp.proceed();
        } catch (Throwable ex) {
            //统一处理异常
            Object[] objs = pjp.getArgs();
            HttpServletResponse response = (HttpServletResponse)objs[1];
            MonsterServletUtils.output(response, MonsterResultManager.newFailed(ex.getLocalizedMessage()));
        }
    }

    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) {
//        System.out.println("after aspect executed");
    }

    @AfterReturning(pointcut = "controllerAspect()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
//        System.out.println("afterReturning executed, return result is " + returnVal);
    }

    @AfterThrowing(pointcut = "controllerAspect()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
//        System.out.println("error:" + error.getMessage());
    }

}
