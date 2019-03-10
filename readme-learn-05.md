# 第三课
[配置表资料](https://docs.spring.io/spring-boot/docs/1.5.19.RELEASE/reference/htmlsingle/#appendix)

4.监控 Actuator

```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

```
spring boot 1.5x 默认开启了安全认证
```xml
management:
  security:
    enabled: false
    
```


| 类型 | API端口 | 描述 |
| :------| :------ | :------ |
| GET | http://localhost:8080/autoconfig | 自动配置报告 |
| GET | http://localhost:8080/configprops | 描述配置属性如何注入Bean |
| GET | http://localhost:8080/beans | 描述上下文中全部的bean |
| GET | http://localhost:8080/dump | 获取线程活动快照 |
| GET | http://localhost:8080/env | 获取全部环境属性 |
| GET | http://localhost:8080/env/{name} | 条件查询 |
| GET | http://localhost:8080/health | 应用程序健康指标 |
| GET | http://localhost:8080/info | 应用程序信息 |
| GET | http://localhost:8080/mappings | 描述全部uri路径,以及和控制器之间的映射关系 |
| GET | http://localhost:8080/metrics | 获取应用程序度量信息,例如内存用量和http请求计数 |
| GET | http://localhost:8080/metrics/{name} |  |
| GET | http://localhost:8080/shutdown | 关闭程序 |
| GET | http://localhost:8080/trace | http请求跟踪信息 |


| 指示器 | 键 | 内容 |
| :------| :------ | :------ |
| ApplicationHealthIndicator | none | 永远为UP |
| DataSourceHealthIndicator | db | 如果数据库能连上为UP,否则DOWN |
| DiskSpaceHealthIndicator | diskSpace | 如果可用空间大于阀值,则为UP如果空间不足为DOWN |
| JmsHealthIndicator | jms | 如果能连上代理则UP,否则DOWN |
| MailHealthIndicator | mail | 邮件服务器连接 |
| RedisHealthIndicator | redis | redis服务器连接信息 |
| ... |  |  |

```java
management.context-path=/manage
management.port=20001
```

## 开启禁用单个端点
endpoints.info.enabled=false 禁用/info端点

endpoints.enabled=false      禁用所有端点

endpoints.info.enabled=true  开启所需/info端点

## 如果你只想打开一两个接口，那就先禁用全部接口，然后启用那几个你要的，这样更方便。

endpoints.enabled = false

endpoints.metrics.enabled = true

## 修改端点id

endpoints.info.id=myinfo

## 关闭http端点

management.port=-1

#### https://www.cnblogs.com/ityouknow/p/8423590.html


