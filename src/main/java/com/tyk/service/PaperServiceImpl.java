package com.tyk.service;

import com.tyk.annotation.CustomTransactional;
import com.tyk.dao.PaperDao;
import com.tyk.pojo.Paper;
import com.tyk.pojo.SysLog;
import com.tyk.util.IDGenerator;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PaperServiceImpl implements PaperService {

    private static Logger logger = LoggerFactory.getLogger(PaperServiceImpl.class);
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
//    @CustomTransactional(id = 1,propagation = "REQUIRED")
    @Transactional(propagation = Propagation.REQUIRED)
    public Paper queryById(Long id) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        SysLog log = new SysLog();
        log.setId(IDGenerator.nextId());
        log.setMethod("queryById");
        logService.addLog(log);
//        int d = 1/0;
//        return null;
        return paperDao.queryById(id);
//        return testTransactional(id);

    }

    @Override
    public Paper queryByIdWithLock(Long id) {
        return paperDao.queryByIdWithLock(id);
    }

    //    @Transactional(propagation = Propagation.REQUIRED)
    public Paper testTransactional(Long id) {
        SysLog log = new SysLog();
        log.setId(IDGenerator.nextId());
        log.setMethod("queryById");
        logService.addLog(log);
        int d = 1/0;
        return paperDao.queryById(id);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void increasePaperNumWithLock(long id) {
        Paper paper = paperDao.queryByIdWithLock(id);
        final Integer oldNum = paper.getPaperNum();
        logger.info("oldNum:{}",oldNum);
        paper.setPaperNum(oldNum+1);
        paperDao.updatePaper(paper);
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
