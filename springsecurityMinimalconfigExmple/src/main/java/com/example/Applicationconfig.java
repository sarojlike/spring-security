package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/*
 * this class represents configuration file for spring mvc
 * This configuration class can be treated as a replacement of spring-servlet.xml
 * 
 * @EnableWebMvc is equivalent to mvc:annotation-driven in XML. 
 * It enables support for @Controller-annotated classes that use @RequestMapping to map incoming requests to specific method.
 * 
 * @ComponentScan is equivalent to context:component-scan base-package="..." 
 * 
*/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class Applicationconfig {

}
