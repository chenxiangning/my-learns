package com.cxn.example.learns.controller;

import com.cxn.example.learns.beans.resp.V;
import com.google.gson.JsonSyntaxException;
import com.reachauto.hkr.tennis.notscan.gson.GsonTool;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cxn
 * Date: 19-6-4 下午1:40
 * This is my work in reachauto code.
 * mail:chenxiangning@reachauto.com
 * Description:
 */
@RestController
@RequestMapping("es")
public class ESDemoController {
    @Autowired
    private RestClient client;
//    @Autowired
//    private RestHighLevelClient highLevelClient;

    /**
     * 添加 index
     *
     * @return ResponseEntity
     * @throws IOException
     */
    @RequestMapping(value = "/{index}.index", method = RequestMethod.POST)
    public ResponseEntity<String> addIndex(@PathVariable("index") String index) throws IOException {
        // 构造HTTP请求，第一个参数是请求方法，第二个参数是服务器的端点，host默认是http://localhost:9200，
        // endpoint直接指定为index/type的形式

        Request request = new Request(RequestMethod.PUT.name(), new StringBuilder("/" + index).toString());
        // 设置其他一些参数比如美化json
        request.addParameter("pretty", "true");
        // 发送HTTP请求
        Response response = client.performRequest(request);
        // 获取响应体
        String responseBody = EntityUtils.toString(response.getEntity());
        return new ResponseEntity(responseBody, HttpStatus.OK);
    }

    /**
     * 删除 index
     *
     * @return ResponseEntity
     * @throws IOException
     */
    @RequestMapping(value = "/{index}.index", method = RequestMethod.DELETE)
    public ResponseEntity<String> delIndex(@PathVariable("index") String index) throws IOException {
        // 构造HTTP请求，第一个参数是请求方法，第二个参数是服务器的端点，host默认是http://localhost:9200，
        // endpoint直接指定为index/type的形式

        Request request = new Request(RequestMethod.DELETE.name(), new StringBuilder("/" + index).toString());
        // 设置其他一些参数比如美化json
        request.addParameter("pretty", "true");
        // 发送HTTP请求
        Response response = client.performRequest(request);
        // 获取响应体
        String responseBody = EntityUtils.toString(response.getEntity());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


    /**
     * 添加ES对象, Book的ID就是ES中存储的document的ID，所以最好不要为空，自定义生成的ID太浮夸
     *
     * @return ResponseEntity
     * @throws IOException
     */
    @RequestMapping(value = "/添加数据.{index}.{type}.{id}", method = RequestMethod.POST)
    public ResponseEntity<String> add(@PathVariable("index") String index, @PathVariable("type") String type, @PathVariable("id") String id,
                                      @RequestBody Map map) throws IOException {
        // 构造HTTP请求，第一个参数是请求方法，第二个参数是服务器的端点，host默认是http://localhost:9200，
        // endpoint直接指定为index/type的形式
        Request request = new Request(RequestMethod.POST.name(), new StringBuilder("/" + index + "/").append(type).append("/").append(id).toString());

        // 设置其他一些参数比如美化json
        request.addParameter("pretty", "true");
        String json = GsonTool.objectToAllFieldNullJson(map);

        // 设置请求体并指定ContentType，如果不指定默认为APPLICATION_JSON
        request.setEntity(new NStringEntity(json, ContentType.APPLICATION_JSON));

        // 发送HTTP请求
        Response response = client.performRequest(request);

        // 获取响应体, id: AWXvzZYWXWr3RnGSLyhH
        String responseBody = EntityUtils.toString(response.getEntity());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 根据id获取ES对象
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/查询数据.{index}.{type}.{id}", method = RequestMethod.GET)
    public V getBookById(@PathVariable("index") String index, @PathVariable("type") String type, @PathVariable("id") String id) {
        Request request = new Request(RequestMethod.GET.name(), new StringBuilder("/" + index + "/").append(type).append("/").append(id).toString());
        // 添加json返回优化
        request.addParameter("pretty", "true");
        Response response = null;
        String responseBody = null;
        try {
            // 执行HHTP请求
            response = client.performRequest(request);
            responseBody = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            return V.error(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }

        return V.ok(GsonTool.jsonToMap(responseBody));
    }


    /**
     * 根据id获取ES对象
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/自定义查询.{url}", method = RequestMethod.GET)
    public V gei自定义查询(@PathVariable("url") String url) {
        Request request = new Request(RequestMethod.GET.name(), new StringBuilder(url.replace("#", "/")).toString());
        // 添加json返回优化
        request.addParameter("pretty", "true");
        Response response = null;
        String responseBody = null;
        try {
            // 执行HHTP请求
            response = client.performRequest(request);
            responseBody = EntityUtils.toString(response.getEntity());
            return V.ok(GsonTool.jsonToMap(responseBody));
        } catch (Exception e) {
            if (e instanceof JsonSyntaxException) {
                return V.ok(responseBody);
            }
            return V.error(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }


//    /**
//     * 根据id获取ES对象
//     *
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/查询数据s", method = RequestMethod.GET)
//    public V xxx() {
//        SearchRequest searchRequest = new SearchRequest();
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//
////        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("user", "kimchy")
////                .fuzziness(Fuzziness.AUTO)
////                .prefixLength(3)
////                .maxExpansions(10);
////        searchSourceBuilder.query(matchQueryBuilder);
//        searchRequest.source(searchSourceBuilder);
//
//        try {
//            SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//            return V.ok(searchResponse.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return V.error(e.getMessage());
//        }
//
//    }
}