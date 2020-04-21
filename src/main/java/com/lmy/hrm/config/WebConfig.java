package com.lmy.hrm.config;
/**
 * @Project bbs
 * @Package com.lmy.bbs.interceptor
 * @author lmy
 * @date 2020/4/19 20:48
 * @version V1.0
 */

import com.lmy.hrm.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lmy
 * @ClassName WebConfig
 * @Description 注册拦截器
 * @date 2020/4/19 20:48
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/*.action")
                .excludePathPatterns("/")
                .excludePathPatterns("/login.action");

    }
}
