package com.cxn.learn.es.beans.config;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.boot.ElasticSearchBoot;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cxn
 * Date: 19-6-14 下午3:10
 * This is my work in reachauto code.
 * mail:chenxiangning@reachauto.com
 * Description:
 */
@Component
public class Init implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ElasticSearchBoot.boot("application-dev.properties");
    }
}