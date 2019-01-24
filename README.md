# jfinal-activiti-demo

# 介绍

该项目用于简单实现jfinal和acitivti的整合，整合后共用数据库连接池，以确保数据库级别的事务

# 用法

### 1、设置数据库配置
 
src/main/resources/conf/demo.properties

### 2、build项目

mvn install

### 3、运行

执行com.fuge.jfinal.demo.activiti.AppConfig的main方法即可

以Undertow的方式启动web服务

JVM参数启动时加上-Dundertow.hotSwapClassPrefix=com.fuge，可热加在com.fuge包下的类，即编译后无需重启服务

##### 测试activiti

IndexController
http://localhost:8090/

##### 测试json对象的restful接口

HelloController
http://localhost:8080/hello