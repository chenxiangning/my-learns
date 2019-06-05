//package com.cxn.example.learns.beans.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.Objects;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @author cxn
// * Date: 19-6-4 下午3:07
// * This is my work in reachauto code.
// * mail:chenxiangning@reachauto.com
// * Description:
// */
//@Slf4j
//@Configuration
//public class ElasticsearchRestClient {
//    private static final int ADDRESS_LENGTH = 2;
//    private static final String HTTP_SCHEME = "http";
//
//    /**
//     * 使用冒号隔开ip和端口1
//     */
//    @Value("${elasticsearch.ip}")
//    String[] ipAddress;
//
//    @Bean
//    public RestClientBuilder restClientBuilder() {
//        HttpHost[] hosts = Arrays.stream(ipAddress)
//                .map(this::makeHttpHost)
//                .filter(Objects::nonNull)
//                .toArray(HttpHost[]::new);
//        log.debug("hosts:{}", Arrays.toString(hosts));
//        return RestClient.builder(hosts);
//    }
//
//
//    @Bean(name = "highLevelClient")
//    public RestHighLevelClient highLevelClient(@Autowired RestClientBuilder restClientBuilder) {
//        restClientBuilder.setMaxRetryTimeoutMillis(60000);
//        return new RestHighLevelClient(restClientBuilder);
//    }
//
//
//    private HttpHost makeHttpHost(String s) {
//        assert StringUtils.isNotEmpty(s);
//        String[] address = s.split(":");
//        if (address.length == ADDRESS_LENGTH) {
//            String ip = address[0];
//            int port = Integer.parseInt(address[1]);
//            return new HttpHost(ip, port, HTTP_SCHEME);
//        } else {
//            return null;
//        }
//    }
//}