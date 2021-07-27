package ksmart39.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ksmart39.springboot.interceptor.InspectionFinalResultInterceptor;
import ksmart39.springboot.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private final LoginInterceptor loginInterceptor;
	private final InspectionFinalResultInterceptor finalResultInterceptor;
	public WebConfig(LoginInterceptor loginInterceptor, InspectionFinalResultInterceptor finalResultInterceptor) {
		this.loginInterceptor = loginInterceptor;
		this.finalResultInterceptor = finalResultInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/Dashio/css/**")
				.excludePathPatterns("/login/**")
				.excludePathPatterns("/favicon.ico");
		/*
		 * registry.addInterceptor(finalResultInterceptor)
		 * .addPathPatterns("/quality/addInspectionMeasurementValue");
		 */
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	
}
