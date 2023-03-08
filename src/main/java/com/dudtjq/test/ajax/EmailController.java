package com.dudtjq.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dudtjq.test.ajax.bo.EmailBO;
import com.dudtjq.test.ajax.model.Email;

@Controller
@RequestMapping("/ajax/email")
public class EmailController {

	@Autowired
	private EmailBO emailBO;
	
	@GetMapping("email")
	public String emailList(Model model) {
		
		List<Email> emailList = emailBO.getEmailList();
		
		model.addAttribute("emailList", emailList);
		
		return "ajax/email/email";
		
	}
	
	@GetMapping("/input")
	public String inputEmail() {
		return "ajax/email/emailInput";
		
	}
	
}
