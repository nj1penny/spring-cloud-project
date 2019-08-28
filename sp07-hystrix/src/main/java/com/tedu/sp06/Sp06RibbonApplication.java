package com.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@SpringBootApplication
//以上三个可以被这一个替代
@SpringCloudApplication

public class Sp06RibbonApplication {
	@LoadBalanced
	//创建 RestTemplate 实例，并存入 spring 容器
	@Bean
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);
		f.setReadTimeout(1000);
		return new RestTemplate(f);
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(Sp06RibbonApplication.class, args);
	}

}
