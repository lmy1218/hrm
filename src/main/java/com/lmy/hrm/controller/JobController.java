package com.lmy.hrm.controller;
/**
 * @Project hrm
 * @Package com.lmy.hrm.controller
 * @author lmy
 * @date 2020/4/24 10:55
 * @version V1.0
 */

import com.lmy.hrm.entity.JobInf;
import com.lmy.hrm.service.JobInfService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import com.lmy.hrm.vo.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lmy
 * @ClassName JobController
 * @Description 职位控制器
 * @date 2020/4/24 10:55
 **/
@Slf4j
@Controller
public class JobController {

    
    @Autowired
    private JobInfService jobInfServiceImpl;
    
    @RequestMapping("job/selectJob")
    public String showJob(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, String name,
                          HttpServletRequest request) {
        EasyUIDataGrid page = jobInfServiceImpl.findPage(pageIndex, name);
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());

        request.setAttribute("joblist", page.getRows());
        request.setAttribute("pageModel", pageModel);
        
        return "job/joblist";
    }


    // 添加或修改
    @RequestMapping("job/addJob")
    public String showadd(String flag) {
        return "job/jobadd";
    }

    @RequestMapping("jobaddsave.action")
    public String add(String name, String remark) {
        JobInf jobInf = new JobInf();
        jobInf.setName(name);
        jobInf.setRemark(remark);
        jobInfServiceImpl.addJob(jobInf);
        return "redirect:job/addJob";
    }


    @RequestMapping("viewJob.action")
    public String showEdit(Integer id, Model model) {
        JobInf jobInf = jobInfServiceImpl.findById(id);
        model.addAttribute("job", jobInf);
        return "/job/jobedit";
    }

    @RequestMapping("jobedit.action")
    public String edit(JobInf jobInf) {
        jobInfServiceImpl.update(jobInf);
        return "redirect:job/selectJob";
    }

    @RequestMapping("jobdel.action")
    public String delete(@RequestParam("jobId")List<Integer> jobIds) {
        jobInfServiceImpl.deleteJob(jobIds);
        return "redirect:job/selectJob";
    }
    

}
