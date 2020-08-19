package com.customer.updation.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.updation.models.CustomerUpdationDetail;
import com.customer.updation.models.CustomerUpdationResponse;
import com.customer.updation.service.CustomerUpdationService;

@SpringBootTest
public class CustomerUpdationServiceTest {
	@Autowired
	private CustomerUpdationService CustomerUpdationService;
	
	@Test
	public void addresschck() throws SQLException, IOException {
		CustomerUpdationDetail customer_dtl = new CustomerUpdationDetail();
		customer_dtl.setAddress(null);
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("555");
		CustomerUpdationResponse custResponse = CustomerUpdationService.Updation(customer_dtl);
		assertEquals("Address cannot be blank", custResponse.getMessage());
	}
	@Test
	public void dobchck() throws SQLException, IOException {
		CustomerUpdationDetail customer_dtl = new CustomerUpdationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob(null);
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("555");
		CustomerUpdationResponse custResponse = CustomerUpdationService.Updation(customer_dtl);
		assertEquals("DOB cannot be blank", custResponse.getMessage());
	}
	@Test
	public void emailchck() throws SQLException, IOException {
		CustomerUpdationDetail customer_dtl = new CustomerUpdationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail(null);
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("555");
		CustomerUpdationResponse custResponse = CustomerUpdationService.Updation(customer_dtl);
		assertEquals("email cannot be blank", custResponse.getMessage());
	}
	@Test
	public void namechck() throws SQLException, IOException {
		CustomerUpdationDetail customer_dtl = new CustomerUpdationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail("email");
		customer_dtl.setFirst_name(null);
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("555");
		CustomerUpdationResponse custResponse = CustomerUpdationService.Updation(customer_dtl);
		assertEquals("Customer name cannot be blank", custResponse.getMessage());
	}
	
	@Test
	public void panchck() throws SQLException, IOException {
		CustomerUpdationDetail customer_dtl = new CustomerUpdationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail("email");
		customer_dtl.setFirst_name("name");
		customer_dtl.setPan(null);
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("555");
		CustomerUpdationResponse custResponse = CustomerUpdationService.Updation(customer_dtl);
		assertEquals("PAN number cannot be blank", custResponse.getMessage());
	}
	@Test
	public void usernamechck() throws SQLException, IOException {
		CustomerUpdationDetail customer_dtl = new CustomerUpdationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail("email");
		customer_dtl.setFirst_name("name");
		customer_dtl.setPan("pN");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name(null);
		CustomerUpdationResponse custResponse = CustomerUpdationService.Updation(customer_dtl);
		assertEquals("User name cannot be blank", custResponse.getMessage());
	}
	
	
	
	
	@Test
	public void updateTest() throws SQLException, IOException {
		CustomerUpdationDetail customer_dtl = new CustomerUpdationDetail();
		customer_dtl.setAddress("chennai2");
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("555");
		CustomerUpdationResponse custResponse = CustomerUpdationService.Updation(customer_dtl);
		assertEquals("The cutomer detail is updated", custResponse.getMessage());
	}
		  
	@Test
	public void updateTestNoRecords() throws SQLException, IOException {
		CustomerUpdationDetail customer_dtl = new CustomerUpdationDetail();

		customer_dtl.setAddress("chennai2");
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("123");

		CustomerUpdationResponse custResponse = CustomerUpdationService.Updation(customer_dtl);

		assertEquals("Customer Does not Exixts", custResponse.getMessage());
	}
	

}
