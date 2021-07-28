package com.lingjian.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description: security的配置类
 * @author: Ling Jian
 * @date: 2020-03-27 11:33
 **/
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登入功能 如果没有登录 没有权限就会来到登录页面
        http.formLogin()/*.loginPage("/userlogin")*/;
        //1、先来到登录页
        //2、重定向到/login?error表示登录失败
        //3、很多详细的规定

        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/"); //注销成功来到首页
        //1、访问/logout 表示用户注销 清空session
        //2、注销成功会返回、login?logout页面

        //开启记住我功能
        http.rememberMe();

    }

    @Override
    //定义认证规则
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("lj12").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
        .and()
        .passwordEncoder(new BCryptPasswordEncoder()).withUser("lj123").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2","VIP3")
        .and()
        .passwordEncoder(new BCryptPasswordEncoder()).withUser("lj1").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1");
    }
}
