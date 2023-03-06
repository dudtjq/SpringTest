package com.dudtjq.test.jstl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class weatherController {

	@GetMapping("/test05")
	public String test01() {
	
		return "jstl/test05";
		
	}
	
}
