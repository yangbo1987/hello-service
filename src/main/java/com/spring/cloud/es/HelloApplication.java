package com.spring.cloud.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;


@EnableDiscoveryClient
@SpringBootApplication
public class HelloApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
		System.out.println("服务提供者启动成功...");
	}
}
