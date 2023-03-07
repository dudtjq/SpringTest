package com.dudtjq.test.jstl.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dudtjq.test.jstl.model.Weatherhistory;

@Repository
public interface weatherhistoryDAO {

		public List<Weatherhistory> selectWeatherhistory();
		
		public int insertWeather(
				@Param("date") Date date
					, @Param("weather") String weather
					, @Param("temperatures") double temperatures
					, @Param("precipitation") double precipitation
					, @Param("microDust") String microDust
					, @Param("windSpeed") double windSpeed
				);
	
}

