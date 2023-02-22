package com.dudtjq.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test02Contorller {

	// 인터넷쪽 localhost 검색시 사용할 주소
	@RequestMapping("lifecycle/test02")
	public String jspTest() {
		// jsp 경로임
		return "lifecycle/test02";
		
	}
	
}
