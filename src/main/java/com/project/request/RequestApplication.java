package com.project.request;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Request FacScience API", version = "1.0", description = "Request FacScience Information"))
public class RequestApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RequestApplication.class, args);
	}

}
