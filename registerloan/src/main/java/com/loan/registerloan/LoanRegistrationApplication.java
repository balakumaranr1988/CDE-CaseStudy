package com.loan.registerloan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.loan.registerloan.repository.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
@ComponentScan(basePackages = {"com.loan.registerloan"})
public class LoanRegistrationApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(LoanRegistrationApplication.class);
	
	

	private UserRepository UserRepository;

	  @Autowired
	  public UserRepository Application(UserRepository userRepository) {
	    return this.UserRepository = userRepository;
	  }
	public static void main(String[] args) {
		log.info("LoanRegistrationApplication");
		SpringApplication.run(LoanRegistrationApplication.class, args);
	}

}
