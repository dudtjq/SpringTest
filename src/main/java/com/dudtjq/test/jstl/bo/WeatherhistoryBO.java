package com.dudtjq.test.jstl.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudtjq.test.jstl.dao.weatherhistoryDAO;
import com.dudtjq.test.jstl.model.Weatherhistory;

@Service
public class WeatherhistoryBO {

	@Autowired
	private weatherhistoryDAO weatherhistoryDAO;
	
	public List<Weatherhistory> getWeatherhistoryList(){
		
		List<Weatherhistory> weatherhistoryList = weatherhistoryDAO.selectWeatherhistory();
		
		return weatherhistoryList;
		
	}
	
	public int addWeather(
			Date date
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed
			) {
		
		return weatherhistoryDAO.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		
	}
	
	
	
}
