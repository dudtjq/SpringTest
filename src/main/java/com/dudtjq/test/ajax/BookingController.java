package com.dudtjq.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		Date day = new Date();
		
		model.addAttribute("day", day);
		
		String dateString = "2025-09-20";
		model.addAttribute("dateString", dateString);
		
		
		return "ajax/booking/bookingList";

		
	}	
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addBooking(
			@RequestParam("name") String name
			, @DateTimeFormat(pattern="yyyy년 MM월 dd일") 
			@RequestParam("date") Date date	
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber
			) {
		
		int count = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
 		
		return resultMap;
	}	
		
		
	@GetMapping("delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		
		int count = bookingBO.deleteBooking(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	@GetMapping("/check")
	public Map<String, String> checkBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber
			, Model model) {
		
		int count = bookingBO.checkBooking(name, phoneNumber);
		
		model.addAttribute("name", name);
		model.addAttribute("phoneNumber", phoneNumber);
		 
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
		
		
	}
	
		
		

	@GetMapping("/site")
	public String bookingSite() {
		
		return "ajax/booking/bookingSite";
		
	}
	
	
	@GetMapping("/input")
	public String inputBooking() {
		
		return "ajax/booking/bookingReservation";
		
	}
}
