package com.dudtjq.test.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudtjq.test.mybatis.dao.RealEstateDAO;
import com.dudtjq.test.mybatis.model.RealEstate;

@Service
public class RealEstateBO {

	@Autowired 
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstateDAO.selectRealEstate(id);
		
		return realEstate;
	}
	
	public getRealEstateRentPrice() {
		
	}
	
	
}
