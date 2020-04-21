package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/21 12:37
 * @version V1.0
 */

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author lmy
 * @ClassName DocumentInf
 * @Description TODO
 * @date 2020/4/21 12:37
 **/
@Data
public class DocumentInf implements Serializable {

    private Integer id;
    private String title;
    private String filename;
    private String filetype;
    private Long fileytes;
    private String remark;
    private Date createDate;
    private Integer userId;


}
