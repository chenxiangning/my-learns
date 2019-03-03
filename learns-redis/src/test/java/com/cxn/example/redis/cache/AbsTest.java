package com.cxn.example.redis.cache;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/3/3 20:45
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-dev.yml")
@ComponentScan(basePackages = {"com.cxn.example.redis"})
public abstract class AbsTest {
}
