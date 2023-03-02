package com.dudtjq.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dudtjq.test.jsp.bo.RealtorBO;
import com.dudtjq.test.jsp.model.Realtor;

@Controller
@RequestMapping("/jsp/realtor")
public class RealtorController {

	@Autowired
	private RealtorBO realtorBO;
	
	@PostMapping("/add")
//	@ResponseBody
	public String addRealtor(
//			@RequestParam("office") String office
//			, @RequestParam("phoneNumber") String phoneNumber
//			, @RequestParam("address") String address
//			, @RequestParam("grade") String grade
			@ModelAttribute Realtor realtor
			, Model model) {
		
//		int count = realtorBO.addRealtor(office, phoneNumber, address, grade);
//		
//		return "수행결과 : " + count;
		
//		Realtor realtor = new Realtor();
//		realtor.setOffice(office);
//		realtor.setPhoneNumber(phoneNumber);
//		realtor.setAddress(address);
//		realtor.setGrade(grade);
		
	 	int count = realtorBO.addRealtorObject(realtor);
	 	
	 	model.addAttribute("realtor", realtor);
	 	
	 	return "jsp/realtor";
	 	
		
	 	
	}
	
	@GetMapping("/realtor/realtor")
	public String realtor() {
		
		return "jsp/realtor";
	}
	
	@GetMapping("/realtor/Input")
	public String realtorInput() {
		
		return "jsp/realtorInput";
	}
	
}
