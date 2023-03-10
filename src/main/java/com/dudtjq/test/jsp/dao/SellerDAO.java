package com.dudtjq.test.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dudtjq.test.jsp.model.Seller;

@Repository
public interface SellerDAO {
	
	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("temperature") double temperature
			, @Param("profileImage") String profileImage
			);
	
	public Seller selectLastSeller();
	
	public Seller getSeller(@Param("id") int id);

}
