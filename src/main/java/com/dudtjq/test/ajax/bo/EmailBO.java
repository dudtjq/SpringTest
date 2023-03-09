package com.dudtjq.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudtjq.test.ajax.dao.EmailDAO;
import com.dudtjq.test.ajax.model.Email;

@Service
public class EmailBO {

	@Autowired
	private EmailDAO emailDAO;
	
	public List<Email> getEmailList(){
		
		return emailDAO.selectEmailList();
		
	}
	
	public int addEmail(String name, String url) {
		return emailDAO.insertEmail(name, url);
	}
	
	public boolean isDuplicateUrl(String url) {
		
		int count = emailDAO.selectCountUrl(url);
		
		if(count == 0) {
			// 중복이 안된 것임
			return false;
		}else {
			return true;
		}
		
	}
	
}
