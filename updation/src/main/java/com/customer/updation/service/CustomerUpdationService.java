package com.customer.updation.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.updation.models.CustomerUpdationDetail;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LOGGER;*/
import com.customer.updation.models.CustomerUpdationResponse;
import com.customer.updation.repo.CustomerUpdationRepository;

@Component
public class CustomerUpdationService {

	@Autowired
	private CustomerUpdationResponse CustomerUpdationResponse;
	
	@Autowired
	private CustomerUpdationRepository CustomerUpdationRepository;

	private static final Logger log = LoggerFactory.getLogger(CustomerUpdationService.class);

	

	public CustomerUpdationResponse Updation(CustomerUpdationDetail Customer_dtl) throws SQLException, IOException {
		log.info("CustomerUpdation : Inside Customer Updation Service");

		boolean Flag = true;
		
		//
		Optional first_name = Optional.ofNullable(Customer_dtl.getFirst_name());
		if (!first_name.isPresent() || (Customer_dtl.getFirst_name().length() == 0)) {
			log.info("customer name cannot be blank");
			CustomerUpdationResponse.setId(400);
			CustomerUpdationResponse.setMessage("Customer name cannot be blank");
			Flag = false;
		}
		Optional user_name = Optional.ofNullable(Customer_dtl.getUser_name());
		if (!user_name.isPresent() || (Customer_dtl.getUser_name().length() == 0)) {
			log.info("User name cannot be blank");
			CustomerUpdationResponse.setId(400);
			CustomerUpdationResponse.setMessage("User name cannot be blank");
			Flag = false;
		}
		Optional email = Optional.ofNullable(Customer_dtl.getEmail());
		if (!email.isPresent() || (Customer_dtl.getEmail().length() == 0)) {
			log.info("email cannot be blank");
			CustomerUpdationResponse.setId(400);
			CustomerUpdationResponse.setMessage("email cannot be blank");
			Flag = false;
		}
		Optional dob = Optional.ofNullable(Customer_dtl.getDob());
		if (!dob.isPresent() || (Customer_dtl.getDob().length() == 0)) {
			log.info("DOB cannot be blank");
			CustomerUpdationResponse.setId(400);
			CustomerUpdationResponse.setMessage("DOB cannot be blank");
			Flag = false;
		}
		Optional address = Optional.ofNullable(Customer_dtl.getAddress());
		if (!address.isPresent() || (Customer_dtl.getAddress().length() == 0)) {
			log.info("Address cannot be blank");
			CustomerUpdationResponse.setId(400);
			CustomerUpdationResponse.setMessage("Address cannot be blank");
			Flag = false;
		}
		Optional pan = Optional.ofNullable(Customer_dtl.getPan());
		if (!pan.isPresent() || (Customer_dtl.getPan().length() == 0)) {
			log.info("PAN number cannot be blank");
			CustomerUpdationResponse.setId(400);
			CustomerUpdationResponse.setMessage("PAN number cannot be blank");
			Flag = false;
		}
		
		//
		
		
		
		
		
		
		
		if (Flag == true) {
			try {
				
				List<CustomerUpdationDetail> listcustomers = CustomerUpdationRepository.custUserNameCount(Customer_dtl.getUser_name());
				if(listcustomers.stream().count() > 0)
				
				{

		
					 try {
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					CustomerUpdationRepository.updateCustomerDetails(Customer_dtl.getUser_name(), Customer_dtl.getFirst_name(), Customer_dtl.getAddress(), Customer_dtl.getEmail(), Customer_dtl.getPan(), Customer_dtl.getDob(), Customer_dtl.getUser_name(), date);
					log.info("The cutomer detail is updated");
					CustomerUpdationResponse.setMessage("The cutomer detail is updated");
					CustomerUpdationResponse.setId(200);
					 }catch (Exception e) {
						 CustomerUpdationResponse.setMessage("error");
					}
				}

				else {

					CustomerUpdationResponse.setMessage("Customer Does not Exixts");
					CustomerUpdationResponse.setId(400);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return CustomerUpdationResponse;

	}

}