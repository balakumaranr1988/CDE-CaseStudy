
package com.loan.registerloan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.loan.registerloan.models.RegisterLoanDetail;
import com.loan.registerloan.models.RegisterLoanResponse;

@SpringBootTest
public class RegisterLoanServiceTest {
	
	@Autowired 
	public RegisterLoanService service;

	@Test
	public void registerLoanTestForNoRecords() throws SQLException, IOException {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		RegisterLoanDetail loanDetails = new RegisterLoanDetail();
		loanDetails.setDuration("2months");
		loanDetails.setUser_name("xyz");
		loanDetails.setLoan_amount("2lacks");
		loanDetails.setLoan_type("house");
		loanDetails.setRateofint("12");
		loanDetails.setUpdatedby("venkatareddy");
		loanDetails.setUpdatedat(date);
		loanDetails.setLoanid(loanid);
		RegisterLoanResponse registerLoan = service.RegisterLoan(loanDetails);
		assertEquals("Customer Does not Exixts", registerLoan.getMessage());
	}
	
	@Test
	public void registerloan() throws SQLException, IOException {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		int loantype = rand.nextInt(1000) + 1;
		RegisterLoanDetail loanDetails = new RegisterLoanDetail();
		loanDetails.setDuration("2months");
		loanDetails.setUser_name("bala");
		loanDetails.setLoan_amount("2lacks");
		loanDetails.setLoan_type(Integer.toString(loantype));
		loanDetails.setRateofint("12");
		loanDetails.setUpdatedby("venkatareddy");
		loanDetails.setUpdatedat(date);
		loanDetails.setLoanid(loanid);
		RegisterLoanResponse registerLoan = service.RegisterLoan(loanDetails);
		assertEquals("The Loan is Registered", registerLoan.getMessage());
	}
	/*
	 * @Test public void registerloanexsists() throws SQLException, IOException {
	 * java.sql.Timestamp date = new java.sql.Timestamp(new
	 * java.util.Date().getTime()); Random rand = new Random(); int loanid =
	 * rand.nextInt(1000) + 1; int loantype = rand.nextInt(1000) + 1;
	 * RegisterLoanDetail loanDetails = new RegisterLoanDetail();
	 * loanDetails.setDuration("2months"); loanDetails.setUser_name("bala");
	 * loanDetails.setLoan_amount("179"); loanDetails.setLoan_type("962");
	 * loanDetails.setRateofint("12"); loanDetails.setUpdatedby("venkatareddy");
	 * loanDetails.setUpdatedat(date); loanDetails.setLoanid(loanid);
	 * RegisterLoanResponse registerLoan = service.RegisterLoan(loanDetails);
	 * assertEquals("This particular loan type already exixts for the customer",
	 * registerLoan.getMessage()); }
	 */
	
	@Test
	public void durationchck() throws SQLException, IOException {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		RegisterLoanDetail loanDetails = new RegisterLoanDetail();
		loanDetails.setDuration("");
		loanDetails.setUser_name("xyz");
		loanDetails.setLoan_amount("2lacks");
		loanDetails.setLoan_type("house");
		loanDetails.setRateofint("12");
		loanDetails.setUpdatedby("venkatareddy");
		loanDetails.setUpdatedat(date);
		loanDetails.setLoanid(loanid);
		RegisterLoanResponse registerLoan = service.RegisterLoan(loanDetails);
		assertEquals("Loan Duration cannot be blank", registerLoan.getMessage());
	}
	
	@Test
	public void usrnamchck() throws SQLException, IOException {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		RegisterLoanDetail loanDetails = new RegisterLoanDetail();
		loanDetails.setDuration("dur");
		loanDetails.setUser_name("");
		loanDetails.setLoan_amount("2lacks");
		loanDetails.setLoan_type("house");
		loanDetails.setRateofint("12");
		loanDetails.setUpdatedby("venkatareddy");
		loanDetails.setUpdatedat(date);
		loanDetails.setLoanid(loanid);
		RegisterLoanResponse registerLoan = service.RegisterLoan(loanDetails);
		assertEquals("User name cannot be blank", registerLoan.getMessage());
	}
	
	@Test
	public void loanchck() throws SQLException, IOException {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		RegisterLoanDetail loanDetails = new RegisterLoanDetail();
		loanDetails.setDuration("dur");
		loanDetails.setUser_name("nam");
		loanDetails.setLoan_amount("");
		loanDetails.setLoan_type("house");
		loanDetails.setRateofint("12");
		loanDetails.setUpdatedby("venkatareddy");
		loanDetails.setUpdatedat(date);
		loanDetails.setLoanid(loanid);
		RegisterLoanResponse registerLoan = service.RegisterLoan(loanDetails);
		assertEquals("Loan Amount cannot be blank", registerLoan.getMessage());
	}
	
	@Test
	public void loantypchck() throws SQLException, IOException {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		RegisterLoanDetail loanDetails = new RegisterLoanDetail();
		loanDetails.setDuration("dur");
		loanDetails.setUser_name("nam");
		loanDetails.setLoan_amount("w");
		loanDetails.setLoan_type("");
		loanDetails.setRateofint("12");
		loanDetails.setUpdatedby("venkatareddy");
		loanDetails.setUpdatedat(date);
		loanDetails.setLoanid(loanid);
		RegisterLoanResponse registerLoan = service.RegisterLoan(loanDetails);
		assertEquals("Loan Type cannot be blank", registerLoan.getMessage());
	}
	
	@Test
	public void loanroichck() throws SQLException, IOException {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		RegisterLoanDetail loanDetails = new RegisterLoanDetail();
		loanDetails.setDuration("dur");
		loanDetails.setUser_name("nam");
		loanDetails.setLoan_amount("s");
		loanDetails.setLoan_type("qa");
		loanDetails.setRateofint("");
		loanDetails.setUpdatedby("venkatareddy");
		loanDetails.setUpdatedat(date);
		loanDetails.setLoanid(loanid);
		RegisterLoanResponse registerLoan = service.RegisterLoan(loanDetails);
		assertEquals("Rate of Interest cannot be blank", registerLoan.getMessage());
	}
	

}
