package com.lmy.hrm.service.impl;
/**
 * @Project hrm
 * @Package com.lmy.hrm.service.impl
 * @author lmy
 * @date 2020/4/21 12:59
 * @version V1.0
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.hrm.entity.UserInf;
import com.lmy.hrm.mapper.UserInfMapper;
import com.lmy.hrm.service.UserInfService;
import com.lmy.hrm.vo.EasyUIDataGrid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author lmy
 * @ClassName UserInfServiceImpl
 * @Description 用户业务层
 * @date 2020/4/21 12:59
 **/
@Service
public class UserInfServiceImpl implements UserInfService {

    @Autowired
    private UserInfMapper userInfMapper;


    @Override
    public UserInf check(String username, String password) {
        return userInfMapper.findBynameAndpassword(username, password);
    }

    @Override
    public List<UserInf> findAll() {
        return userInfMapper.getAll();
    }

    @Override
    @Transactional
    public void delete(List<Integer> userIds) {
        if (!userIds.isEmpty()) {
            for (Integer userId : userIds) {
                userInfMapper.deleteById(userId);
            }
        }

    }

    @Override
    @Transactional
    public void add(UserInf user) {
        user.setCreatedate(new Date());
        userInfMapper.insert(user);
    }

    @Override
    public EasyUIDataGrid findPage(Integer page, UserInf userInf) {

        PageHelper.startPage(page, 2);
        if (StringUtils.isBlank(userInf.getLoginname())) {
            userInf.setLoginname(null);
        }
        if (StringUtils.isBlank(userInf.getUsername())) {
            userInf.setUsername(null);
        }
        if (userInf.getStatus() == null) {
            userInf.setStatus(0);
        }

        List<UserInf> list = userInfMapper.getAllByExample(userInf.getLoginname(), userInf.getUsername(), userInf.getStatus());
        PageInfo<UserInf> pi = new PageInfo<>(list);
        EasyUIDataGrid grid = new EasyUIDataGrid();

        grid.setTotal(pi.getTotal());
        grid.setRows(pi.getList());
        return grid;
    }

    @Override
    public UserInf getUserById(Integer id) {
        return userInfMapper.getOneById(id);
    }

    @Override
    @Transactional
    public void update(UserInf userInf) {
        userInf.setCreatedate(new Date());
        userInfMapper.update(userInf);
        return ;
    }


}
