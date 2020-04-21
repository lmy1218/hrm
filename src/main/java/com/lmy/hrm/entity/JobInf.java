package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/21 12:01
 * @version V1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author lmy
 * @ClassName JobInf
 * @Description 职位实体
 * @date 2020/4/21 12:01
 **/
@Data
public class JobInf implements Serializable {

    private Integer id;
    private String name;
    private String remarx;

}
