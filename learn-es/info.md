https://www.cnblogs.com/xinhuaxuan/p/8449328.html

https://www.cnblogs.com/ajianbeyourself/p/5529575.html

https://www.cnblogs.com/wenbronk/p/6386043.html

https://blog.csdn.net/jacksonary/article/details/82729556

https://blog.csdn.net/weixin_39835887/article/details/84103715

https://blog.csdn.net/li521wang/article/details/83792552#42_pomxml_118

http://10.10.196.95:9200/

```json5
{
  "name" : "yT2Ny4m",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "OXLBlOzYRu-OFfKwgn2-yQ",
  "version" : {
    "number" : "6.5.4",
    "build_flavor" : "default",
    "build_type" : "rpm",
    "build_hash" : "d2ef93d",
    "build_date" : "2018-12-17T21:17:40.758843Z",
    "build_snapshot" : false,
    "lucene_version" : "7.5.0",
    "minimum_wire_compatibility_version" : "5.6.0",
    "minimum_index_compatibility_version" : "5.0.0"
  },
  "tagline" : "You Know, for Search"
}

```

http://www.ruanyifeng.com/blog/2017/08/elasticsearch.html
https://segmentfault.com/a/1190000016830796

### 下面的命令可以查看当前节点的所有 Index
curl -X GET http://10.10.196.95:9200/_cat/indices?v


curl -X GET http://10.10.196.95:9200/_mapping?pretty=true

#### 新建 index
curl -X PUT 'http://10.10.196.95:9200/weather'

#### 删除 index
curl -X DELETE 'http://10.10.196.95:9200/book'


curl -X PUT 'http://10.10.196.95:9200/book' -d '
{
  "mappings": {
    "person": {
      "properties": {
        "id": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word"
        },
        "name": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word"
        }
      }
    }
  }
}'

#### 查询所有
http://10.10.196.95:9200/cxn/id-1/_search
### 分页查询
http://10.10.196.95:9200/cxn/id-1/_search?from=1&size=2
### 直接查询具体字段信息
http://10.10.196.95:9200/cxn/id-1/w0SnIWsBcu0eqvs9GOPX/_source

#### 查询某些字段
http://10.10.196.95:9200/cxn/id-1/w0SnIWsBcu0eqvs9GOPX/_source
http://10.10.196.95:9200/cxn/id-1/w0SnIWsBcu0eqvs9GOPX?_source=asd
http://10.10.196.95:9200/cxn/id-1/w0SnIWsBcu0eqvs9GOPX/_source?_source=asd

