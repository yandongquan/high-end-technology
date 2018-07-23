# high-end-technology

:wolf: 分享一些大型互联网架构常用的高端技术

目录
-----------------

- [消息队列](#消息队列)
- [NoSQL数据库](#NoSQL数据库)
- [检索](#检索)
- [任务调度](#任务调度)
- [文件系统](#文件系统)
- [即时通讯](即时通讯)

## 消息队列 ##

### ActiveMQ

ActiveMQ 是Apache出品，最流行的，能力强劲的开源消息总线。ActiveMQ 是一个完全支持JMS1.1和J2EE 1.4规范的 JMS Provider实现，尽管JMS规范出台已经是很久的事情了，但是JMS在当今的J2EE应用中间仍然扮演着特殊的地位。

#### 实例

* [x] [activemq-demo](https://github.com/yandongquan/high-end-technology/tree/master/activemq-demo)
* [ ] [spring-activemq-produce]()
* [ ] [spring-activemq-consumer]()

### RocketMQ

RcoketMQ 是一款低延迟、高可靠、可伸缩、易于使用的消息中间件。具有以下特性：

- 支持发布/订阅（Pub/Sub）和点对点（P2P）消息模型
- 在一个队列中可靠的先进先出（FIFO）和严格的顺序传递
- 支持拉（pull）和推（push）两种消息模式
- 单一队列百万消息的堆积能力
- 支持多种消息协议，如 JMS、MQTT 等
- 高可用的部署架构,满足至少一次消息传递语义
- 提供 docker 镜像用于隔离测试和云集群部署
- 提供配置、指标和监控等功能丰富的 Dashboard

#### 实例

* [ ] [rocketmq-demo]()
* [ ] [spring-rocketmq-produce]()
* [ ] [spring-rocketmq-consumer]()


## NoSQL数据库 ##

### Redis

Redis是一个开源的使用ANSI C语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。

#### 实例

* [ ] [redis-demo]()
* [ ] [spring-redis-demo]()
* [ ] [spring-data-redis-demo]()


## 检索 ##

## 任务调度 ##

## 文件系统 ##

## 即时通讯 ##