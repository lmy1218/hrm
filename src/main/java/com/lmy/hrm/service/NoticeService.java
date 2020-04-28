package com.lmy.hrm.service;

import com.lmy.hrm.vo.EasyUIDataGrid;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.service
 * @date 2020/4/28 17:39
 */
public interface NoticeService {

    EasyUIDataGrid findPage(Integer page, String name);
}
