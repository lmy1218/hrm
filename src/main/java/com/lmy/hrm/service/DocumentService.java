package com.lmy.hrm.service;

import com.lmy.hrm.entity.DocumentInf;
import com.lmy.hrm.vo.EasyUIDataGrid;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.service
 * @date 2020/4/28 13:57
 */
public interface DocumentService {

    EasyUIDataGrid getPageByTitle(Integer page, String title);

    void add(DocumentInf documentInf);

    DocumentInf getById(Integer id);
}
