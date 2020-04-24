package com.lmy.hrm.dto;
/**
 * @Project hrm
 * @Package com.lmy.hrm.dto
 * @author lmy
 * @date 2020/4/24 13:14
 * @version V1.0
 */

import com.lmy.hrm.entity.DeptInf;
import com.lmy.hrm.entity.EmployeeInf;
import com.lmy.hrm.entity.JobInf;
import lombok.Data;

/**
 * @author lmy
 * @ClassName ResultEmployDto
 * @Description 员工返回
 * @date 2020/4/24 13:14
 **/
@Data
public class ResultEmployDto extends EmployeeInf {
    private JobInf job;
    private DeptInf dept;
}
