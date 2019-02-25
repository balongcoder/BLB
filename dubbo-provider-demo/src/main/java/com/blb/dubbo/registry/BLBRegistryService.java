package com.blb.dubbo.registry;

import com.alibaba.dubbo.config.annotation.Service;
import com.blb.dubbo.api.BLBApiService;

@Service(
		version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        /*protocol = "${dubbo.protocol.id}",*/
        registry = "${dubbo.registry.id}"
		)
public class BLBRegistryService implements BLBApiService {
	@Override
	public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
