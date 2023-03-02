package com.dudtjq.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudtjq.test.jsp.dao.RealtorDAO;
import com.dudtjq.test.jsp.model.Realtor;

@Service
public class RealtorBO {

	@Autowired
	private RealtorDAO realtorDAO;
	
	public int addRealtor(String office, String phoneNumber, String address, String grade) {
		
		return realtorDAO.insertRealtor(office, phoneNumber, address, grade);
		
	}
	
	public int addRealtorObject(Realtor realtor) {
		
		return realtorDAO.insertUserByObject(realtor);
		
	}
	
}
