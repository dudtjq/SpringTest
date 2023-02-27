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
	
	@GetMapping("/seller")
	public String seller(Model model) {
		
		Seller lastSeller = sellerBO.getLastSeller();
		
		model.addAttribute("seller", lastSeller);
		
		return "jsp/seller";
	}
	
	@GetMapping("/seller/Input")
	public String sellerInput() {

		return "jsp/sellerInput";
	}
	
	
	
	
	
	
}
