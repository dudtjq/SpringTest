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
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.checkedBooking(name, phoneNumber);
//		{
//        "result":"success", 
//		  "info": {
	//		"id": 7,
	//		"name": "황찬성",
	//		"headcount": 25,
	//		"day": 1,
	//		"date": "2025-09-10T15:00:00.000+00:00",
	//		"phoneNumber": "010-0000-2222",
	//		"state": "확정",
	//		"createdAt": "2023-01-25T09:10:56.000+00:00",
	//		"updatedAt": "2023-01-25T09:10:56.000+00:00"
//		   }
//		}
		Map<String, Object> resultMap = new HashMap<>();
		// 조회 성공 : {"result":"success", "info":booking}
		// 조회 실패 : {"result":"fail"}
		if(booking != null) {
			resultMap.put("result", "success");
			resultMap.put("info", booking);
		} else {
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
