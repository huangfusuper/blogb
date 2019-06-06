package com.blog.conf;

import org.hibernate.annotations.AttributeAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * @author 皇甫
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityInterceptor securityInterceptor;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(securityInterceptor);
        addInterceptor.excludePathPatterns("/error.html");
        addInterceptor.excludePathPatterns("/login*");
        addInterceptor.addPathPatterns("/**");

    }

    /**
     * 配置和页面相关的资源文件
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info("--------------------------配置静态资源所在目录-----------------------");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
