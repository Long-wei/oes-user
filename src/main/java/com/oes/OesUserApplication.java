package com.oes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.oes.mapper")
public class OesUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OesUserApplication.class, args);
	}

}
