package com.dudtjq.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dudtjq.test.mybatis.bo.RealEstateBO;
import com.dudtjq.test.mybatis.model.RealEstate;

@Controller
@RequestMapping("/mybatis")
public class RealEstateController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	@ResponseBody
	@RequestMapping("/test01/1")
	public RealEstate realEstate(@RequestParam(value="id", defaultValue="3") int id	) {
		
		RealEstate realEstate = realEstateBO.getRealEstate(id);
		
		return realEstate;
		
	}
	// 월세 가격
	@ResponseBody
	@RequestMapping("/test01/2")
	public List<RealEstate> realEstateRentPrice(@RequestParam(value="rent", required=false) int rent) {
	
		List<RealEstate> realEstateList = realEstateBO.getRealEstateRentPrice(rent);
		
		return realEstateList;
		
	}
	// 평수와 가격
	@ResponseBody
	@RequestMapping("/test01/3")
	public List<RealEstate> realEstateAreaPrice(
			@RequestParam(value="area", required=false) int area
			, @RequestParam(value="price", required=false) int price) {
		
		return realEstateBO.getRealEstateAreaPrice(area, price);
		
	}
	@ResponseBody
	@RequestMapping("/test02/1")
	public String addRealEstate(){
	
		// 객체를 사용하여 insert 하기!
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		
		int count = realEstateBO.addRealEstateByObject(realEstate);
		
		return "입력 성공 : " + count;
	}
	
	// 객체 없이 insert 하기
	@ResponseBody
	@RequestMapping("/test02/2")
	public String addRealEstate(@RequestParam("realtorId") int realtorId) {
		
		int count = realEstateBO.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		 
		return "입력 결과 : " + count;
	}
	
}
