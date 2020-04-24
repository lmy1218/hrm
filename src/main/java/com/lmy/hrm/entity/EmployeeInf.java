package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/21 12:11
 * @version V1.0
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lmy
 * @ClassName EmployeeInf
 * @Description
 * @date 2020/4/21 12:11
 **/
@Data
public class EmployeeInf implements Serializable {
    private Integer id;
    private Integer deptId;
    private Integer jobId;
    private String name;
    private String cardId;
    private String address;
    private String postCode;
    private String tel;
    private String phone;
    private String qqNum;
    private String email;
    private Integer sex;
    private String party;
    private Date birthday;
    private String race;
    private String education;
    private String speciality;
    private String hobby;
    private String remark;
    private Date createDate;

}
