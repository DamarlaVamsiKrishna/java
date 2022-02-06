package com.thoughtfocus.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProjectApplication {

	static Logger logger = LoggerFactory.getLogger(ProjectApplication.class);

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application-config");
		SpringApplication.run(ProjectApplication.class, args);
		logger.info("hello world");
		
	}
}
