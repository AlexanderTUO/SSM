package com.tyk.test;

import com.tyk.pojo.Paper;

import com.tyk.service.PaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class PaperServiceImplTest {

    @Autowired
    private PaperService paperService;

    @Test
    public void queryById() {
        Paper paper = paperService.queryById(1L);
        assertNotNull(paper);
    }

    @Test
    public void testLock() {
//        for (int i = 0; i < 100; i++) {
//            new Thread(()->{
//                paperService.increasePaperNumWithLock(1);
//            },"Thread-"+i).start();
//        }
        int threadCount = 5;
        while (threadCount-- > 0) {
            new Thread(()->{
                paperService.increasePaperNumWithLock(1);
            }).start();
        }
    }
}