package com.customer.updation.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customer.updation.models.CustomerUpdationDetail;
@Repository
public interface CustomerUpdationRepository extends JpaRepository<CustomerUpdationDetail, String> {

	@Query("select cust from CustomerUpdationDetail cust where cust.user_name=?1")
	public List<CustomerUpdationDetail> custUserNameCount(String user_name);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update CustomerUpdationDetail c set c.first_name = :first_name  , c.address = :address , c.email = :email, c.pan = :pan , c.dob = :dob ,updatedby = :updatedby , updatedat = :updatedat where c.user_name = :user_name")
	public void updateCustomerDetails(@Param("user_name") String user_name, @Param("first_name") String first_name,
			@Param("address") String address, @Param("email") String email, @Param("pan") String pan,
			@Param("dob") String dob, @Param("updatedby") String updatedby, @Param("updatedat") Timestamp updatedat);
}
