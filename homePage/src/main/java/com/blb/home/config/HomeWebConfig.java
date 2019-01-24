package com.blb.home.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class HomeWebConfig extends WebMvcConfigurerAdapter {
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
		        request.setAttribute("basePath", "http://127.0.0.1:8801");
		        request.setAttribute("exhibitionPath", "http://127.0.0.1:8802");
		        request.setAttribute("writePath", "http://127.0.0.1:8800");
		        //request.setAttribute("basePath", "http://127.0.0.1:8801");
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
	    .excludePathPatterns("/js/*", "/css/*", "/imgs/*"); //指定该类不拦截的url
	}
	

	//统一页码处理配置
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	    return new EmbeddedServletContainerCustomizer() {
	        @Override
	        public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
	            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
 
	            container.addErrorPages( error404Page, error500Page);
	        }
	    };
	}
//	
//	@Bean
//    public ErrorPageRegistrar errorPageRegistrar(){
//        return new ErrorPageRegistrar() {
//
//			@Override
//			public void registerErrorPages(ErrorPageRegistry registry) {
//				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
//	            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
//		        registry.addErrorPages(error404Page, error500Page);
//
//			}
//        };
//    }
}
