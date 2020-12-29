first-msp
=
    测试用项目
技术栈：[Spring Boot]( https://spring.io/projects/spring-boot )、[Eureka](https://spring.io/projects/spring-cloud-netflix )、[MySQL]( https://www.mysql.com/ )、[Apollo]( https://github.com/ctripcorp/apollo/wiki/Apollo%E9%85%8D%E7%BD%AE%E4%B8%AD%E5%BF%83%E4%BB%8B%E7%BB%8D )、[Zookeeper]( https://spring.io/projects/spring-cloud-zookeeper )、[Redis]( https://spring.io/projects/spring-data-redis )、[RabbitMQ]( https://www.rabbitmq.com/ )
    、[Prometheus]( https://prometheus.io/docs/introduction/overview/ ) [知乎](https://zhuanlan.zhihu.com/p/70090800 ) 
    注意事项：对所有系统配置文件修改需要用户权限控制

工具：[Grafana]( https://grafana.com/ )、[AlertManager]( https://www.prometheus.io/docs/alerting/latest/alertmanager/ )、[node_exporter](https://github.com/prometheus/node_exporter )、[mysqld_exporter](https://github.com/prometheus/mysqld_exporter )、[jmx_exporter](https://github.com/prometheus/jmx_exporter )、[zookeeper_exporter](https://github.com/carlpett/zookeeper_exporter )
### msp-alert
    配合prometheus，alertmanager使用，监控微服务应用状态，将prometheus告警信息通过短信、邮件、微信等通知方式告知应用所有者
    实现逻辑：prometheus定时拉取监控信息，判断是否达到设置的告警阈值、将告警信息推送至alertmanager，alertmanager将告警信息推送给自定义告警组件，根据告警信息选择合适的发送策略
系统设计：
    接收告警信息并选择性推送具体用户

数据库表设计：
    给重要字段添加索引信息，方便海量数据查询
    
        
### msp-auth
    用于用户权限统一验证服务，包括交易授权，用户权限查询，应用登陆
### msp-center
    eureka注册中心服务端
    原理：
### msp-ftp
    文件传输服务
### msp-logger
    日志相关
    
### msp-mail
    邮件服务
### msp-mock-server
    挡板应用
### msp-sso
    单点登录
### user-service
    微服务业务应用
    
### wisdom-tree
+ 想法：构建一颗可以成长的知识树，随着用户学习进度的提升，逐步点亮知识树上的果实，未来可对接第三方测试系统对相应知识点进行考核。
+ 实现：前端框架生成一颗带有数据节点的'树'，根据用户自定义的数据填充数据模型并渲染前端树形图，用户点击数据节点从根结点开始学习，达到一定限制后需要进行考核点亮知识节点。
+ 交互：用户可在当前数据节点下评论或回复/提交数据知识体系错误信息获得奖励
+ 
+

### 心得
     应用架构发展历程：
     mvc架构
     rpc架构
     soa架构
     微服务架构
     