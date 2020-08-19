package com.customer.updation.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.updation.models.CustomerUpdationDetail;
import com.customer.updation.models.CustomerUpdationResponse;
import com.customer.updation.service.CustomerUpdationService;

@RestController
@CrossOrigin

public class CustomerUpdationController {

	@Autowired
	private CustomerUpdationService CustomerUpdationService;

	@Autowired
	private CustomerUpdationResponse CustomerUpdationResponse;

	/*
	 * static Context context; private static final LambdaLogger logger =
	 * context.getLogger();
	 */
	private static final Logger log = LoggerFactory.getLogger(CustomerUpdationController.class);

	@RequestMapping(value = "/customerupdation")

	public ResponseEntity Updation(@Valid @RequestBody CustomerUpdationDetail Customer_dtl) throws Exception {
		log.info("inside_Updation");
		// logger.log("inside_Register");
		CustomerUpdationResponse = CustomerUpdationService.Updation(Customer_dtl);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Cutomer", "Updation");
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (CustomerUpdationResponse.getId() == 200)
			return new ResponseEntity(CustomerUpdationResponse, responseHeaders, HttpStatus.OK);
		else
			return new ResponseEntity(CustomerUpdationResponse, responseHeaders, HttpStatus.BAD_REQUEST);

	}

}