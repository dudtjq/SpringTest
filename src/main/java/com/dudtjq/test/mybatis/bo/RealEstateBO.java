package com.dudtjq.test.mybatis.bo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	

	public List<RealEstate> getRealEstateRentPrice(int rent) {
	
		List<RealEstate> realEstateList = realEstateDAO.selectRealEstateRentPrice(rent);
		
		return realEstateList;
		
	}
	
	public List<RealEstate> getRealEstateAreaPrice(int area, int price) {
		// 위에 사용된것이 있으므로 중복이 될꺼 같으면 바로 리턴이 가능하다! 
		return realEstateDAO.selectRealEstateAreaPrice(area, price);

	}
	
	// 객체로 insert
	public int addRealEstateByObject(RealEstate realEstate) {
		
		return realEstateDAO.insertRealEstateByObject(realEstate);
		
	}
	
	// 객체 없이 insert
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		
		return realEstateDAO.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		
	}
	
	public int updateRealEstate(int id, String type, int price) {
		
		return realEstateDAO.updateRealEstate(id, type, price);
	}
	
	public int deleteRealEstate(int id) {
		
		return realEstateDAO.deleteRealEstate(id);
		
	}
	
}
