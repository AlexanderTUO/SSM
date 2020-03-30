package com.tyk.pojo;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Data
public class Paper implements BeanNameAware, BeanFactoryAware, ApplicationContextAware ,InitializingBean, DisposableBean, Serializable {
    private long paperId;
    private String paperName;
    private Integer paperNum;
    private String paperDetail;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Paper.setBeanFactory invoke");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Paper.setBeanName invoke");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Paper.setApplicationContext invoke");
    }

    public void customInit() {
        System.out.println("Paper.customInit");
    }

    public void customDestroy() {
        System.out.println("Paper.customDestroy");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Spring.postConstruct invoke");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Paper.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Paper.destroy");
    }

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof Paper) {
//            System.out.println("Paper.postProcessBeforeInitialization");
//        }
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof Paper) {
//            System.out.println("Paper.postProcessAfterInitialization");
//        }
//        return bean;
//    }
}
