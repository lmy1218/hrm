package com.lmy.hrm.service.impl;
/**
 * @Project hrm
 * @Package com.lmy.hrm.service.impl
 * @author lmy
 * @date 2020/4/24 11:00
 * @version V1.0
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.hrm.entity.JobInf;
import com.lmy.hrm.mapper.JobInfMapper;
import com.lmy.hrm.service.JobInfService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lmy
 * @ClassName JobInfServiceImpl
 * @Description 职位业务层
 * @date 2020/4/24 11:00
 **/
@Service
@Slf4j
public class JobInfServiceImpl implements JobInfService {


    @Autowired
    private JobInfMapper jobInfMapper;


    @Override
    public EasyUIDataGrid findPage(Integer page, String name) {
        log.info("职位分页查询开始----");
        // 分页插件设置page 和 size
        PageHelper.startPage(page, 2);

        if (StringUtils.isBlank(name)) {
            name = null;
        }

        // 根据条件查询符合的数据
        List<JobInf> list = jobInfMapper.getAllByPage(name);
        if (list != null) {
            log.info("职位分页查询成功----");
        }
        // 分页插件解析结果
        PageInfo<JobInf> pi = new PageInfo<>(list);
        EasyUIDataGrid grid = new EasyUIDataGrid();

        grid.setTotal(pi.getTotal());
        grid.setRows(pi.getList());
        return grid;
    }

    @Override
    public void addJob(JobInf jobInf) {
        log.info("职位新增开始");
        jobInfMapper.insert(jobInf);
        log.info("职位新增完成");
    }

    @Override
    public JobInf findById(Integer id) {
        log.info("开始根据ID查询职位");
        return jobInfMapper.getById(id);

    }

    @Override
    public void update(JobInf jobInf) {
        log.info("职位更新开始");
        jobInfMapper.updateJob(jobInf);
        log.info("职位更新成功");
    }

    @Override
    public void deleteJob(List<Integer> jobIds) {
        log.info("删除职位开始");
        for (Integer deptId : jobIds) {
            jobInfMapper.delete(deptId);
        }
        log.info("删除职位成功");
    }

    @Override
    public List<JobInf> findAll() {
        return jobInfMapper.getAll();
    }
}
