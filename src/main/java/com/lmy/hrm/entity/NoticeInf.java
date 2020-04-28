package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/28 17:37
 * @version V1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author lmy
 * @ClassName NoticeInf
 * @Description TODO
 * @date 2020/4/28 17:37
 **/
@Data
public class NoticeInf implements Serializable {

    private Integer id;
    private String name;
    private Integer status;
    private String remark;

}
