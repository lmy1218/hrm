package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/21 11:59
 * @version V1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author lmy
 * @ClassName DeptInf
 * @Description 部门实体类
 * @date 2020/4/21 11:59
 **/
@Data
public class DeptInf implements Serializable {

    private Integer id;
    private String name;
    private String remark;
}
