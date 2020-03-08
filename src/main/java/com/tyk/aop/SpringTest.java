package com.tyk.aop;

import com.tyk.service.PaperService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/PaperBean.xml");
        System.out.println("启动成功！");
        PaperService paperService = classPathXmlApplicationContext.getBean(PaperService.class);
        System.out.println("PaperService.getMessage:"+paperService.getMessage("tyk"));
    }
}
