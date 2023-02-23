package com.dudtjq.test.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudtjq.test.database.dao.StoreDAO;
import com.dudtjq.test.database.model.Store;

@Service
public class StoreBO {
	
	// springframework에게 맡김
	@Autowired
	private StoreDAO storeDAO;
	
	// store 모든 데이터 조회 리턴 메소드
	public List<Store> getStoreList() {
		
		List<Store> storeList = storeDAO.selectStoreList();
		
		return storeList;
		
		
	}
}
