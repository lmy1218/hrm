package com.lmy.hrm.service.impl;

import com.lmy.hrm.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.service.impl
 * @date 2020/4/27 10:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeServiceImpl;



    @Test
    public void findById() {
        // 调用springboot案例中的rest接口
        RestTemplate restTemplate = new RestTemplate();

        String user = restTemplate.getForObject("http://localhost/user/1", String.class);
        System.out.println(user);
        employeeServiceImpl.findById(1);
    }
}