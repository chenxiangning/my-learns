package com.cxn.learn.es.controller;

import com.cxn.learn.es.beans.vo.EsVO;
import com.cxn.learn.es.beans.vo.V;
import org.apache.commons.collections.map.HashedMap;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public V searchAll(@RequestParam(value = "index", required = false) String index,
                       @RequestParam(value = "startTime", required = false) String startTime,
                       @RequestParam(value = "endTime", required = false) String endTime,
                       @RequestParam(value = "from", required = true) int from,
                       @RequestParam(value = "size", required = true) int size,
                       @RequestParam(value = "msg", required = false) String[] msg) throws ParseException {


//        List<String> datas = new ArrayList<String>();
//        datas.add("blackcatdemo2");
//        datas.add("blackcatdemo3");

        Map params = new HashedMap();
        if (msg != null) {
            params.put("message", msg[0]);
        }
//        params.put("level", "DEBUG");
//        params.put("message", Arrays.asList(msg));
        params.put("from", from);
        params.put("size", size);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        params.put("startTime", dateFormat.parse(startTime).getTime());
        params.put("endTime", dateFormat.parse(endTime).getTime());

        ESDatas a = ElasticSearchHelper.getConfigRestClientUtil("esmapper/searchafter.xml")
                .searchList(index + "/_search", "searchAfterDSL", params, Map.class);

        EsVO esVO = new EsVO();
        esVO.setList(a.getDatas());
        esVO.setCurrentPage(from);
        esVO.setCurrentSize(size);
        esVO.setTotalCount(a.getTotalSize());
        if (size != 0) {
            esVO.setTotalPages((int) (a.getTotalSize() / size));
        }

        return V.ok(esVO);
    }



}
