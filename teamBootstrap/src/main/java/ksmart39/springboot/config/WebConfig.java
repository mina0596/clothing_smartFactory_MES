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
				/* .excludePathPatterns("/login/index") */
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
