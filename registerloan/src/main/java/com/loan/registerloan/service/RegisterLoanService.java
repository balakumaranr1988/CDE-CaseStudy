package com.loan.registerloan.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.loan.registerloan.models.RegisterLoanDetail;
import com.loan.registerloan.models.CustomerUpdateDetail;
import com.loan.registerloan.models.RegisterLoanResponse;
import com.loan.registerloan.repository.RegisterLoanRepository;

@Component
public class RegisterLoanService {

	@Autowired
	private RegisterLoanResponse RegisterLoanResponse;

	@Autowired
	private RegisterLoanRepository registerLoanRepository;

	private static final Logger log = LoggerFactory.getLogger(RegisterLoanService.class);
	private static Random rand = new Random();
	public RegisterLoanResponse RegisterLoan(RegisterLoanDetail Loan_dtl) throws SQLException, IOException {
		log.info("Register : Inside Loan Service");

		boolean Flag = true;


		if ((Loan_dtl.getUser_name()).length() == 0) {
			log.info("RegisterLoanApp : User name cannot be blank");
			RegisterLoanResponse.setMessage("User name cannot be blank");
			RegisterLoanResponse.setId(400);
			Flag = false;
		} else if ((Loan_dtl.getDuration()).length() == 0) {
			log.info("RegisterLoanApp : Loan cannot be blank");
			RegisterLoanResponse.setMessage("Loan Duration cannot be blank");
			RegisterLoanResponse.setId(400);
			Flag = false;
		} else if ((Loan_dtl.getLoan_amount()).length() == 0) {
			log.info("RegisterLoanApp : Loan Amount cannot be blank");
			RegisterLoanResponse.setMessage("Loan Amount cannot be blank");
			RegisterLoanResponse.setId(400);
			Flag = false;
		} else if ((Loan_dtl.getLoan_type()).length() == 0) {
			log.info("RegisterLoanApp : Loan Type cannot be blank");
			RegisterLoanResponse.setMessage("Loan Type cannot be blank");
			RegisterLoanResponse.setId(400);
			Flag = false;
		} else if ((Loan_dtl.getRateofint()).length() == 0) {
			log.info("RegisterLoanApp : Rate of Interest cannot be blank");
			RegisterLoanResponse.setMessage("Rate of Interest cannot be blank");
			RegisterLoanResponse.setId(400);
			Flag = false;
		}

		if (Flag == true) {
			try {

			List<CustomerUpdateDetail> custlist = registerLoanRepository.loanUserDetailsCount(Loan_dtl.getUser_name());
				if (custlist.stream().count() > 0) {
					
				List<RegisterLoanDetail> loanlist = registerLoanRepository.loanUserDetailsCheck(Loan_dtl.getUser_name(),Loan_dtl.getLoan_type());
					if ( loanlist.stream().count() > 0)
					{
						RegisterLoanResponse.setMessage("This particular loan type already exixts for the customer");
						RegisterLoanResponse.setId(400);
						log.info("RegisterLoanApp : This particular loan type already exixts for the customer");
						
					}
					else
					{	
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					

					int loanid = rand.nextInt(1000) + 1;
					Loan_dtl.setLoanid(loanid);
					Loan_dtl.setUpdatedat(date);
					Loan_dtl.setUpdatedby(Loan_dtl.getUser_name());
					
					

					try {
						registerLoanRepository.save(Loan_dtl);
						log.info("RegisterLoanApp : The Loan is Registered");
						RegisterLoanResponse.setMessage("The Loan is Registered");
						RegisterLoanResponse.setId(200);
					} catch (Exception e) {
						log.info("RegisterLoanApp - error", e);
						RegisterLoanResponse.setMessage("error");

					}
					}

				}

				else {
					log.info("RegisterLoanApp : Customer Does not Exixts");
					RegisterLoanResponse.setMessage("Customer Does not Exixts");
					RegisterLoanResponse.setId(400);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.info("RegisterLoanApp : Customer Does not Exixts", e);
				e.printStackTrace();
			}

		}
		return RegisterLoanResponse;

	}
	public List<RegisterLoanDetail> getAllCustomers() {
	    List<RegisterLoanDetail> customers = registerLoanRepository.findAll();
	    return customers;
	  }



}