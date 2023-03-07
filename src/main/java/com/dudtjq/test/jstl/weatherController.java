package com.dudtjq.test.jstl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dudtjq.test.jstl.bo.WeatherhistoryBO;
import com.dudtjq.test.jstl.model.Weatherhistory;

@Controller
@RequestMapping("/jstl")
public class weatherController {

	@Autowired
	private WeatherhistoryBO weatherhistoryBO;
	
	@GetMapping("/test05")
//	@ResponseBody
	public String test01(Model model) {
		
		List<Weatherhistory> weatherhistoryList = weatherhistoryBO.getWeatherhistoryList();
			
		model.addAttribute("weatherhistoryList", weatherhistoryList);
		
		Date today = new Date();
		
		model.addAttribute("today", today);
		
		String dateString = "Wed Jul 01 00:00:00 KST 2015";
		model.addAttribute("dateString", dateString);
		
		return "jstl/test05";
			
		}
	
	@GetMapping("/add")
	@ResponseBody
	public String addWeather(
			@DateTimeFormat(pattern="yyyy-MM-dd")
			@RequestParam("date") Date date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed
			) {
		
		int count = weatherhistoryBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "삽입결과 : " + count;
		
	}
		

	
		
	}
	

