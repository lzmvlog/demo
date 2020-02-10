1、将服务提供者注册到注册中心
    1).导入 dubbo 依赖 dubbo 2.6 以后使用 curator 作为服务注册中心        
2)、让服务消费者去注册中心订阅服务提供者的服务

注意：
未整合 springboot 的 provider 、 consumer 两个服务 因为依赖的更改 不能启动 
需要最基础的依赖 (被注解的那部分)
```pom
        <!-- dubbo -->
       <dependency>
           <groupId>com.alibaba</groupId>
           <artifactId>dubbo</artifactId>
           <version>2.6.7</version>
       </dependency>
       <!-- lombok -->
       <dependency>
           <groupId>org.projectlombok</groupId>
           <artifactId>lombok</artifactId>
           <version>1.18.10</version>
           <scope>provided</scope>
       </dependency>
```
后续的整合 springboot 服务 依赖更改 查看 `pom.xml`

超时优先的顺序
    1、精确优先 （方法优先、接口次之、全局配置再次之）
    2、消费者设置优先 （如果级别一样 则消费方优先 提供方次之）
    
springboot 与 dubbo 的整合方式：
    1、 基于 dubbo-spring-boot-starter
    2、基于 xml 配置文件
    3、使用注解 API 的方式 将每一个组件手动创建到容器中
    
 负载均衡：dubbo 默认 随机负载均衡
    loadbalance：
        radom 随机负载均衡
        roundrobin 轮询
        leastactive 最少活跃调用数
        consistenhash 一致性 Hash


