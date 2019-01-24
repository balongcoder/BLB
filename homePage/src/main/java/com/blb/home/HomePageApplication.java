package com.blb.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com.blb"}) // 设置bean的扫描包
@MapperScan("com.blb.**.mapper") // 设置mybatis的Mapper扫描包
public class HomePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomePageApplication.class);
	}
}
