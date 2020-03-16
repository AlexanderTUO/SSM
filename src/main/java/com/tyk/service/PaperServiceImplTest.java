package com.tyk.service;

import com.tyk.pojo.Paper;

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
}