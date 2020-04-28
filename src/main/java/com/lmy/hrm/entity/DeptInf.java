package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/21 11:59
 * @version V1.0
 */

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author lmy
 * @ClassName DeptInf
 * @Description 部门实体类
 * @date 2020/4/21 11:59
 **/
@Data
@Table(name= "dept_inf")
public class DeptInf implements Serializable {

    // id
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    // 部门名称
    private String name;
    private String remark;
}
