package com.cxn.example.learns.beans.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/2/25 22:46
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */
@ConfigurationProperties(prefix = "my.a")
@Component
@Data
@ToString
public class MyInfoConfig {
    @Value("${my.a.name:默认}")
    private String name;

    private String title;

    private int age;
}
