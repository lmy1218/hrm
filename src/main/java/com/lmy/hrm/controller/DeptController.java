package com.lmy.hrm.controller;
/**
 * @Project hrm
 * @Package com.lmy.hrm.controller
 * @author lmy
 * @date 2020/4/23 11:12
 * @version V1.0
 */

import com.lmy.hrm.entity.DeptInf;
import com.lmy.hrm.service.DepInfService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import com.lmy.hrm.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lmy
 * @ClassName DeptController
 * @Description 部门管理
 * @date 2020/4/23 11:12
 **/
@Controller
public class DeptController {

    @Autowired
    private DepInfService depInfServiceImpl;

    // 分页展示
    @RequestMapping("dept/selectDept")
    public String selectDept(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, String name,
                       HttpServletRequest request) {

        EasyUIDataGrid page = depInfServiceImpl.findPage(pageIndex, name);
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());

        request.setAttribute("deptlist", page.getRows());
        request.setAttribute("pageModel", pageModel);
        return "dep/deptlist";
    }

    // 添加或修改
    @RequestMapping("dept/addDept")
    public String showadd(String flag) {
        return "dep/deptadd";
    }

    @RequestMapping("deptaddsave.action")
    public String add(String name, String remark) {
        DeptInf deptInf = new DeptInf();
        deptInf.setName(name);
        deptInf.setRemark(remark);
        depInfServiceImpl.addDep(deptInf);
        return "redirect:dept/addDept";
    }


    @RequestMapping("viewDept.action")
    public String showEdit(Integer id, Model model) {
        DeptInf deptInf = depInfServiceImpl.findById(id);
        model.addAttribute("dept", deptInf);
        return "/dep/deptedit";
    }

    @RequestMapping("deptedit.action")
    public String edit(DeptInf deptInf) {
        depInfServiceImpl.update(deptInf);
        return "redirect:dept/selectDept";
    }

    @RequestMapping("deptdel.action")
    public String delete(@RequestParam("deptId")List<Integer> deptIds) {
        depInfServiceImpl.deleteDep(deptIds);
        return "redirect:dept/selectDept";
    }

}
