package com.student.SwagerConfig;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwagerConfiguration {

	public static final Contact DEFAULT_CONTACT = new Contact("Employee Data", "http://localhost:8080/v2", "saurav.tit@gmail.com");
	  public static final ApiInfo API_DEFAULT = new ApiInfo(
			  "Employee Api Documentation", 
			  "API Documentation Of Employee", 
			  "1.1", 
			  "urn:tos",
	          DEFAULT_CONTACT, 
	          "EmployeeAPI 2.0", 
	          "www.dtspay.co.in",new ArrayList<VendorExtension>());

	
	//@ http://localhost:8080/swagger-ui.html#
	//@ http://localhost:8080/v2/api-docs
	@Bean
	public Docket swagerAPI() {
		return new  Docket(DocumentationType.SWAGGER_2).apiInfo(API_DEFAULT);
	}
}
