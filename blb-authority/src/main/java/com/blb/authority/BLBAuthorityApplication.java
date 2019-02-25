package com.blb.authority;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.blb"}) // 设置bean的扫描包
@MapperScan("com.blb.**.mapper") // 设置mybatis的Mapper扫描包
@EnableCaching
public class BLBAuthorityApplication {
	public static void main(String[] args) {
		SpringApplication.run(BLBAuthorityApplication.class, args);
	}
}
