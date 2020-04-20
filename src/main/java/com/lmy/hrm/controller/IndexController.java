package com.lmy.hrm.controller;
/**
 * @Project hrm
 * @Package com.lmy.hrm.controller
 * @author lmy
 * @date 2020/4/20 22:37
 * @version V1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lmy
 * @ClassName IndexController
 * @Description 首页展示
 * @date 2020/4/20 22:37
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return  "loginForm";
    }
}
