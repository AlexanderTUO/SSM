package com.tyk.service;

import com.tyk.pojo.Paper;

import java.util.List;

public interface PaperService {
    int addPaper(Paper paper);

    int deletePaperById(Long id);

    int updatePaper(Paper paper);

    Paper queryById(Long id);

    List<Paper> queryAllPaper();

    String getMessage(String username);
}
