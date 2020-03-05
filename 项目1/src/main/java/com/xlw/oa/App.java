package com.xlw.oa;

import com.xlw.oa.base.filter.LoginedFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/2 17:30
 */
@SpringBootApplication
@MapperScan("com.xlw.oa.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public FilterRegistrationBean<LoginedFilter> loginedFilter() {
        FilterRegistrationBean<LoginedFilter> bean =
                new FilterRegistrationBean<LoginedFilter>(new LoginedFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
}
