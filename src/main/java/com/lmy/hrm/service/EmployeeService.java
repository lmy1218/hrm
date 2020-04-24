package com.lmy.hrm.service;

import com.lmy.hrm.dto.EmployeeDto;
import com.lmy.hrm.entity.EmployeeInf;
import com.lmy.hrm.vo.EasyUIDataGrid;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.service
 * @date 2020/4/24 12:28
 */
public interface EmployeeService {
    EasyUIDataGrid findPage(Integer pageIndex, EmployeeDto employeeDto);

    EmployeeInf findByCardId(String cardId);

    void addEmploy(EmployeeInf employeeInf);

    EmployeeInf findById(Integer id);

    void update(EmployeeInf employeeInf);

    void deleteEm(List<Integer> employeeIds);
}
