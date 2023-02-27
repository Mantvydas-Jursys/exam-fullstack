package com.mantvydas.exambackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class ExamBackendApplication {

	private static final Logger logger = LoggerFactory.getLogger(ExamBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExamBackendApplication.class, args);
		
		logger.info("Application context running");

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000");
				
				
				logger.info("CORS filter configured to allow react-ui");
			}
		};
	}
}
