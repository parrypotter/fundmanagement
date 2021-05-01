###经费管理系统业务流程
第一次提交说明：
（1）使用了第一次作业作为，优化登录界面实现用户和管理员登录和后端验证码，index页面在不登录的情形下无法访问被拦截；
（3）实现注册功能，前端验证，身份证等信息的格式是否正确；
（2）显示用户信息，只有管理员可以查看所有用户信息；普通员工没有用户管理功能；


spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://127.0.0.1:5432/finance?setUnicode=true&characterEncoding=utf8&useAffectedRows=true&useSSL=false
    username: postgres
    password: postgres
server:
  port: 8088
mybatis:
  type-aliases-package: com.panrui.fundmanage.domain
  mapper-locations: classpath:mapper/*.xml
