package com.dudtjq.test.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dudtjq.test.database.model.Store;


// DAO를 통해 database를 조회 한다.
// 쿼리 사용
@Repository
public interface StoreDAO {

	public List<Store> selectStoreList();
	
}
