package com.loan.registerloan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loan.registerloan.models.CustomerUpdateDetail;
import com.loan.registerloan.models.RegisterLoanDetail;


public interface RegisterLoanRepository extends JpaRepository<RegisterLoanDetail, String> {

	@Query("select cust from CustomerUpdateDetail cust where cust.user_name=?1")
	public List<CustomerUpdateDetail> loanUserDetailsCount(String user_name);
	@Query("select cust from RegisterLoanDetail cust where cust.user_name=?1 and cust.loan_type=?2")
	public List<RegisterLoanDetail> loanUserDetailsCheck(String user_name,String loan_type);
}
