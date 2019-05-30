//package com.cxn.example.learns.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @author cxn
// * Date: 19-5-30 下午2:23
// * This is my work in reachauto code.
// * mail:chenxiangning@reachauto.com
// * Description:
// */
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /**
//         * 在内存中设置一个用户 cxn 用户分组在 HKR
//         */
//        auth.inMemoryAuthentication()
//                .withUser("cxn").password("cxn").roles("HKR");
//    }
//}