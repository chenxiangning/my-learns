# Spring Boot 干货输出

### 01-spring-boot简介和web工程创建

### 02-swagger-ui和配置文件基础讲解 

### 03-利用maven-archetype插件创建模板工程

### 04-1 spring-boot-redis演示 

### 04-2 spring-boot-redis讲解 

### 04-3 spring-boot-redis 增删改查的演示

### 05-1 spring-boot-jpa 操作演示

### 05-2 spring-boot-mybatis + flywaydb 操作演示

### 05-3 spring-boot-mybatis + flywaydb 操作演示

### 06 
ApplicationRunner 接口

CommandLineRunner 接口
    
    它是属于spring boot应用特定的回调接口
关注点
        
    1.所有的commandLineRunner执行点在SPringBoot应用的
    ApplicationContext完成初始化工作之后.
    2.只要是定义在当前springBoot应用ApplicationContext上下午
    中的任何形式注入的CommandLineRunner都会被加载执行.
    3.建议时候@Order接口进行执行排序数字越小优先级越高.
    
再谈谈配置,自动配置的顺序调整

org.springframework.boot.autoconfigure.AutoConfigureBefore
org.springframework.boot.autoconfigure.AutoConfigureAfter

### 07 spring-boot-log 和 spring-boot-aop 介绍

### 08-1 spring-boot-actuator 应用监控介绍

### 08-2 spring-boot-actuator 应用监控讲解

### 09 spring-boot-web API规范定义

# Spring Cloud 干货输出

### 10 spring cloud 简介和组件介绍

    1 spring cloud config   服务配置中心
    2 Eureka                服务注册发现
    3 Hystrix               熔断组件
    4 Zuul                  智能路由网关
    5 Feign                 声明式远程调度组件
    6 Ribbon                负载均衡组件
    7 Archaius              配置管理API组件
    8 Spring cloud Bus      消息总线组件
    9 spring Cloud Sleuth   服务链路追踪组件
    ...

### 11-1 spring cloud Eureka 简介

### 11-2 spring cloud Eureka Server Eureka Client 演示

### 11-3 spring cloud Eureka Eureka 总结补充

### 12-1 spring cloud Ribbon 简介和演示

### 13-1 spring cloud Feign 简介和演示

### 13-2 spring cloud Feign 补充和总结

### 14-1 spring cloud config 简介与演示

### 14-2 spring cloud config 简介与演示

### 14-3 spring cloud config 补充和总结

### 15-1 spring cloud Hystrix 简介与演示

### 15-2 spring cloud Hystrix 补充和总结

### 16-1 spring cloud zuul 简介与演示

### 16-2 spring cloud zuul filter 演示

### 16-3 spring cloud zuul 补充和总结

### 17-1 spring cloud Sleuth 简介与演示

### 17-2 spring cloud Sleuth 简介与演示

### 17-3 spring cloud Sleuth 补充和总结

### 18-1 spring cloud admin 简介和演示

未完待定....



























