# 高端技术

:wolf: 分享一些大型互联网架构常用的高端技术

目录
-----------------

- [消息队列](#消息队列)
- [NoSql数据库](#nosql数据库)
- [检索](#检索)
- [任务调度](#任务调度)
- [文件系统](#文件系统)
- [即时通讯](#即时通讯)

## 消息队列 ##

### ActiveMQ

ActiveMQ 是Apache出品，最流行的，能力强劲的开源消息总线。ActiveMQ 是一个完全支持JMS1.1和J2EE 1.4规范的 JMS Provider实现，尽管JMS规范出台已经是很久的事情了，但是JMS在当今的J2EE应用中间仍然扮演着特殊的地位。

#### 实例

* [x] [activemq-demo](https://github.com/yandongquan/high-end-technology/tree/master/activemq-demo)
* [x] [spring-activemq-produce](https://github.com/yandongquan/high-end-technology/tree/master/spring-activemq-producer)
* [x] [spring-activemq-consumer](https://github.com/yandongquan/high-end-technology/tree/master/spring-activemq-consumer)

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


## NoSql数据库 ##

### Redis

Redis是一个开源的使用ANSI C语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。

#### 实例

* [ ] [redis-demo]()
* [ ] [spring-redis-demo]()
* [x] [spring-data-redis-demo](https://github.com/yandongquan/high-end-technology/tree/master/spring-data-redis-demo)


## 检索 ##

### solr

Solr是一个独立的企业级搜索应用服务器，它对外提供类似于Web-service的API接口。用户可以通过http请求，向搜索引擎服务器提交一定格式的XML文件，生成索引；也可以通过Http Get操作提出查找请求，并得到XML格式的返回结果。

#### 实例

* [ ] [solr-demo]()
* [ ] [spring-solr-demo]()

### ElasticSearch

ElasticSearch 是一个基于Lucene的搜索服务器。它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。

* [ ] [elasticSearch-demo]()
* [ ] [spring-elasticSearch-demo]()

## 任务调度 ##

## 文件系统 ##

#### FastDFS

FastDFS 是用 c 语言编写的一款开源的分布式文件系统。FastDFS 为互联网量身定制，充分考虑了冗余备份、负载均衡、线性扩容等机制，并注重高可用、高性能等指标，使用
FastDFS 很容易搭建一套高性能的文件服务器集群提供文件上传、下载等服务。

FastDFS 架构包括 Tracker server 和 Storage server。客户端请求 Tracker server 进行文件上传、下载，通过 Tracker server 调度最终由 Storage server 完成文件上传和下载。

- Tracker server 作用是负载均衡和调度，通过 Tracker server 在文件上传时可以根据一些策略找到 Storage server 提供文件上传服务。可以将 tracker 称为追踪服务器或调度服务器。
- Storage server 作用是文件存储，客户端上传的文件最终存储在 Storage 服务器上，Storageserver 没有实现自己的文件系统而是利用操作系统 的文件系统来管理文件。可以将
storage 称为存储服务器。

#### 实例

* [x] [fastdfs-demo]()
* [x] [spring-fastdfs-demo]()

## 即时通讯 ##
