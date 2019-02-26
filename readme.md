# 第二节课

1. 工程结构
beans       存放 javaBean
    -vo     返回体
    -param  入参
    -entity 与数据库表结构一致的 javaBean
    -dto    过渡层


controller  存放 控制器

dao         与数据库交互的java代码

cache       缓存相关的java代码

exception   异常的定义

service     业务逻辑代码
    -impl   实现类的存放


2.利用archetype插件定义自己的模版工程
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-archetype-plugin</artifactId>
    <version>2.4</version>
</plugin>

如果出现错误是 Error configuring command-line. Reason: Maven executable not found at: ...maven\bin\mvn.bat
错误原因：mvn.bat 未找到
解决方法：复制 mvn.cmd 为 mvn.bat

3.利用模版工程创建learn-02项目
https://blog.csdn.net/qq_21251983/article/details/52252970

# 第三课
4.给spring boot工程中添加redis的连接

5.给spring boot工程中添加数据库连接
    5.1 使用jpa
    5.2 使用mybatis

