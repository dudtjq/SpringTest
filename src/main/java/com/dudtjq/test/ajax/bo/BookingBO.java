package com.dudtjq.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudtjq.test.ajax.dao.BookingDAO;
import com.dudtjq.test.ajax.model.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingDAO bookingDAO;
	
	public List<Booking> bookigList() {
		
	 	 return bookingDAO.selectBookingList();
		
	}
	
}
