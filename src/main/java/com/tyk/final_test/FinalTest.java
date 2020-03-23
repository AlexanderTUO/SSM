package com.tyk.final_test;

import com.tyk.pojo.Paper;

/**
 * @Author: tyk
 * @Date: 2020/3/19 15:42
 * @Description:
 */
public class FinalTest {
    private static final Paper paper = new Paper();
    public static void main(String[] args) {
        Paper paper1 = new Paper();
        paper.setPaperName("fsd");
        System.out.println(paper.getPaperName());
    }
}
