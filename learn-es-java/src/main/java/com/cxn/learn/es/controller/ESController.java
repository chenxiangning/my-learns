package com.cxn.learn.es.controller;

import org.apache.commons.collections.map.HashedMap;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("es")
public class ESController {


    @RequestMapping(value = "/环境验证",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String a() {
        //创建es客户端工具，验证环境
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        //验证环境,获取es状态
        String response = clientUtil.executeHttp("_cluster/state?pretty", ClientInterface.HTTP_GET);
        return response;
    }

    @RequestMapping(value = "/判断索引",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String checkIndex(@RequestParam(value = "index", required = true) String index) throws ParseException {
        boolean exist = ElasticSearchHelper.getRestClientUtil().existIndice(index);
        return String.valueOf(exist);
    }

    @RequestMapping(value = "/创建索引",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String hello(@RequestParam(value = "param1", required = false) String param1) throws ParseException {
        String x = ElasticSearchHelper.getRestClientUtil().createIndiceMapping(param1, "aaa");
        return x;
    }

    @RequestMapping(value = "/searchAll",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ESDatas xxx(@RequestParam(value = "index", required = false) String index, @RequestParam(value = "startTime", required = false) String startTime,
                       @RequestParam(value = "endTime", required = false) String endTime) throws ParseException {

        Map params = new HashedMap();
        params.put("pageSize", 10);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        params.put("startTime", dateFormat.parse(startTime).getTime());
        params.put("endTime", dateFormat.parse(endTime).getTime());

        ESDatas a = ElasticSearchHelper.getConfigRestClientUtil("esmapper/searchafter.xml")
                .searchList(index + "/_search", "searchAfterDSL", params, Map.class);

        return a;
    }


}
