package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class DemoApplication {
	/*@Bean
	MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory=new MultipartConfigFactory();
		factory.setLocation("/selfSet/tmp");
		return factory.createMultipartConfig();
	}*/
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
}
