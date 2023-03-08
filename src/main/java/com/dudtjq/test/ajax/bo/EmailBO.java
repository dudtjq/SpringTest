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
	
}
