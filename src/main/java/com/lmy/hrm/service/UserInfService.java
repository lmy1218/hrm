package com.lmy.hrm.service;

import com.lmy.hrm.entity.UserInf;
import com.lmy.hrm.vo.EasyUIDataGrid;
import com.lmy.hrm.vo.PageModel;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.service
 * @date 2020/4/21 12:58
 */
public interface UserInfService {

    UserInf check(String loginname, String password);

    List<UserInf> findAll();

    void delete(List<Integer> userIds);

    void add(UserInf user);

    EasyUIDataGrid findPage(Integer page, UserInf userInf);

    UserInf getUserById(Integer id);

    void update(UserInf userInf);
}
