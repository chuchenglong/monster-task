package com.mc.system.interceptor;

import com.mc.system.servlet.MonsterLog4jUtil;
import com.mc.system.servlet.MonsterResultManager;
import com.mc.system.servlet.MonsterServletUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 事物和service层的一些AOP管理
 * @author ChenglongChu
 * @create 2017/08/03 18:04
 * @since v1.0
 */
@Aspect
@Component
public class MonsterAspectService {
    @Pointcut("execution(* com.mc.service.*Service*.*(..))")
    public void serviceAspect() {
    }

    @Before("serviceAspect()")
    public void before(JoinPoint joinPoint) {
        String methedName = joinPoint.getSignature().getName();
        MonsterLog4jUtil.info("service " + methedName + " start----------");
    }

    @Around("serviceAspect()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("after aspect around");
        try {
            pjp.proceed();
        } catch (Throwable ex) {
            MonsterLog4jUtil.error("service error content: " + ex.getMessage());
            throw ex;
        }
    }

    @After("serviceAspect()")
    public void after(JoinPoint joinPoint) {
        String methedName = joinPoint.getSignature().getName();
        MonsterLog4jUtil.info("service " + methedName + " end----------");
    }

    @AfterReturning(pointcut = "serviceAspect()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
//        System.out.println("afterReturning executed, return result is " + returnVal);
    }

    @AfterThrowing(pointcut = "serviceAspect()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
//        System.out.println("error:" + error.getMessage());
    }
}
