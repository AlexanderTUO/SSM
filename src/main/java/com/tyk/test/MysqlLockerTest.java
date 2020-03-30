package com.tyk.test;

import com.sun.javafx.binding.StringFormatter;
import com.tyk.locker.Locker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @Author: tyk
 * @Date: 2020/3/24 12:15
 * @Description:
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class MysqlLockerTest {
    @Autowired
    private Locker locker;

    @Test
    public void testLocker() throws IOException {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(()->{
                locker.lock("lock",()->{
                    locker.lock("lock",()->{
                        System.out.println(String.format("time:%d,threadName:%s",System.currentTimeMillis(),Thread.currentThread().getName()));
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                });
            },"thread"+i).start();
        }
        System.in.read();
    }
}
