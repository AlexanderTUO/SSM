package com.tyk.pojo;

import org.springframework.stereotype.Component;

@Component
public class SpittleAlertHandler {
    public void handleSpittleAlert(Spittle spittle) {
        System.out.println("我是SpittleAlertHandler");
    }
}
