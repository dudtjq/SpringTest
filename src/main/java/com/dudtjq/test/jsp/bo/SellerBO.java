package com.dudtjq.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudtjq.test.jsp.dao.SellerDAO;
import com.dudtjq.test.jsp.model.Seller;

@Service
public class SellerBO {

	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(String nickname, double temperature, String profileImage) {
		
		return sellerDAO.insertSeller(nickname, temperature, profileImage);
		
	}
	
	public Seller getLastSeller() {
		
		return sellerDAO.selectLastSeller();
		
	}
	
}
