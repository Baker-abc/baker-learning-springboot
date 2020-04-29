## 一、安装
* es 6.2.2： https://www.elastic.co/cn/downloads/past-releases/elasticsearch-6-2-2
* 分词插件：在es的bin目录下。运行下载：elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.2.2/elasticsearch-analysis-ik-6.2.2.zip
* es可视化工具kibana：https://artifacts.elastic.co/downloads/kibana/kibana-6.2.2-windows-x86_64.zip

## 二、启动 
* es启动：/bin/elasticsearch.bat        http://localhost:9200
* kibana启动：/bin/kibana.bat           http://localhost:5601

## 三、命令（在kibnan的dev-tool）
* 集群状态：GET /_cat/health?v
* 节点状态：GET /_cat/nodes?v

* 全部索引：GET /_cat/indices?v
* 创建索引：PUT /example
* 删除索引：DELETE /example

* 查看文档类型：GET /example/example/_mapping
* 索引中添加文档：
```
PUT /example/example/1
{
  "name": "test1"
}
```
* 查看文档：PUT /example/example/1
* 修改文档：
```
POST /example/example/1/_update
{
  "example": { "name": "test2" }
}
```
* 删除文档：DELETE /example/example/1

* 批量添加文档：
```
POST /example/example/_bulk
{"index":{"_id":"1"}}
{"name": "test1" }
{"index":{"_id":"2"}}
{"name": "test2" }
```
* 批量导出索引文档：curl -X POST -H "Content-Type: application/json" localhost:9200/design/style/_bulk?pretty --data-binary @test2.json



## 参考：
* [更多命令](https://es.xiaoleilu.com/index.html)
* [安装](https://mp.weixin.qq.com/s?__biz=MzU1Nzg4NjgyMw==&mid=2247484699&idx=1&sn=5367206c3c3da2278821dd9fad648850&scene=21#wechat_redirect)
* [项目](https://github.com/macrozheng/mall-learning/tree/master/mall-tiny-06)
* [项目](https://github.com/YunaiV/SpringBoot-Labs/tree/master/lab-15/lab-15-spring-data-elasticsearch)
* [spring es](https://docs.spring.io/spring-data/elasticsearch/docs/4.0.0.RC1/reference/html/#reference)