package ksmart39.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ksmart39.springboot.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private final LoginInterceptor loginInterceptor;
	public WebConfig(LoginInterceptor loginInterceptor) {
		this.loginInterceptor = loginInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/Dashio/**")
				.excludePathPatterns("/login/**")
				.excludePathPatterns("/favicon.ico")
				.excludePathPatterns("/package/**")
				.excludePathPatterns("/jplot/**");
		/*
		 * registry.addInterceptor(finalResultInterceptor)
		 * .addPathPatterns("/quality/addInspectionMeasurementValue");
		 */
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	
}
