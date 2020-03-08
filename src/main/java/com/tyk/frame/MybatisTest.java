package com.tyk.frame;

import com.tyk.dao.PaperDao;
import com.tyk.pojo.Paper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config2.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void TestAutoMapping() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperDao mapper = sqlSession.getMapper(PaperDao.class);
        Paper paper = mapper.queryById(2L);
        System.out.println(paper);
        sqlSession.close();
    }
}
