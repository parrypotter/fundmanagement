package com.panrui.fundmanage.config;

import com.panrui.fundmanage.interceptors.LoginInterceptors;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMvcConfig implements WebMvcConfigurer {
    /*页面跳转设置*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/financeManager/login.html").setViewName("login");
        registry.addViewController("/financeManager/index.html").setViewName("main/index");
        registry.addViewController("/addlist").setViewName("list/addlist");

    }
    /*网页静态资源映射*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    /*页面拦截*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptors()).addPathPatterns("/**").excludePathPatterns("/","/system/login"
                ,"/system/checkcode","/user/**","/main/index","/easyui/**","/h-ui/**","/upload/**",
                "/financeManager/login.html","/financeManager/index.html","/layout/**","/charts/**","/income/**","/list/**",
                "/indexAction/**");
    }
}
