package com.tyk.service;

import com.tyk.annotation.CustomTransactional;
import com.tyk.pojo.SysLog;
import com.tyk.util.IDGenerator;
import com.tyk.util.TransactionalUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;
import java.util.Arrays;

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
    public Object addTransactional(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 获取方法上面的注解
        CustomTransactional ct = method.getAnnotation(CustomTransactional.class);
        // 不为空说明有我们自定义的注解
        if (ct != null) {
            TransactionStatus transactionStatus = null;
            try {
                transactionStatus = transactionalUtils.begin();
                result = joinPoint.proceed();
                transactionalUtils.commit(transactionStatus);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                if (transactionStatus != null) {
                    transactionalUtils.rollBack(transactionStatus);
                }
            }
        }else {
           result = joinPoint.proceed();
        }
//        CustomTransactional ct = method.getA
        return result;
    }
}
