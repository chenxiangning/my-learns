package com.cxn.example.learns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cxn
 * Date: 19-5-30 下午2:30
 * This is my work in reachauto code.
 * mail:chenxiangning@reachauto.com
 * Description:
 */
@Configuration
@EnableWebSecurity
public class SecurityHttpConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 设置hello开头的地址不需要验证
         * 其他的接口都需要验证
         * 添加一个自动生成的login表单
         * 表单记录登录信息
         */
        http.authorizeRequests()
                .antMatchers("/hello/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 在内存中设置一个用户 cxn 用户分组在 HKR
         */
//        auth.inMemoryAuthentication()
//                .withUser("cxn").password("cxn").roles("HKR");

        /**
         * 内存中多个用户设置
         */
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("cxn").password("cxn").roles("hkr").build());
        manager.createUser(User.withUsername("admin").password("admin").roles("admin").build());

        auth.userDetailsService(manager);
    }


}