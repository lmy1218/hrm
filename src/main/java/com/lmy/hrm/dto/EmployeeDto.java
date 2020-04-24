package com.lmy.hrm.dto;
/**
 * @Project hrm
 * @Package com.lmy.hrm.dto
 * @author lmy
 * @date 2020/4/24 12:15
 * @version V1.0
 */

import lombok.Data;

/**
 * @author lmy
 * @ClassName EmployeeDto
 * @Description 接收员工查询参数
 * @date 2020/4/24 12:15
 **/
@Data
public class EmployeeDto {

    // 页码
    private Integer pageIndex;
    // 名称
    private String name;
    // 职位id
    private Integer jobId;
    // 部门id
    private Integer deptId;
    // 身份证
    private String cardId;
    // 性别
    private Integer sex;
    // 电话号
    private String phone;

}
