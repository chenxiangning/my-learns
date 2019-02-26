package com.cxn.example.learn01;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class Learn01Application {

	public static void main(String[] args) {
		SpringApplication.run(Learn01Application.class, args);
	}

}
