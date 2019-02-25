package com.blb.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableAutoConfiguration
public class DubboConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class, args);
	}
}
