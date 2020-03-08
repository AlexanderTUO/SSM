package com.tyk.pojo;

import com.tyk.util.IDGenerator;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
@Data
public class SysLog {
    private String id;
    private Date createTime;
    private String method;

 }
