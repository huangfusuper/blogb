package com.blog.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import java.util.Arrays;

/**
 * @author huangfu
 *
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new OpenEntityManagerInViewFilter());
        filterRegistrationBean.setName("openEntityManagerInViewFilter");
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.setOrder(Integer.MAX_VALUE);
        return filterRegistrationBean;
    }
}
