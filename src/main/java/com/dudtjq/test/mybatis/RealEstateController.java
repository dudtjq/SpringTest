package com.dudtjq.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dudtjq.test.mybatis.bo.RealEstateBO;
import com.dudtjq.test.mybatis.model.RealEstate;

@Controller
public class RealEstateController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	@ResponseBody
	@RequestMapping("/mybatis/test01/1")
	public RealEstate realEstate(@RequestParam(value="id", defaultValue="3") int id	) {
		
		RealEstate realEstate = realEstateBO.getRealEstate(id);
		
		return realEstate;
		
	}
	
	@RequestMapping("/mybatis/test01/2")
	public realEstateRentPrice() {
		
	}
	
}
