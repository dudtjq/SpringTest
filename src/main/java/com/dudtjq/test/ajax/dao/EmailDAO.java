package com.dudtjq.test.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dudtjq.test.ajax.model.Email;

@Repository
public interface EmailDAO {

	public List<Email> selectEmailList();
	
	public int insertEmail(
			@Param("name") String name
			, @Param("url") String url);
	
	public int selectCountUrl(@Param("url") String url);
	
	public int deleteEmail(@Param("id") int id);
	
}