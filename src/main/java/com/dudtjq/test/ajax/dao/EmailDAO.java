package com.dudtjq.test.ajax.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dudtjq.test.ajax.model.Email;

@Repository
public interface EmailDAO {

	public List<Email> selectEmailList();
	
}