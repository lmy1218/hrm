package com.lmy.hrm.controller;
/**
 * @Project hrm
 * @Package com.lmy.hrm.controller
 * @author lmy
 * @date 2020/4/28 13:47
 * @version V1.0
 */

import com.lmy.hrm.dto.DocumentDto;
import com.lmy.hrm.entity.DocumentInf;
import com.lmy.hrm.entity.UserInf;
import com.lmy.hrm.service.DocumentService;
import com.lmy.hrm.service.UserInfService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import com.lmy.hrm.vo.PageModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lmy
 * @ClassName DocumentController
 * @Description 文档下载
 * @date 2020/4/28 13:47
 **/
@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentServiceImpl;


    @Autowired
    private UserInfService userInfServiceImpl;

    /**
     * 分页查询
     * @param pageIndex
     * @param title
     * @param request
     * @return
     */
    @RequestMapping("documentlist.action")
    public String show(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,String title,
                       HttpServletRequest request) {
        // 分页查询
        EasyUIDataGrid page = documentServiceImpl.getPageByTitle(pageIndex, title);
        List<DocumentInf> documents = (List<DocumentInf>)page.getRows();

        List<DocumentDto> documentDtos = documents.stream().map(q -> {
            DocumentDto documentDto = new DocumentDto();
            BeanUtils.copyProperties(q, documentDto);
            documentDto.setUser(userInfServiceImpl.getUserById(q.getUserId()));
            return documentDto;
        }).collect(Collectors.toList());


        // 装载pageModel
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());

        request.setAttribute("documentlist", documentDtos);
        request.setAttribute("pageModel", pageModel);

        return "document/documentlist";
    }



    @RequestMapping("documentadd.action")
    public String showAdd() {
        return "document/documentadd";
    }


    @RequestMapping("documentaddsave.action")
    public String upload(@RequestParam("file") MultipartFile file,@RequestParam("title") String title,@RequestParam("remark") String remark, HttpServletRequest request) {
        UserInf user = (UserInf)request.getSession().getAttribute("user_session");

        System.out.println(user.getId() + title + "=====" + remark);
        if (user == null) {
            return "loginForm";
        }
        DocumentInf documentInf = new DocumentInf();
        documentInf.setTitle(title);
        documentInf.setUserId(user.getId());
        documentInf.setFilename(file.getOriginalFilename());
        documentInf.setFiletype(file.getContentType());
        try {
            documentInf.setFilebytes(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        documentInf.setCreateDate(new Date());
        documentInf.setRemark(remark);
        documentServiceImpl.add(documentInf);
        return "redirect:documentlist.action";
    }



    @RequestMapping("documentdownload.action")
    public String download(@RequestParam Integer id, HttpServletResponse response) {

        DocumentInf documentInf = documentServiceImpl.getById(id);
        String fileName = null;
        try {
            fileName = new String(documentInf.getFilename().getBytes("utf-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setHeader("Content-disposition", "attachment;filename" + fileName);
        ServletOutputStream out = null;

        try {
            out = response.getOutputStream();
            out.write(documentInf.getFilebytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:documentlist.action";
    }
}
