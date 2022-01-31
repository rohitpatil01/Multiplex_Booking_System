package com.Multiplex.Service;

import java.util.Optional;

import com.Multiplex.Model.Booking;

public interface IBookingService {

	public Booking addBooking(Booking booking);

	public Optional<Booking> findByBookingId(int bookingId);

}
