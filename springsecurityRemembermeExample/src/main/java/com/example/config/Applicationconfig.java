package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/*
 * this class represents configuration file for spring mvc
 * This configuration class can be treated as a replacement of spring-servlet.xml
 * 
 * @EnableWebMvc is equivalent to mvc:annotation-driven in XML. 
 * It enables support for @Controller-annotated classes that use @RequestMapping to map incoming requests to specific method.
 * 
 * @ComponentScan is equivalent to context:component-scan base-package="..." 
 * 
 * here view resolver is replacement for view resolever in spring-servlet.xml file
*/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class Applicationconfig {

	
		@Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	 
	        return viewResolver;
		}
	
}
