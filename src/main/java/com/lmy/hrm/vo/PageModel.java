package com.lmy.hrm.vo;
/**
 * @Project hrm
 * @Package com.lmy.hrm.vo
 * @author lmy
 * @date 2020/4/21 19:52
 * @version V1.0
 */

import lombok.Data;

/**
 * @author lmy
 * @ClassName PageModel
 * @Description 分页
 * @date 2020/4/21 19:52
 **/
@Data
public class PageModel {

    private Long totalPageSum;

    private Integer pageIndex;

    private Long totalRecordSum;




}
