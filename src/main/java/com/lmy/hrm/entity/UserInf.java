package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/21 11:36
 * @version V1.0
 */

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lmy
 * @ClassName UserInf
 * @Description 用户实体类
 * @date 2020/4/21 11:36
 **/
@Data
@Table(name = "user_inf")
public class UserInf implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String loginname;
    private String username;
    private String password;
    private Integer status;
    private Date createdate;

}
