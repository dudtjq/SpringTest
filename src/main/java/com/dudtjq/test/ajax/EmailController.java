package com.dudtjq.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dudtjq.test.ajax.bo.EmailBO;
import com.dudtjq.test.ajax.model.Email;

@Controller
@RequestMapping("/ajax/email")
public class EmailController {

	@Autowired
	private EmailBO emailBO;
	
	@GetMapping("email")
	public List<Email> emailList(Model model) {
		
		List<Email> emailList = emailBO.getEmailList();
		
		model.addAttribute("emailList", emailList);
		
		return emailList;
		
	}
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addEmail(
			@RequestParam("name") String name
			, @RequestParam("url") String url	
			) {
		
		int count = emailBO.addEmail(name, url);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
 		
		return resultMap;
		
		
	}
	
	@GetMapping("/input")
	public String inputEmail() {
		return "ajax/email/emailInput";
		
	}
	
	@PostMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if(emailBO.isDuplicateUrl(url)) {
			// 중복
			resultMap.put("is_duplicate", true);
		}else {
			// 중복 x
			resultMap.put("is_duplicate", false);
		}
		
		return resultMap;
		
	}
	
}
