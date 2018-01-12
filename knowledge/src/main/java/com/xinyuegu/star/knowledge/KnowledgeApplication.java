package com.xinyuegu.star.knowledge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.xinyuegu.star.common, com.xinyuegu.star.knowledge")
@EnableEurekaClient
@MapperScan("com.xinyuegu.star.knowledge.mapper.**")
public class KnowledgeApplication {
	public static void main(String[] args) {
		SpringApplication.run(KnowledgeApplication.class, args);
	}
}
