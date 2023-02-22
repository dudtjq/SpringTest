package com.dudtjq.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dudtjq.test.database.bo.StoreBO;
import com.dudtjq.test.database.model.Store;

@Controller
public class StoreController {

	@Autowired
	private StoreBO StoreBO;
	
	@RequestMapping("/database/test01")
	@ResponseBody
	public List<Store> test01() {
		
		// used_goods 목록 가지고 오기
		List<Store> storeList = StoreBO.getStoreList();
		
		return storeList;
		
		
	}
	
}
