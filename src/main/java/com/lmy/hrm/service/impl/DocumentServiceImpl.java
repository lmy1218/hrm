package com.lmy.hrm.service.impl;
/**
 * @Project hrm
 * @Package com.lmy.hrm.service.impl
 * @author lmy
 * @date 2020/4/28 13:58
 * @version V1.0
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.hrm.entity.DocumentInf;
import com.lmy.hrm.mapper.DocumentMapper;
import com.lmy.hrm.service.DocumentService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lmy
 * @ClassName DocumentServiceImpl
 * @Description 业务层
 * @date 2020/4/28 13:58
 **/
@Slf4j
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;


    @Override
    public EasyUIDataGrid getPageByTitle(Integer page, String title) {
        log.info("文档分页查询开始----");
        // 分页插件设置page 和 size
        PageHelper.startPage(page, 2);

        if (StringUtils.isBlank(title)) {
            title = null;
        }

        // 根据条件查询符合的数据
        List<DocumentInf> list = documentMapper.getPage(title);
        if (list != null) {
            log.info("文档分页查询成功----");
        }
        // 分页插件解析结果
        PageInfo<DocumentInf> pi = new PageInfo<>(list);
        EasyUIDataGrid grid = new EasyUIDataGrid();

        grid.setTotal(pi.getTotal());
        grid.setRows(pi.getList());
        return grid;
    }

    @Override
    public void add(DocumentInf documentInf) {
        documentMapper.insert(documentInf);
    }

    @Override
    public DocumentInf getById(Integer id) {
        return documentMapper.getById(id);
    }
}
