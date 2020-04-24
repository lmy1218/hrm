package com.lmy.hrm.service;

import com.lmy.hrm.entity.DeptInf;
import com.lmy.hrm.vo.EasyUIDataGrid;

import java.util.List;


/**
 * @Project hrm
 * @Package com.lmy.hrm.service
 * @author lmy
 * @date 2020/4/23 11:17
 * @version V1.0
 */


public interface DepInfService {

    EasyUIDataGrid findPage(Integer page, String name);

    void addDep(DeptInf deptInf);

    DeptInf findById(Integer id);

    void update(DeptInf deptInf);

    void deleteDep(List<Integer> deptIds);

    List<DeptInf> findAll();
}
