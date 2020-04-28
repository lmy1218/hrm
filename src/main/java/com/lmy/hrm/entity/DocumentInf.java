package com.lmy.hrm.entity;
/**
 * @Project hrm
 * @Package com.lmy.hrm.entity
 * @author lmy
 * @date 2020/4/21 12:37
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
 * @ClassName DocumentInf
 * @Description TODO
 * @date 2020/4/21 12:37
 **/
@Data
@Table(name = "document_inf")
public class DocumentInf implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    private String filename;
    private String filetype;
    private byte[] filebytes;
    private String remark;
    private Date createDate;
    private Integer userId;


}
