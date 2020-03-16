package com.tyk.service;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import com.tyk.annotation.CustomTransactional;
import com.tyk.pojo.SysLog;
import com.tyk.util.IDGenerator;
import com.tyk.util.TransactionalUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Component
@Aspect
public class LogAspect {
    @Autowired
    private LogService logService;
    @Autowired
    private TransactionalUtils transactionalUtils;

    @Pointcut("execution(* com.tyk.service.PaperServiceImpl.*(..))")
//    @Pointcut("execution(* com.tyk.service.*.*(..))")
    public void addLog() {

    }

//    @Before("addLog()")
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

    @Around("addLog()")
    public void addTransactional(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        CustomTransactional ct = method.getAnnotation(CustomTransactional.class);
        // 不为空说明有我们自定义的注解
        if (ct != null) {
            TransactionStatus transactionStatus = null;
            try {
                transactionStatus = transactionalUtils.begin();
                joinPoint.proceed();
                transactionalUtils.commit(transactionStatus);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                if (transactionStatus != null) {
                    transactionalUtils.rollBack(transactionStatus);
                }
            }
        }else {
            joinPoint.proceed();
        }
//        CustomTransactional ct = method.getA

    }
}
