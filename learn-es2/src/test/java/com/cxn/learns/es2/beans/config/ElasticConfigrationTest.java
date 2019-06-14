package com.cxn.learns.es2.beans.config;


import com.reachauto.hkr.tennis.notscan.gson.GsonTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ElasticConfigrationTest {

    private String esHost = "10.10.196.95";

    private int esPort = 9200;

    private String esClusterName = "elasticsearch";

    private TransportClient client;

    private BulkProcessor bulkProcessor;

    @Before
    public void init() throws UnknownHostException {
        //设置集群名称
        Settings settings = Settings.builder().put("cluster.name", esClusterName).build();// 集群名
        //创建client
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(esHost), 9200));

    }

    @Test
    public void m1() {
        Map a = new HashMap();
        a.put("sd", "sdsd");
        a.put("dsf", "zvxcv234");
        a.put("asdadasd", "234");
        a.put("werewr", "werwerwer");
        addDocumentToBulkProcessor("index-day-1", "ttt", a);
        queryDocumentByParam("index-day-1", "ttt");
//        Map b = new HashMap();
//        b.put("sd", "xxxx");
//        b.put("dsf", "ssss");
//        b.put("asdadasd", "wwww");
//        b.put("werewr", "eeee");
//        addDocument("index-day-1", "ttt", a);
    }

    /**
     * 批量添加,性能最好
     */
    public void addDocumentToBulkProcessor(String indices, String type, Object object) {
        bulkProcessor.add(client.prepareIndex(indices, type).setSource(GsonTool.objectToAllFieldNullJson(object)).request());
    }

    public SearchRequestBuilder buildRequest(String indices, String type) {
        return client.prepareSearch(indices).setTypes(type);
    }

    public <T> List<T> queryDocumentByParam(String indices, String type) {
        // 批量查询
        MultiGetResponse response = client.prepareMultiGet()
                .add("my_person", "my_index", "1")// 查询id为1的文档
                .add("my_person", "my_index", "2", "3", "4")// ids,id列表
                .add("telegraph", "msg", "2")// 可以查询其他索引里面的数据
                .get();
        // 获取相应结果
        for (MultiGetItemResponse multiGetItemResponse : response) { // 遍历结果集
            GetResponse getResponse = multiGetItemResponse.getResponse();
            if (getResponse.isExists()) {// 判断文档是否存在
                String json = getResponse.getSourceAsString();
                System.out.println(json);
            }
        }
        return null;
    }

    private BoolQueryBuilder convertParam() {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        if (StringUtils.hasText(param.getUserName())) {
//            boolQueryBuilder.must(QueryBuilders.termQuery("userName", param.getUserName()));
//        }
//        if (param.getAge() != null) {
//            boolQueryBuilder.must(QueryBuilders.rangeQuery("age").gt(param.getAge()));
//        }
//        if (StringUtils.hasText(param.getDescription())) {
//            boolQueryBuilder.must(QueryBuilders.matchQuery("description", param.getDescription()));
//        }
//        if (StringUtils.hasText(param.getRoleName())) {
//            boolQueryBuilder.must(QueryBuilders.nestedQuery("roles", QueryBuilders.termQuery("roles.name", param.getRoleName()), ScoreMode.None));
//        }

        return boolQueryBuilder;
    }

    public void addDocument(String indices, String type, Object object) {
        IndexResponse resp = client.prepareIndex(indices, type).setSource(GsonTool.objectToAllFieldNullJson(object)).get();
        log.info("添加结果：{}", resp.toString());
    }

}
