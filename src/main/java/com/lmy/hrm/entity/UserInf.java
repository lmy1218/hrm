package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/21 11:36
 * @version V1.0
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lmy
 * @ClassName UserInf
 * @Description 用户实体类
 * @date 2020/4/21 11:36
 **/
@Data
public class UserInf implements Serializable {

    private Integer id;
    private String loginname;
    private String username;
    private String password;
    private Integer status;
    private Date createdate;

}
