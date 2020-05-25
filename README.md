# Spring Cloud学习笔记


## 欢迎大家提问题交流
 项目参考博客：[https://zpj80231.gitee.io/znote/](https://zpj80231.gitee.io/znote/)

![](/images/springcloud架构图.png)

## 项目版本

- spring cloud版本：Dalston.SR1
- spring boot版本：1.5.19.RELEASE

## 项目模块说明

``` lua
spring-cloud
├── springcloud-api -- 构建公共子模块 + Hystrix服务降级
├── springcloud-euraka-7001 -- Eureka集群
├── springcloud-euraka-7002 -- Eureka集群
├── springcloud-euraka-7003 -- Eureka集群
├── springcloud-provider-dept-8001 -- 构建服务提供者集群
├── springcloud-provider-dept-8002 -- 构建服务提供者集群
├── springcloud-provider-dept-8003 -- 构建服务提供者集群
├── springcloud-consumer-dept-80 -- 构建服务消费者
├── springcloud-consumer-dept-feign -- 构建服务消费者
├── springcloud-provider-dept-hystrix-8001 -- Hystrix服务熔断
├── springcloud-consumer-hystrix-dashboard -- Hystrix调用监控 
├── springcloud-zuul-gateway-9527 -- Zuul路由网关 
├── springcloud-config-3344 -- config服务端 
└── springcloud-config-client-3355 -- config客户端
```

## 项目启动

1. 启动euraka-service端集群：
   - [springcloud-euraka-7001]
   - [springcloud-euraka-7002]
   - [springcloud-euraka-7003]
   
2. 启动微服务提供者集群：
   - [springcloud-provider-dept-8001 (连01数据库)]
   - [springcloud-provider-dept-8002 (连02数据库)]
   - [springcloud-provider-dept-8003 (连03数据库)]
   
3. 启动为服务消费者：
   > 以下两者二选一启动，它两主要区别（具体见笔记中第四小节）是：<br/>
   > dept-80：Ribbon+RestTemplate 调用Rest服务<br/>
   > dept-feign：Feign+接口 调用Rest服务（优雅简单）
   - [springcloud-consumer-dept-80 (含Ribbon客户端负载均衡)]
   - [springcloud-consumer-dept-feign (含Feign负载均衡、Hystrix服务降级)]
4. Hystrix 服务熔断、降级、监控   
   > 服务熔断：<br/>
   > 	缺点就是每一个方法对应都得写一个fallBackMethod方法，代码膨胀，所以我们之后看服务降级(*^__^*)<br/>
   >     主要在单个服务出异常的时候用<br/>
   > 
   > 服务降级：<br/>
   > 	统一处理主业务与熔断方法解耦，是在客户端（消费者）处理完成的，与服务端没关系<br/>
   >     主要在单个服务整个被关闭的时候用
   - [springcloud-provider-dept-hystrix-8001 (Hystrix服务熔断)]
   - [springcloud-api (Hystrix服务降级)]
   - [springcloud-consumer-hystrix-dashboard (Hystrix调用监控)]
   
5. Zuul 路由网关
   
   - [springcloud-zuul-gateway-9527 (Zuul路由网关)]
   
6. Config 分布式配置中心
   - [springcloud-config-3344 (config服务端)]
   - [springcloud-config-client-3355 (config客户端)]

