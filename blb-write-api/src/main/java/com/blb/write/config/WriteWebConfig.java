package com.blb.write.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.blb.write.init.WriteProjectInit;
import com.blb.write.util.ParamUtil;

@Configuration
public class WriteWebConfig  extends WebMvcConfigurerAdapter {
	
	@Autowired
	private WriteConfigPropertise configPropertise;
	
	public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
		        request.setAttribute("basePath", configPropertise.getBaseUrl());
		        return true;
			}

			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				
			}

			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
					Exception ex) throws Exception {
				
			}
        	
        })//指定拦截器类
        .addPathPatterns("/**")//指定该类拦截的url
        .excludePathPatterns("/js/*", "/css/*"); //指定该类不拦截的url
    }
	
	@Bean
	public WriteProjectInit projectInit() {
		initParan();
		WriteProjectInit projectInit = new WriteProjectInit();
		return projectInit;
	}
	
	private void initParan() {
		ParamUtil.setBaseUrl(configPropertise.getBaseUrl());
		ParamUtil.setUploadUrl(configPropertise.getUploadUrl());
		ParamUtil.setUploadUserName(configPropertise.getUploadUserName());
		ParamUtil.setUploadUserPass(configPropertise.getUploadUserPass());
		ParamUtil.setCachePath(configPropertise.getCachePath());
		ParamUtil.setProjectName(configPropertise.getProjectName());
	}
}
