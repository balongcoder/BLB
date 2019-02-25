package com.blb.dubbo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.blb.dubbo.api.BLBApiService;

@RestController
public class DemoController {
	@Reference(version = "${demo.service.version}", application = "${dubbo.application.id}"/*, url = "dubbo://localhost:12345"*/)
	private BLBApiService demoService;

	@RequestMapping("/sayHello")
	public String sayHello(@RequestParam String name) {
		return demoService.sayHello(name);
	}
}
