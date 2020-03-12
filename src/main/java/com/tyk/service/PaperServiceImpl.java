package com.tyk.service;

import com.tyk.dao.PaperDao;
import com.tyk.pojo.Paper;
import com.tyk.pojo.SysLog;
import com.tyk.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;

    @Autowired
    private LogService logService;

    @Autowired
    private PaperService paperService;

    @Override
    public int addPaper(Paper paper) {
        return paperDao.addPaper(paper);
    }

    @Override
    public int deletePaperById(Long id) {
        return paperDao.deletePaperById(id);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public Paper queryById(Long id) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        SysLog log = new SysLog();
//        log.setId(IDGenerator.nextId());
//        log.setMethod("queryById");
//        logService.addLog(log);
////        int d = 1/0;
//        return paperDao.queryById(id);
        return paperService.testTransactional(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Paper testTransactional(Long id) {
        SysLog log = new SysLog();
        log.setId(IDGenerator.nextId());
        log.setMethod("queryById");
        logService.addLog(log);
        int d = 1/0;
        return paperDao.queryById(id);
    }




    @Override
    public List<Paper> queryAllPaper() {
        return paperDao.queryAllPaper();
    }

    @Override
    public String getMessage(String username) {
        return "hello spring,"+username;
    }
}
