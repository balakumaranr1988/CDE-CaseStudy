package com.customer.updation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.customer.updation"})
public class CustomerUpdationApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(CustomerUpdationApplication.class);
	
	public static void main(String[] args) {
		log.info("CustomerUpdationApplication");
		SpringApplication.run(CustomerUpdationApplication.class, args);
	}

}
