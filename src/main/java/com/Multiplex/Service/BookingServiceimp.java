package com.Multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Model.Booking;
import com.Multiplex.Repository.BookingDAO;

@Service
public class BookingServiceimp implements IBookingService {
	
	@Autowired
	BookingDAO dao;

	public Booking addBooking(Booking booking) {
		Booking mv = dao.save(booking);
		return mv;

	}

	@Override
	public Optional<Booking> findByBookingId(int bookingId) {
		return dao.findById(bookingId);
	}

}
