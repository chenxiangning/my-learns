package com.cxn.example.learns02;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: chenxiangning
 * Date: 2017-09-22 11:50
 * This is my work in reachauto code.
 * mail:chenxiangning@reachauto.com
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ApplicationConfig.class, SpringTestCommonConfig.class})
@TestPropertySource("classpath:test-spring.properties")
@ComponentScan(basePackages = {"com.reachauto.hkr.tennis.springscan"})
public abstract class AbstractJUnit {


}