package com.lmy.hrm.service.impl;
/**
 * @Project hrm
 * @Package com.lmy.hrm.service.impl
 * @author lmy
 * @date 2020/4/23 11:20
 * @version V1.0
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.hrm.entity.DeptInf;
import com.lmy.hrm.mapper.DeptInfMapper;
import com.lmy.hrm.service.DepInfService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lmy
 * @ClassName DeptInfServiceImpl
 * @Description 部门业务
 * @date 2020/4/23 11:20
 **/
@Service
public class DeptInfServiceImpl implements DepInfService {


    @Autowired
    private DeptInfMapper deptInfMapper;


    @Override
    public EasyUIDataGrid findPage(Integer page, String name) {

        PageHelper.startPage(page, 2);

        if (StringUtils.isBlank(name)) {
            name = null;
        }


        List<DeptInf> list = deptInfMapper.getAllByPage(name);
        PageInfo<DeptInf> pi = new PageInfo<>(list);
        EasyUIDataGrid grid = new EasyUIDataGrid();

        grid.setTotal(pi.getTotal());
        grid.setRows(pi.getList());
        return grid;
    }

    @Override
    @Transactional
    public void addDep(DeptInf deptInf) {
        deptInfMapper.insert(deptInf);
    }

    @Override
    public DeptInf findById(Integer id) {
        return deptInfMapper.getById(id);
    }

    @Override
    @Transactional
    public void update(DeptInf deptInf) {
        deptInfMapper.updateDept(deptInf);
    }

    @Override
    @Transactional
    public void deleteDep(List<Integer> deptIds) {
        for (Integer deptId : deptIds) {
            deptInfMapper.delete(deptId);
        }

    }

    @Override
    public List<DeptInf> findAll() {
        return deptInfMapper.getAll();
    }
}
