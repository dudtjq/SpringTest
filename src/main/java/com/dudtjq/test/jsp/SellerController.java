package com.dudtjq.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dudtjq.test.jsp.bo.SellerBO;
import com.dudtjq.test.jsp.model.Seller;


@Controller
@RequestMapping("/jsp/seller")
public class SellerController {

	@Autowired
	private SellerBO sellerBO; 
	
	@PostMapping("/add")
	@ResponseBody
	public String addSeller(
				@RequestParam("nickname") String nickname
				, @RequestParam("temperature") double temperature
				, @RequestParam("profileImage") String profileImage
				) {
		
		int count = sellerBO.addSeller(nickname, temperature, profileImage);
		
		return "삽입 결과 : " + count;
		 
	}
	
	@GetMapping("/seller/Input")
	public String sellerInput() {
		
		return "jsp/sellerInput";
	}
	
	// Integer 는 숫자로도 객체로도 비교가 가능 하다. int는 객체 비교가 안됨!
	Seller seller = null;
	@GetMapping("/sellerInfo")
	public String seller(Model model, @RequestParam(value="id", required=false) Integer id) {
		
		if(id != null) {
			
			seller = sellerBO.getSeller(id);
			
		}else {
			
			seller = sellerBO.getLastSeller();
			
		}
		
		model.addAttribute("seller", seller);
	
		return "jsp/seller";
		
		
	}
	
	
	
	
	
	
	
	
}
