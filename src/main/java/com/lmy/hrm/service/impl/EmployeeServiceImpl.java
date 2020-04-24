package com.lmy.hrm.service.impl;
/**
 * @Project hrm
 * @Package com.lmy.hrm.service.impl
 * @author lmy
 * @date 2020/4/24 12:28
 * @version V1.0
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.hrm.dto.EmployeeDto;
import com.lmy.hrm.entity.EmployeeInf;
import com.lmy.hrm.mapper.EmployeeMapper;
import com.lmy.hrm.service.EmployeeService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lmy
 * @ClassName EmployeeServiceImpl
 * @Description 员工管理业务
 * @date 2020/4/24 12:28
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EasyUIDataGrid findPage(Integer page, EmployeeDto employeeDto) {
        PageHelper.startPage(page, 2);
        if (StringUtils.isBlank(employeeDto.getName())) {
            employeeDto.setName(null);
        }
        if (StringUtils.isBlank(employeeDto.getCardId())) {
            employeeDto.setCardId(null);
        }
        if (StringUtils.isBlank(employeeDto.getPhone())) {
            employeeDto.setPhone(null);
        }
        EmployeeInf employeeInf = new EmployeeInf();
        employeeInf.setPhone(employeeDto.getPhone());
        employeeInf.setDeptId(employeeDto.getDeptId());
        employeeInf.setJobId(employeeDto.getJobId());
        employeeInf.setName(employeeDto.getName());
        employeeInf.setCardId(employeeDto.getCardId());
        employeeInf.setSex(employeeDto.getSex());


        List<EmployeeInf> list = employeeMapper.getAllByPage(employeeInf);
        PageInfo<EmployeeInf> pi = new PageInfo<>(list);
        EasyUIDataGrid grid = new EasyUIDataGrid();

        grid.setTotal(pi.getTotal());
        grid.setRows(pi.getList());
        return grid;

    }

    @Override
    public EmployeeInf findByCardId(String cardId) {
        return employeeMapper.getByCardId(cardId);
    }

    @Override
    @Transactional
    public void addEmploy(EmployeeInf employeeInf) {
        employeeMapper.insert(employeeInf);
    }

    @Override
    public EmployeeInf findById(Integer id) {
        return employeeMapper.getById(id);
    }

    @Override
    public void update(EmployeeInf employeeInf) {
        employeeMapper.updateEm(employeeInf);
    }

    @Override
    public void deleteEm(List<Integer> employeeIds) {
        // 循环删除
        for (Integer employeeId : employeeIds) {
            employeeMapper.delete(employeeId);
        }
    }


}
