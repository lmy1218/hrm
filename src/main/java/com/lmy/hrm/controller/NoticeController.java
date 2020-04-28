package com.lmy.hrm.controller;
/**
 * @Project hrm
 * @Package com.lmy.hrm.controller
 * @author lmy
 * @date 2020/4/28 17:11
 * @version V1.0
 */

import com.lmy.hrm.service.NoticeService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import com.lmy.hrm.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lmy
 * @ClassName NoticeController
 * @Description TODO
 * @date 2020/4/28 17:11
 **/
@Controller
public class NoticeController {


    @Autowired
    private NoticeService noticeServiceImpl;


    @RequestMapping("notice/selectNotice")
    public String showPage(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, String name,
                           HttpServletRequest request) {

        EasyUIDataGrid page = noticeServiceImpl.findPage(pageIndex, name);
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());

        request.setAttribute("noticelist", page.getRows());
        request.setAttribute("pageModel", pageModel);

        return "notice/noticelist";
    }

}
