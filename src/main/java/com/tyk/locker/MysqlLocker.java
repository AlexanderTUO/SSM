package com.tyk.locker;

import lombok.Data;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tyk
 * @Date: 2020/3/24 11:23
 * @Description:
 */
@Component
public class MysqlLocker implements Locker{

    private ThreadLocal<SqlSessionWrapper> localSession = new ThreadLocal<>();

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void lock(String key, Runnable command) {
        SqlSessionWrapper sqlSessionWrapper = localSession.get();
        if (sqlSessionWrapper == null) {
            localSession.set(new SqlSessionWrapper(sqlSessionFactory.openSession()));
        }
        try {
            if (getLock(key, 1)) {
                command.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            releaseLock(key);
        }
    }

    private boolean getLock(String key, long timeout) {
        Map param = new HashMap();
        param.put("key", key);
        param.put("timeout", timeout);
        SqlSessionWrapper sqlSessionWrapper = localSession.get();
        Integer result = sqlSessionWrapper.getSqlSession().selectOne("LockerMapper.getLock",param);
        if (result != null && result == 1) {
            sqlSessionWrapper.state++;
            return true;
        }
        return false;
    }

    private boolean releaseLock(String key) {
        SqlSessionWrapper sqlSessionWrapper = localSession.get();
        Integer result = sqlSessionWrapper.getSqlSession().selectOne("LockerMapper.releaseLock", key);
        if (result != null && result == 1) {
            sqlSessionWrapper.state--;
            if (sqlSessionWrapper.state == 0) {
                sqlSessionWrapper.sqlSession.close();
                localSession.remove();
            }
        }
        return false;
    }

    @Data
    private static class SqlSessionWrapper{
        int state;
        SqlSession sqlSession;

        public SqlSessionWrapper(SqlSession sqlSession) {
            this.state = 0;
            this.sqlSession = sqlSession;
        }
    }
}
