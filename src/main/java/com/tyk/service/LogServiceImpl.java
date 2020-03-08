package com.tyk.service;

import com.tyk.dao.LogDao;
import com.tyk.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addLog(SysLog sysLog) {
        int result = logDao.addLog(sysLog);
//        int b = 1 / 0;
        return result;
    }
}
