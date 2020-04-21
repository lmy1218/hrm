package com.lmy.hrm.controller;
/**
 * @Project hrm
 * @Package com.lmy.hrm.controller
 * @author lmy
 * @date 2020/4/21 15:14
 * @version V1.0
 */

import com.lmy.hrm.entity.UserInf;
import com.lmy.hrm.service.UserInfService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import com.lmy.hrm.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lmy
 * @ClassName UserController
 * @Description TODO
 * @date 2020/4/21 15:14
 **/
@Controller
public class UserController {


    @Autowired
    private UserInfService userInfServiceImpl;



    @RequestMapping(value = "userlist.action")
    public String userListPost(@RequestParam(value = "pageIndex", defaultValue = "1") String pageIndex, String loginname, String username, Integer status,
                               HttpServletRequest request) {

        UserInf userInf = new UserInf();
        userInf.setLoginname(loginname);
        userInf.setUsername(username);
        userInf.setStatus(status);
        EasyUIDataGrid page = userInfServiceImpl.findPage(Integer.valueOf(pageIndex), userInf);

        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(Integer.valueOf(pageIndex));
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());

        request.setAttribute("userlist", page.getRows());
        request.setAttribute("pageModel", pageModel);
        return "user/userlist";
    }


    @RequestMapping("viewUser.action")
    public String edit(Integer id, Model model) {

        UserInf userInf = userInfServiceImpl.getUserById(id);
        model.addAttribute("user", userInf);
        return "user/useredit";
    }


    @RequestMapping("userdel.action")
    public String delete(@RequestParam("userIds") List<Integer> userIds, HttpServletRequest request) {

        System.out.println(userIds.toString());
        userInfServiceImpl.delete(userIds);
        request.setAttribute("userlist", userInfServiceImpl.findAll());
        return "user/userlist";
    }


    // 添加
    @RequestMapping(value = "useraddsave.action", method = RequestMethod.POST)
    public String addPage(UserInf user) {

        userInfServiceImpl.add(user);

        return "redirect:useradd.action";
    }

    @RequestMapping("useradd.action")
    public String add() {

        return "user/useradd";
    }


    @RequestMapping("userupdate.action")
    public String update(UserInf userInf) {
        userInfServiceImpl.update(userInf);
        return "redirect:/userlist.action";
    }

}
