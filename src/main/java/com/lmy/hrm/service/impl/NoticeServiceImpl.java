package com.lmy.hrm.service.impl;
/**
 * @Project hrm
 * @Package com.lmy.hrm.service.impl
 * @author lmy
 * @date 2020/4/28 17:39
 * @version V1.0
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.hrm.entity.NoticeInf;
import com.lmy.hrm.mapper.NoticeMapper;
import com.lmy.hrm.service.NoticeService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lmy
 * @ClassName NoticeServiceImpl
 * @Description TODO
 * @date 2020/4/28 17:39
 **/
@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {


    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public EasyUIDataGrid findPage(Integer page, String name) {
        log.info("公告分页查询开始----");
        // 分页插件设置page 和 size
        PageHelper.startPage(page, 2);

        if (StringUtils.isBlank(name)) {
            name = null;
        }

        // 根据条件查询符合的数据
        List<NoticeInf> list = noticeMapper.getAllByPage(name);
        if (list != null) {
            log.info("公告分页查询成功----");
        }
        // 分页插件解析结果
        PageInfo<NoticeInf> pi = new PageInfo<>(list);
        EasyUIDataGrid grid = new EasyUIDataGrid();

        grid.setTotal(pi.getTotal());
        grid.setRows(pi.getList());
        return grid;


    }
}
