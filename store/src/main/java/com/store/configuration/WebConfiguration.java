package com.store.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200")
	                .allowedMethods("*")
	                .allowCredentials(true);
	    }
	
	 
}
