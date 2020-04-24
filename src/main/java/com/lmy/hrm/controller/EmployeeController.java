package com.lmy.hrm.controller;
/**
 * @Project hrm
 * @Package com.lmy.hrm.controller
 * @author lmy
 * @date 2020/4/24 11:47
 * @version V1.0
 */

import com.lmy.hrm.dto.EmployeeDto;
import com.lmy.hrm.dto.ResultEmployDto;
import com.lmy.hrm.entity.DeptInf;
import com.lmy.hrm.entity.EmployeeInf;
import com.lmy.hrm.entity.JobInf;
import com.lmy.hrm.service.DepInfService;
import com.lmy.hrm.service.EmployeeService;
import com.lmy.hrm.service.JobInfService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import com.lmy.hrm.vo.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lmy
 * @ClassName EmployeeController
 * @Description 员工管理控制器
 * @date 2020/4/24 11:47
 **/
@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private DepInfService depInfServiceImpl;

    @Autowired
    private JobInfService jobInfServiceImpl;

    @Autowired
    private EmployeeService employeeServiceImpl;

    /**
     * 根据条件动态分页查询
     * @return
     */
    @RequestMapping("employeelist.action")
    public String showEmploy(EmployeeDto employeeDto, Model model,
                             HttpServletRequest request) {
        Integer pageIndex = employeeDto.getPageIndex() == null || employeeDto.getPageIndex() == 0 ? 1 : employeeDto.getPageIndex();
        // 查询出所有的职位和部门
        List<DeptInf> deptList = depInfServiceImpl.findAll();
        List<JobInf> jobList = jobInfServiceImpl.findAll();

        EasyUIDataGrid page = employeeServiceImpl.findPage(pageIndex, employeeDto);
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());
        List<EmployeeInf> employlist = (List<EmployeeInf>) page.getRows();
        List<ResultEmployDto> resultEmployList = new ArrayList<>();
        for (EmployeeInf employeeInf : employlist) {
            ResultEmployDto resultEmployDto = new ResultEmployDto();
            BeanUtils.copyProperties(employeeInf, resultEmployDto);
            DeptInf dept = depInfServiceImpl.findById(employeeInf.getDeptId());
            JobInf job = jobInfServiceImpl.findById(employeeInf.getJobId());
            resultEmployDto.setDept(dept);
            resultEmployDto.setJob(job);
            resultEmployList.add(resultEmployDto);
        }

        model.addAttribute("employeelist", resultEmployList);
        model.addAttribute("pageModel", pageModel);
        model.addAttribute("deptList", deptList);
        model.addAttribute("jobList", jobList);

        return "employee/employeelist";
    }


    /**
     * 校验身份证
     * @param cardId
     * @return
     */
    @RequestMapping(value = "getcardid.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkCardId(@RequestBody String cardId) {

        EmployeeInf employeeInf = employeeServiceImpl.findByCardId(cardId);
        if (employeeInf == null ) {
           return true;
        }else {
            return false;
        }
    }


    // 添加或修改
    @RequestMapping("employeeadd.action")
    public String showadd(HttpServletRequest request) {
        // 查询出所有的职位和部门
        List<DeptInf> deptList = depInfServiceImpl.findAll();
        List<JobInf> jobList = jobInfServiceImpl.findAll();
        request.setAttribute("deptList", deptList);
        request.setAttribute("jobList", jobList);
        return "employee/employeeadd";
    }

    /**
     * 新增
     * @param employeeInf
     * @return
     */
    @RequestMapping(value = "employee/addEmployee")
    public String add(EmployeeInf employeeInf, BindingResult bindingResult) {
        employeeInf.setCreateDate(new Date());
        log.info("开始新增");
        employeeServiceImpl.addEmploy(employeeInf);
        return "redirect:/employeeadd.action";
    }


    @RequestMapping("employee/updateEmployee")
    public String showEdit(Integer id, Model model) {
        // 查询出所有的职位和部门
        List<DeptInf> deptList = depInfServiceImpl.findAll();
        List<JobInf> jobList = jobInfServiceImpl.findAll();


        EmployeeInf employeeInf = employeeServiceImpl.findById(id);
        model.addAttribute("employee", employeeInf);
        model.addAttribute("deptList", deptList);
        model.addAttribute("jobList", jobList);
        return "employee/employeeedit";
    }


    @RequestMapping("/employee/editEmployee")
    public String edit(EmployeeInf employeeInf, BindingResult bindingResult) {
        employeeServiceImpl.update(employeeInf);
        return "redirect:/employeelist.action";
    }

    @RequestMapping("employeedel.action")
    public String delete(@RequestParam("employeeIds")List<Integer> employeeIds) {
        employeeServiceImpl.deleteEm(employeeIds);
        return "redirect:/employeelist.action";
    }


}
