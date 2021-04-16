###经费管理系统业务流程


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