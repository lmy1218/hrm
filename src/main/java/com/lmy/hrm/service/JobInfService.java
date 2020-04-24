package com.lmy.hrm.service;

import com.lmy.hrm.entity.DeptInf;
import com.lmy.hrm.entity.JobInf;
import com.lmy.hrm.vo.EasyUIDataGrid;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.service
 * @date 2020/4/24 11:00
 */
public interface JobInfService {
    
    EasyUIDataGrid findPage(Integer page, String name);


    void addJob(JobInf jobInf);

    JobInf findById(Integer id);

    void update(JobInf jobInf);

    void deleteJob(List<Integer> jobIds);

    List<JobInf> findAll();
}
