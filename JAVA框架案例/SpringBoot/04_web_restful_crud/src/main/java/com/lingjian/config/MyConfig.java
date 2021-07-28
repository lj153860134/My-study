package com.lingjian.config;

import com.lingjian.componet.MyLocaleResolver;
import com.lingjian.componet.MyLoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 自定义配置类
 * @author: Ling Jian
 * @date: 2020-03-19 10:22
 **/

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /lingjian请求会来到success
        registry.addViewController("/lingjian").setViewName("success");
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("index.html").setViewName("index");


    }

    //直接在上面加效果是一样的
    //所有的WebMvcConfigurationSupport组件都会一起起作用
    @Bean  //将组建注册在容器中
    public WebMvcConfigurer WebMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }

        };

        return configurer;

    }

    //注册拦截器
    //SpringBoot已经做好了静态资源映射
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyLoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login", "/asserts/**", "/webjars/**");
    }


    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
