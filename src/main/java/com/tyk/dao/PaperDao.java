package com.tyk.dao;

import com.tyk.pojo.Paper;

import java.util.List;

public interface PaperDao {
    int addPaper(Paper paper);

    int deletePaperById(Long id);

    int updatePaper(Paper paper);

    Paper queryById(Long id);

    Paper queryByIdWithLock(Long id);

    List<Paper> queryAllPaper();
}
