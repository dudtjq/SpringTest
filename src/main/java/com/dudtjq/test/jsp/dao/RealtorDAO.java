package com.dudtjq.test.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dudtjq.test.jsp.model.Realtor;

@Repository
public interface RealtorDAO {
	
	public int insertRealtor(
			@Param("office") String office
			, @Param("phoneNumber") String phoneNumber
			, @Param("address") String address
			, @Param("grade") String grade
			);

	public int insertUserByObject(Realtor realtor);

}
