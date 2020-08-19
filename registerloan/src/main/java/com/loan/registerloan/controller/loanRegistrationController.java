package com.loan.registerloan.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.registerloan.models.RegisterLoanDetail;
import com.loan.registerloan.models.RegisterLoanResponse;
import com.loan.registerloan.service.RegisterLoanService;

@RestController
@CrossOrigin

public class loanRegistrationController {

	private RegisterLoanDetail RegisterLoanDetail;
	
	@Autowired
	private RegisterLoanService RegisterLoanService;

	@Autowired
	private RegisterLoanResponse RegisterLoanResponse;

	/*
	 * static Context context; private static final LambdaLogger logger =
	 * context.getLogger();
	 */
	private static final Logger log = LoggerFactory.getLogger(loanRegistrationController.class);

	@RequestMapping(value = "/loanregistration")

	public ResponseEntity Updation(@Valid @RequestBody RegisterLoanDetail Loan_dtl) throws Exception {
		log.info("inside_Updation");
		// logger.log("inside_Register");
		RegisterLoanResponse = RegisterLoanService.RegisterLoan(Loan_dtl);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Loan", "Registration");
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (RegisterLoanResponse.getId() == 200)
			return new ResponseEntity(RegisterLoanResponse, responseHeaders, HttpStatus.OK);
		else
			return new ResponseEntity(RegisterLoanResponse, responseHeaders, HttpStatus.BAD_REQUEST);

	}
	
	  
	  @GetMapping(value = {"/getallloans"})
	
	  public ResponseEntity<List<RegisterLoanDetail>> getAllCustomers() {
		  log.info("[ENTRY](getAllCustomers)");
	    List<RegisterLoanDetail> customers = RegisterLoanService.getAllCustomers();
	    ResponseEntity<List<RegisterLoanDetail>> responseEntity = ResponseEntity.ok(customers);
	    log.info("loandetails", responseEntity);
	    return responseEntity;
	  }

	  @Autowired
	  public void UserController(RegisterLoanDetail Loan_dtl) {
	    this.RegisterLoanDetail = Loan_dtl;
	  }
	  
}