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
[资料](https://blog.csdn.net/qq_21251983/article/details/52252970) 

1.创建模板工程
mvn archetype:create-from-project
2.生成archetype-catalog.xml文件,他的位置应该会放到默认的.m2文件夹中.
mvn archetype:update-local-catalog
3.
mvn archetype:crawl

4.进入生成好的模板目录,执行mvn install
cd .....\target\generated-sources\archetype 
mvn install

5.查看本地的archetype-catalog.xml看一下模板信息是否正确写入.

6.根据模板创建初始化工程
```xml
mvn archetype:generate -DarchetypeCatalog=local -DinteractiveMode=false -DgroupId=com.haha.lolo -DartifactId=nihao -Dversion=1.0 -DarchetypeGroupId=com.reachauto.framework -DarchetypeArtifactId=ar-spring-boot-models-archetype -DarchetypeVersion=1.1.1

```
    -DarchetypeCatalog=local 读取仓库位置
    -DgroupId=要创建的工程的信息 
    -DartifactId=要创建的工程的信息 
    -Dversion=要创建的工程的信息 
    -DarchetypeGroupId=采用的archetype的信息 
    -DarchetypeArtifactId=采用的archetype的信息 
    -DarchetypeVersion=采用的archetype的信息 
    -DinteractiveMode 是否每次执行命令时都需要联网去中央库查 
