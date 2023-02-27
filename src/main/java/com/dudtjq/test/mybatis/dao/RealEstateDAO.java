package com.dudtjq.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dudtjq.test.mybatis.model.RealEstate;

@Repository
public interface RealEstateDAO {

	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateRentPrice(@Param("rent") int rent);
	
	public List<RealEstate> selectRealEstateAreaPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	// 객체로 insert 
	public int insertRealEstateByObject(RealEstate realEstate);
	
	// 객체 없이 insert
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice
			);
	
	public int updateRealEstate(@Param("id") int id,
								@Param("type") String type,
								@Param("price") int price);
	
	public int deleteRealEstate(@Param("id") int id);
	
		
	
}



