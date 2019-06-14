package com.cxn.learn.es.controller;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public ESDatas xxx(@RequestParam(value = "param1", required = false) String param1) {
        ESDatas a = ElasticSearchHelper.getRestClientUtil().searchAll(param1, Map.class);
        return a;
    }


}
