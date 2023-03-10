package com.dudtjq.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dudtjq.test.ajax.bo.BookingBO;
import com.dudtjq.test.ajax.model.Booking;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingBO.bookigList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/booking/bookingList";

		
	}	
	
	
	@GetMapping("/site")
	public String bookingSite() {
		
		return "ajax/booking/bookingSite";
		
	}
}
