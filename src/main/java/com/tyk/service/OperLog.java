package com.tyk.service;

import com.tyk.pojo.SysLog;
import com.tyk.util.IDGenerator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class OperLog {
    @Autowired
    private LogService logService;

    @Pointcut("execution(* com.tyk.service.PaperServiceImpl.*(..))")
    public void addLog() {

    }

    @Before("addLog()")
    public void addLogAdvise(JoinPoint joinPoint) {
        SysLog sysLog = new SysLog();
        String clazz = joinPoint.getTarget().toString();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        sysLog.setId(IDGenerator.nextId());
        sysLog.setMethod(method);
//        logService.addLog(sysLog);
        System.out.println("类："+clazz+",方法："+method+",参数："+args);
    }
}
