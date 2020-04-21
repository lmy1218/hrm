package com.lmy.hrm.controller;
/**
 * @Project hrm
 * @Package com.lmy.hrm.controller
 * @author lmy
 * @date 2020/4/20 22:37
 * @version V1.0
 */

import com.lmy.hrm.entity.UserInf;
import com.lmy.hrm.service.UserInfService;
import com.lmy.hrm.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author lmy
 * @ClassName IndexController
 * @Description 首页展示
 * @date 2020/4/20 22:37
 **/
@Controller
public class IndexController {


    @Autowired
    private UserInfService userInfServiceImpl;

    @RequestMapping("/")
    public String index(){
        return  "loginForm";
    }

    @RequestMapping("login.action")
    public String login(String loginname, String password, Model model,
                        HttpServletRequest request,
                        HttpServletResponse response) {

        UserInf userInf = userInfServiceImpl.check(loginname, password);
        if (userInf != null) {
            request.getSession().setAttribute("user_session", userInf);
            CookieUtils.newBuilder(response).build("LOGIN", UUID.randomUUID().toString());
            return "redirect:main.action";
        } else {
            model.addAttribute("message", "用户名或密码错误");
            return "loginForm";
        }
    }



    @RequestMapping("main.action")
    public String main() {
        return "main";
    }


    @RequestMapping("top.action")
    public String top() {
        return "top";
    }

    @RequestMapping("left.action")
    public String left() {
        return "left";
    }

    @RequestMapping("right.action")
    public String right() {
        return "right";
    }


    @RequestMapping("logout.action")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("LOGIN","");
        cookie.setMaxAge(0); //设置立即删除
        response.addCookie(cookie);

        return "redirect:/";
    }

}
