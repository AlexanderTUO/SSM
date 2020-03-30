package com.tyk.service;

import com.tyk.annotation.CustomTransactional;
import com.tyk.pojo.Paper;

import java.util.List;

public interface PaperService {
    int addPaper(Paper paper);

    int deletePaperById(Long id);

    int updatePaper(Paper paper);

//    @CustomTransactional(id = 1,propagation = "REQUIRED")
    Paper queryById(Long id);

    /**
     * 添加悲观锁
     * @param id
     * @return
     */
    Paper queryByIdWithLock(Long id);

    List<Paper> queryAllPaper();

    String getMessage(String username);

//    @CustomTransactional(id = 1,propagation = "REQUIRED")
    Paper testTransactional(Long id);

    void increasePaperNumWithLock(long id);
}
